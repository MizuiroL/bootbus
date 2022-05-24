package com.mizuiro.bootbus.dao;

import com.mizuiro.bootbus.exceptions.EntityNotFoundException;
import com.mizuiro.bootbus.model.CalendarDate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository("calendarDateSql")
public class SqlCalendarDateDataAccessService implements CalendarDateDao {
    private final JdbcTemplate jdbcTemplate;

    public SqlCalendarDateDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addCalendarDate(CalendarDate calendarDate) {
        return 0;
    }

    @Override
    public List<CalendarDate> getAllCalendarDates() {
        String sqlQuery = "SELECT * FROM calendar_dates";
        return jdbcTemplate.query(sqlQuery, mapCalendarDate());
    }

    @Override
    public List<CalendarDate> getCalendarDatesById(String serviceId) throws EntityNotFoundException {
        String sqlQuery = "SELECT * FROM calendar_dates WHERE service_id='" + serviceId + "'";
        return jdbcTemplate.query(sqlQuery, mapCalendarDate());
    }

    @Override
    public List<CalendarDate> getServicesByDate(LocalDate date) {
        System.out.println(date.format(DateTimeFormatter.BASIC_ISO_DATE).toString());
        String sqlQuery = "SELECT * FROM calendar_dates WHERE date='" + date.format(DateTimeFormatter.BASIC_ISO_DATE) + "'";
        return jdbcTemplate.query(sqlQuery, mapCalendarDate());
    }

    private RowMapper<CalendarDate> mapCalendarDate() {
        return (resultSet, i) -> {
            String serviceId = resultSet.getString("service_id");
            LocalDate date = LocalDate.parse(resultSet.getString("date"), DateTimeFormatter.BASIC_ISO_DATE);
            int exceptionType = resultSet.getInt("exception_type");
            return new CalendarDate(serviceId, date, exceptionType);
        };
    }
}
