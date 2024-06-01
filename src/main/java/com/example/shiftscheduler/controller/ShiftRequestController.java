package com.example.shiftscheduler.controller;

import com.example.shiftscheduler.entity.ShiftRequest;
import com.example.shiftscheduler.repository.ShiftRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/shift-requests")
public class ShiftRequestController {

    @Autowired
    private ShiftRequestRepository shiftRequestRepository;

    @PostMapping
    public ShiftRequest createShiftRequest(@RequestBody ShiftRequest shiftRequest) {
        return shiftRequestRepository.save(shiftRequest);
    }

    @GetMapping("/{date}")
    public List<ShiftRequest> getShiftRequestsByDate(@PathVariable LocalDate date) {
        return shiftRequestRepository.findByDate(date);
    }

    @GetMapping
    public List<ShiftRequest> getAllShiftRequests() {
        return shiftRequestRepository.findAll();
    }

    @GetMapping("/month/{yearMonth}")
    public List<ShiftRequest> getShiftRequestsByMonth(@PathVariable String yearMonth) {
        YearMonth ym = YearMonth.parse(yearMonth);
        LocalDate start = ym.atDay(1);
        LocalDate end = ym.atEndOfMonth();
        return shiftRequestRepository.findAll().stream()
                .filter(sr -> !sr.getDate().isBefore(start) && !sr.getDate().isAfter(end))
                .collect(Collectors.toList());
    }
}
