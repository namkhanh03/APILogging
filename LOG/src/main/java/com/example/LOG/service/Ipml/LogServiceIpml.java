package com.example.LOG.service.Ipml;

import com.example.LOG.entity.Api_logs;
import com.example.LOG.repository.LogRepository;
import com.example.LOG.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LogServiceIpml implements LogService {

    @Autowired
    private LogRepository logRepository;

    @Override
    public Page<Api_logs> getLogs(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return logRepository.findAll(pageable);
    }

    @Override
    public Page<Api_logs> getLogsBymethod(String method,int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return logRepository.findBymethod(method, pageable);
    }
}

