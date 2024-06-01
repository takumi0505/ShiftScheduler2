package com.example.shiftscheduler.repository;

import com.example.shiftscheduler.entity.ShiftRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ShiftRequestRepository extends JpaRepository<ShiftRequest, Long> {
    List<ShiftRequest> findByDate(LocalDate date);
}
