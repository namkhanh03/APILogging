package com.example.LOG.repository;

import com.example.LOG.entity.Api_logs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends PagingAndSortingRepository<Api_logs, String> {
    Page<Api_logs> findBymethod(String method, Pageable pageable);
}
