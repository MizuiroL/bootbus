package com.mizuiro.bootbus.dao;

import com.mizuiro.bootbus.exceptions.EntityNotFoundException;
import com.mizuiro.bootbus.model.CalendarDate;

import java.time.LocalDate;
import java.util.List;

public interface CalendarDateDao {
    int addCalendarDate(CalendarDate calendarDate);

    List<CalendarDate> getAllCalendarDates();
    List<CalendarDate> getCalendarDatesById(String serviceId) throws EntityNotFoundException;
    List<CalendarDate> getServicesByDate(LocalDate date);
}
