package com.example.LOG.repository;

import com.example.LOG.entity.Api_logs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface LogRepository extends JpaRepository<Api_logs, String> {
    Page<Api_logs> findByrequestUrl(String requestUrl, Pageable pageable);
    Page<Api_logs> findBytimestampBetween(LocalDateTime startDateTime, LocalDateTime endDateTime, Pageable pageable);

}
