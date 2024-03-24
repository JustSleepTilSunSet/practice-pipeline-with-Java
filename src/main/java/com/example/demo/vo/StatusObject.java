package com.example.demo.vo;


public class StatusObject {
    private String status = "0";
    private String message = "";
    private int id = 0;

    public StatusObject setStatus(String status) {
        this.status = status;
        return this;
    }

    public StatusObject setMessage(String message) {
        this.message = message;
        return this;
    }

    public StatusObject setId(int id) {
        this.id = id;
        return this;
    }
    public String getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public int getId() {
        return this.id;
    }
}