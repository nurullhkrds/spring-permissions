package spring.permission.Core.utilities;


import spring.permission.Core.constant.Response;

public class SuccesDataResult<T> extends DataResult<T>{

    public SuccesDataResult(Response message, T data, int statusCode) {
        super(true, message, data, statusCode);
    }



}
