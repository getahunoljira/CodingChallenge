package com.exercise.codingchallenge.controller;


import com.exercise.codingchallenge.model.EmailList;
import com.exercise.codingchallenge.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/unique")
    public Integer  getUniqueCount(@RequestBody EmailList emailList) {
        return emailService.getUniqueCount(emailList.getEmails());
    }


}
