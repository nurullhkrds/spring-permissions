package spring.permission.Core.utilities;

import spring.permission.Core.constant.Response;

public class DataResult <T> extends Result{
    private T data;


    public DataResult(boolean success, Response message, T data, int statusCode) {
        super(success, message,statusCode);
        this.data=data;
    }



    public T getData() {
        return this.data;
    }
}
