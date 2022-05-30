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
        String sqlQuery = "SELECT deps.stop_code AS departure_stop_code, deps.stop_name AS departure_stop_name, partenza.departure_time AS departure_time, arrs.stop_code AS arrival_stop_code, arrs.stop_name AS arrival_stop_name, arrivo.arrival_time AS arrival_time, `date`" +
                "FROM stop_times AS partenza, stop_times AS arrivo, trips AS t, calendar_dates AS cd, stops AS deps, stops AS arrs\n" +
                "WHERE partenza.stop_id='" + departureStopId + "'\n" + // RUF020_600
                "AND arrivo.stop_id='" + arrivalStopId + "'\n" + // PEG077_600
                "AND partenza.trip_id=arrivo.trip_id\n" +
                "AND partenza.trip_id=t.trip_id\n" +
                "AND t.service_id=cd.service_id\n" +
                "AND partenza.stop_id=deps.stop_id\n" +
                "AND arrivo.stop_id=arrs.stop_id\n" +
                "AND cd.`date`=CURDATE()\n" +
                "ORDER BY partenza.departure_time;";
        return jdbcTemplate.query(sqlQuery, mapTravel());
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
