package com.example.LOG.service;

import com.example.LOG.entity.Api_logs;
import com.example.LOG.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    public List<Api_logs> getLogs(){
        return logRepository.findAll();
    }
}
