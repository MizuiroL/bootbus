package com.mizuiro.bootbus.dao;

import com.mizuiro.bootbus.exceptions.TravelNotFoundException;
import com.mizuiro.bootbus.model.Travel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository("stopSql")
public class SqlTravelDataAccessService implements TravelDao {

    private final JdbcTemplate jdbcTemplate;
    private String sqlQuery;

    public SqlTravelDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Travel> getTravelTimes(String departureStopId, String arrivalStopId) throws TravelNotFoundException {
        return null;
    }

    private RowMapper<Travel> mapTravel() {
        return (resultSet, i) -> {
            String departureStopCode = resultSet.getString("departure_stop_code");
            String departureStopName = resultSet.getString("departure_stop_name");
            Time departureTime = resultSet.getTime("departure_time");
            String arrivalStopCode = resultSet.getString("arrival_stop_code");
            String arrivalStopName = resultSet.getString("arrival_stop_name");
            Time arrivalTime = resultSet.getTime("arrival_time");
            LocalDate date = LocalDate.parse(resultSet.getString("date"), DateTimeFormatter.BASIC_ISO_DATE);
            return new Travel(departureStopCode, departureStopName, departureTime, arrivalStopCode, arrivalStopName, arrivalTime, date);
        };
    }
}
