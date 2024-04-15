package spring.permission.security.dto;


public record AuthRequest (
        String username,
        String password
){
}
