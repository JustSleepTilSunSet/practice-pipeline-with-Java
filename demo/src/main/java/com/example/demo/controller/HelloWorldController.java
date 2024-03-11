package com.example.demo.controller;

import com.example.demo.vo.StdResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
// import com.example.demo.enums.StdResConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(origins = "http://localhost:8787/")
public class HelloWorldController {
    @Autowired
    StdResponse res;
    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<StdResponse> health()  throws Exception{
        try {
            // healthRes
                // .setMessage("Health")
                // .setStatus(StdResConstants.API_SUCCESS);
            StdResponse resObj = res.getSuccess("Health");
            return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(resObj);
        } catch (Exception ex) {
            ex.printStackTrace();
            // healthRes
                // .setMessage("Server throws exception.")
                // .setStatus(StdResConstants.API_FAIL);
            StdResponse resObj = res.getFail("Server throws exception.");
            return ResponseEntity.badRequest()
                .contentType(MediaType.APPLICATION_JSON)
                .body(resObj);
        }
    }

}
