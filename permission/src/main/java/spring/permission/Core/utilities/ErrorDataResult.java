package spring.permission.Core.utilities;

import spring.permission.Core.constant.Response;

public class ErrorDataResult<T> extends DataResult<T>{
    public ErrorDataResult(Response message, T data, int statusCode) {
        super(false, message, data, statusCode);
    }
}
