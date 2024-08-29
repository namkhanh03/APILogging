package com.example.LOG.service;

import com.example.LOG.entity.Api_logs;
import org.springframework.data.domain.Page;

public interface LogService {
    Page<Api_logs> getLogs(int page, int size);

    Page<Api_logs> getLogsBymethod(String method, int page, int size);
}

