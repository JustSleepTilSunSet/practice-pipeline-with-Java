package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.vo.StatusObject;
import com.example.demo.dao.TestTableService;
import com.example.demo.models.TestTable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:8787/")
public class ApiController {
    @Autowired
    TestTableService ts;

    @PostMapping("/insert")
    public StatusObject postMethodName(@RequestBody StatusObject entity) {
        System.out.println("Received status"+entity.getStatus()+" Message: "+entity.getMessage());
        System.out.println(ts.findAll().size());
        for (TestTable t : ts.findAll()){
            System.out.println(t.getMessage());
        }
        ts.insert(entity);
        return entity;
    }

    @PostMapping("/update")
    public StatusObject updateMethodName(@RequestBody StatusObject entity) {
        System.out.println(
                "Received status" + entity.getStatus() + " Message: " + entity.getMessage() + "Id:" + entity.getId());
        ts.update(entity);
        return entity;
    }

}
