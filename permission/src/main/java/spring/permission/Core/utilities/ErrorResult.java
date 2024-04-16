package spring.permission.Core.utilities;

import spring.permission.Core.constant.Response;

public class ErrorResult extends Result{

    public ErrorResult(Response message, int statusCode) {
        super(false, message, statusCode);
    }
}
