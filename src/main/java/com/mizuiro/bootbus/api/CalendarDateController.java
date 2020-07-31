package com.mizuiro.bootbus.api;

import com.mizuiro.bootbus.model.CalendarDate;
import com.mizuiro.bootbus.service.CalendarDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/calendardate")
@RestController
public class CalendarDateController {
    private final CalendarDateService calendarDateService;

    @Autowired
    public CalendarDateController(CalendarDateService calendarDateService) {
        this.calendarDateService = calendarDateService;
    }

    @PostMapping
    public int addCalendarDate(@NonNull @RequestBody CalendarDate date) {
        return calendarDateService.addCalendarDate(date);
    }

    @GetMapping
    public List<CalendarDate> getAllCalendarDates() {
        return calendarDateService.getAllCalendarDates();
    }

    @GetMapping(path = "{serviceId}")
    public List<CalendarDate> getCalendarDateById(@PathVariable("serviceId") String serviceId) {
        return calendarDateService.getCalendarDatesById(serviceId);
    }

    @GetMapping(path = "by-date/{date}")
    public List<CalendarDate> getServicesByDate(@PathVariable("date") String date) {
        return calendarDateService.getServicesByDate(date);
    }
}
