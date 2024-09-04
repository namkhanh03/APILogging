package com.example.LOG.service;

import com.example.LOG.entity.Api_logs;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

public interface LogService {
    Page<Api_logs> getLogs(int page, int size);

    Page<Api_logs> getLogsByrequestUrl(String requestUrl, int page, int size);
    Page<Api_logs> getLogsBytimestamp(LocalDateTime startDateTime, LocalDateTime endDateTime, int page, int size);
}

