package com.example.LOG.repository;

import com.example.LOG.entity.Api_logs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<Api_logs, String> {
}
