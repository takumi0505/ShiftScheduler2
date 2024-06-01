package com.example.shiftscheduler.dto;

import java.time.LocalDate;
import java.util.List;

public class ShiftRequest {
    private List<LocalDate> dates;
    private List<Long> userIds;

    // Getters and Setters
    public List<LocalDate> getDates() {
        return dates;
    }

    public void setDates(List<LocalDate> dates) {
        this.dates = dates;
    }

    public List<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }
}
