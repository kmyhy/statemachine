package com.statemachine;

public class BaseResponse {
    public boolean success;
    public String   message;
    public Object   data;

    public BaseResponse(){
        this.success = false;
    }

}
