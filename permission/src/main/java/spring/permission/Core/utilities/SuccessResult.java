package spring.permission.Core.utilities;

import spring.permission.Core.constant.Response;

public class SuccessResult extends Result{


    public SuccessResult(Response message, int statusCode) {
        super(true,message,statusCode);
    }


}
