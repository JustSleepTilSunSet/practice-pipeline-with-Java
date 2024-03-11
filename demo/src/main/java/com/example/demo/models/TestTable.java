package com.example.demo.models;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;

@Entity
@Table(name = "test_table")
public class TestTable {
    @Id
    private Long id;

    @Column(name = "status")
    private String status;
    @Column(name = "message")
    private String message;

    // getters and setters
    public String getStatus(){
        return status;
    }
    public String getMessage(){
        return message;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public void setId(Long id){
        this.id = id;
    }
}