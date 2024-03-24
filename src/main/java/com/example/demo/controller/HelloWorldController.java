package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(origins = "http://localhost:8787/")
public class HelloWorldController {
    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<String> health()  throws Exception{
        try {
            return new ResponseEntity<>("Hello World!", HttpStatus.OK);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity<>("Server thrown exception.", HttpStatus.BAD_REQUEST);
        }
    }

}
