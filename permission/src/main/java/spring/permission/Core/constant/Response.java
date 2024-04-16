package spring.permission.Core.constant;

public enum Response {

    SUCCESS("Success"),
    CREATED("Created"),
    REMOVED("Removed"),
    UPDATED("Updated"),
    DATALISTED("Data Listed"),


    USER_CREATED("User created"),
    USER_UPDATED("User updated"),
    USER_ALREADY_EXISTS("User already exists"),
    USER_NOT_CREATED("User not created"),


    LOGIN_SUCCESS("Login Success"),
    LOGIN_FAILED("Login Failed"),

    ERROR("Error"),
    NOT_FOUND("Not Found"),
    UNAUTHORIZED("Unauthorized"),
    FORBIDDEN("Forbidden"),
    BAD_REQUEST("Bad Request"),
    INTERNAL_SERVER_ERROR("Internal Server Error");

    private final String message;

    Response(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
