package com.example.demo.vo;


public class StatusObject {
    private String status = "0";
    private String message = "";

    public StatusObject setStatus(String status) {
        this.status = status;
        return this;
    }

    public StatusObject setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

}