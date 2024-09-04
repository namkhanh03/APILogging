package com.example.LOG.controller;

import com.example.LOG.entity.Api_logs;
import com.example.LOG.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    @GetMapping("/search-by-requestUrl")
    public Page<Api_logs> getLogsByrequestUrl(
            @RequestParam String requestUrl,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return logService.getLogsByrequestUrl(requestUrl, page, size);
    }

    @GetMapping("/search-by-timestamp")
    public Page<Api_logs> getLogsByTimestamp(
            @RequestParam(defaultValue = "2000-01-01 00:00:00") String startDateTimeStr,
            @RequestParam(defaultValue = "9999-12-31 23:59:59") String endDateTimeStr,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime startDateTime = LocalDateTime.parse(startDateTimeStr, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(endDateTimeStr, formatter);
        return logService.getLogsBytimestamp(startDateTime, endDateTime, page, size);
    }
}
