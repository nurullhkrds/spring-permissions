package spring.permission.auth;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.permission.Core.utilities.DataResult;
import spring.permission.Core.utilities.Result;

import spring.permission.security.dto.CreateUserRequest;
import spring.permission.security.services.AuthService;




@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);
    private final AuthService authService;


    @PostMapping("/register")
    public Result addUser(@RequestBody CreateUserRequest request) {
        return authService.createUser(request);
    }



    @PostMapping("/authenticate")
    public DataResult<String> authenticate(@RequestBody  AuthenticationRequest request) {
        return authService.authenticate(request);
    }







}
