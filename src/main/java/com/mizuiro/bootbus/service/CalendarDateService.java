package com.mizuiro.bootbus.service;

import com.mizuiro.bootbus.dao.CalendarDateDao;
import com.mizuiro.bootbus.model.CalendarDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CalendarDateService {
    private final CalendarDateDao calendarDateDao;

    @Autowired
    public CalendarDateService(@Qualifier("calendarDatePostgres") CalendarDateDao calendarDateDao) {
        this.calendarDateDao = calendarDateDao;
    }

    public int addCalendarDate(CalendarDate calendarDate) {
        return calendarDateDao.addCalendarDate(calendarDate);
    }

    public List<CalendarDate> getAllCalendarDates() {
        return calendarDateDao.getAllCalendarDates();
    }

    public List<CalendarDate> getCalendarDatesById(String serviceId) {
        return calendarDateDao.getCalendarDatesById(serviceId);
    }

    public List<CalendarDate> getServicesByDate(String date) {
        return calendarDateDao.getServicesByDate(LocalDate.parse(date));
    }

}
