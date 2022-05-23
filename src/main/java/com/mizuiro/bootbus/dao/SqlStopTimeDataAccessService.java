package com.mizuiro.bootbus.dao;

import com.mizuiro.bootbus.model.StopTime;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.List;

@Repository("stopTimeSql")
public class SqlStopTimeDataAccessService implements StopTimeDao {
    private final JdbcTemplate jdbcTemplate;

    public SqlStopTimeDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addStopTime(StopTime stopTime) {
        return 0;
    }

    @Override
    public List<StopTime> getAllTrips() {
        String sqlQuery = "SELECT * FROM pt.stop_times";
        return jdbcTemplate.query(sqlQuery, mapStopTime());
    }

    @Override
    public List<StopTime> getStopTimesByStop(String stopId) {
        String sqlQuery = "SELECT * FROM pt.stop_times WHERE stop_id = '" + stopId + "'";
        return jdbcTemplate.query(sqlQuery, mapStopTime());
    }

    @Override
    public List<StopTime> getStopTimesByTrip(String tripId) {
        String sqlQuery = "SELECT * FROM pt.stop_times WHERE trip_id = '" + tripId + "'";
        return jdbcTemplate.query(sqlQuery, mapStopTime());
    }

    private RowMapper<StopTime> mapStopTime() {
        return (resultSet, i) -> {
            String trip = resultSet.getString("trip_id");
            Time arrivalTime = resultSet.getTime("arrival_time");
            Time departureTime = resultSet.getTime("departure_time");
            String stop = resultSet.getString("stop_id");
            int stopSequence = resultSet.getInt("stop_sequence");
            Double shapeDistTraveled = resultSet.getDouble("shape_dist_traveled");
            return new StopTime(trip, arrivalTime, departureTime, stop, stopSequence, shapeDistTraveled);
        };
    }
}
