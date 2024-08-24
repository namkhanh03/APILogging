package com.example.LOG.controller;

import com.example.LOG.entity.Api_logs;
import com.example.LOG.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/logs")

public class LogController {

    @Autowired
    private LogService logService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    List<Api_logs> getLogs(){
        return logService.getLogs();
    }

}
