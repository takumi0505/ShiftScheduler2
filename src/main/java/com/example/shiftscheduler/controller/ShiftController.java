package com.example.shiftscheduler.controller;

import com.example.shiftscheduler.dto.ShiftRequest;
import com.example.shiftscheduler.entity.Shift;
import com.example.shiftscheduler.repository.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/shifts")
public class ShiftController {

    @Autowired
    private ShiftRepository shiftRepository;

    @PostMapping
    public Shift createShift(@RequestBody Shift shift) {
        return shiftRepository.save(shift);
    }

    @GetMapping("/{date}")
    public List<Shift> getShiftsByDate(@PathVariable LocalDate date) {
        return shiftRepository.findByDate(date);
    }

    @PostMapping("/auto-generate")
    public void autoGenerateShifts(@RequestBody ShiftRequest shiftRequest) {
        List<LocalDate> dates = shiftRequest.getDates();
        List<Long> userIds = shiftRequest.getUserIds();

        for (LocalDate date : dates) {
            for (Long userId : userIds) {
                Shift shift = new Shift();
                shift.setDate(date);
                shift.setUserId(userId);
                shiftRepository.save(shift);
            }
        }
    }
}
