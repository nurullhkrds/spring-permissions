package spring.permission.auth;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.permission.entities.User;
import spring.permission.repository.UserRepository;
import spring.permission.security.dto.CreateUserRequest;
import spring.permission.security.services.JwtService;
import spring.permission.security.services.UserService;


@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository repository;

    @PostMapping("/register")
    public User addUser(@RequestBody CreateUserRequest request) {
        return userService.createUser(request);
    }



    @PostMapping("/authenticate")
    public String authenticate(AuthenticationRequest request) {

        authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        var user=repository.findByUsername(request.getUsername()).orElseThrow();
        var jwtToken=jwtService.generateToken(user.getUsername());
        return jwtToken;
    }






}
