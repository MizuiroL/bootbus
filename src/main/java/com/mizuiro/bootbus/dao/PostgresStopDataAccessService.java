package com.mizuiro.bootbus.dao;

import com.mizuiro.bootbus.exceptions.EntityNotFoundException;
import com.mizuiro.bootbus.model.Stop;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("postgres")
public class PostgresStopDataAccessService implements StopDao {

    private final JdbcTemplate jdbcTemplate;
    private String sqlQuery;

    public PostgresStopDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    // TODO write method
    @Override
    public int addStop(Stop stop) {
        return 0;
    }

    @Override
    public List<Stop> getAllStops() {
        String sqlQuery = "SELECT * FROM pt.stops";
        return jdbcTemplate.query(sqlQuery, mapAirport());
    }

    @Override
    public Stop getStopById(String stopId) throws EntityNotFoundException {
        String sqlQuery = "SELECT * FROM pt.stops WHERE stop_id='" + stopId + "'";
        List<Stop> resultSet = jdbcTemplate.query(sqlQuery, mapAirport());
        if(resultSet.isEmpty()) return null;
        else return resultSet.get(0);
    }

    private RowMapper<Stop> mapAirport() {
        return (resultSet, i) -> {
          String stopId = resultSet.getString("stop_id");
            String stopName = resultSet.getString("stop_name");
            double stopLat = resultSet.getDouble("stop_lat");
            double stopLon = resultSet.getDouble("stop_lon");
            String stopCode = resultSet.getString("stop_code");
            return new Stop(stopId, stopName, stopLat, stopLon, stopCode);
        };
    }
}
