package com.example.demo.vo;

import org.springframework.stereotype.Component;

import com.example.demo.enums.StdResConstants;

@Component
public class StdResponse {
    private int status = 0;
    private String message = "";

    public StdResponse setStatus(int status) {
        this.status = status;
        return this;
    }

    public StdResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public int getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public StdResponse getSuccess(String msg) throws Exception{
        this.status = StdResConstants.API_SUCCESS;
        this.message = msg;
        return this;
    }
    public StdResponse getFail(String msg) {
        this.status = StdResConstants.API_FAIL;
        this.message = msg;
        return this;
    }
}
