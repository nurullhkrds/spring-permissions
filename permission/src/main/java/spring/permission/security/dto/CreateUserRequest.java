package spring.permission.security.dto;

import lombok.Builder;
import spring.permission.enums.Role;



@Builder
public record CreateUserRequest(
        String firstname,
        String lastname,
        String email,
        String username,
        String password,
        Role authorities
){
}
