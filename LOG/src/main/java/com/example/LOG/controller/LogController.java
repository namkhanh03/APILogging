package com.example.LOG.controller;

import com.example.LOG.entity.Api_logs;
import com.example.LOG.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {

    @Autowired
    private LogService logService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    Page<Api_logs> getLogs(@RequestParam(defaultValue = "0") int page,
                           @RequestParam(defaultValue = "10") int size){
        return logService.getLogs(page, size);
    }

    @GetMapping("/search")
    public Page<Api_logs> getLogsByID(
            @RequestParam String method,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return logService.getLogsBymethod(method, page, size);
    }
}
