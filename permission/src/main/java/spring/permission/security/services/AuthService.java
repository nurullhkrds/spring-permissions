package spring.permission.security.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import spring.permission.Core.constant.Response;
import spring.permission.Core.utilities.*;
import spring.permission.auth.AuthenticationRequest;
import spring.permission.entities.User;
import spring.permission.repository.UserRepository;
import spring.permission.security.dto.CreateUserRequest;

import java.util.Optional;

@Service
public class AuthService{


    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }


    public Result createUser(CreateUserRequest request) {

        if (userRepository.findByEmail(request.email()).isPresent()) {
            return new ErrorResult(Response.USER_ALREADY_EXISTS, 409);
        }
        User newUser = User.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .username(request.username())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(request.authorities())
                .build();
        userRepository.save(newUser);
        if (userRepository.findByEmail(request.email()).isPresent()) {
            return new SuccessResult(Response.USER_CREATED, 201);
        }
        return new ErrorResult(Response.USER_NOT_CREATED, 500);

    }


    public DataResult<String> authenticate (AuthenticationRequest request)
    {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        Optional<User> userOptional = userRepository.findByEmail(request.getUsername());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            var jwtToken = jwtService.generateToken(user.getUsername());
            return new SuccesDataResult<>(Response.LOGIN_SUCCESS, jwtToken, 200);
        } else {
            return new ErrorDataResult<>(Response.LOGIN_FAILED, null, 401);
        }
    }
}
