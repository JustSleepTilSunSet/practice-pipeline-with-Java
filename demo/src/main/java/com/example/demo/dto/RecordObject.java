package com.example.demo.dto;

public class RecordObject {
    private String status;
    private String message;
    // getters and setters
    public String getStatus(){
        return status;
    }
    public String getMessage(){
        return message;
    }

    public RecordObject setStatus(String status){
        this.status = status;
        return this;
    }

    public RecordObject setMessage(String message){
        this.message = message;
        return this;
    }

}
