package com.mizuiro.bootbus.dao;

import com.mizuiro.bootbus.exceptions.EntityNotFoundException;
import com.mizuiro.bootbus.model.Trip;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("tripSql")
public class SqlTripDataAccessService implements TripDao {
    private final JdbcTemplate jdbcTemplate;

    public SqlTripDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addTrip(Trip trip) {
        return 0;
    }

    @Override
    public List<Trip> getAllTrips() {
        String sqlQuery = "SELECT * FROM pt.trips";
        return jdbcTemplate.query(sqlQuery, mapTrip());
    }

    @Override
    public List<Trip> getTripsByRoute(String routeId) {
        String sqlQuery = "SELECT * FROM pt.trips WHERE route_id='"+ routeId + "'";
        return jdbcTemplate.query(sqlQuery, mapTrip());
    }

    @Override
    public List<Trip> getTripsByService(String serviceId) {
        String sqlQuery = "SELECT * FROM pt.trips WHERE service_id='"+ serviceId + "'";
        return jdbcTemplate.query(sqlQuery, mapTrip());
    }

    @Override
    public Trip getTripById(String tripId) throws EntityNotFoundException {
        String sqlQuery = "SELECT * FROM pt.trips WHERE trip_id='"+ tripId + "'";
        List<Trip> resultSet = jdbcTemplate.query(sqlQuery, mapTrip());
        if(resultSet.isEmpty()) return null;
        else return resultSet.get(0);
    }

    private RowMapper<Trip> mapTrip() {
        return (resultSet, i) -> {
            String route = resultSet.getString("route_id");
            String calendarDate = resultSet.getString("service_id");
            String tripId = resultSet.getString("trip_id");
            String tripHeadsign = resultSet.getString("trip_headsign");
            String tripShortName = resultSet.getString("trip_short_name");
            int direction = resultSet.getInt("direction_id");
            String shape = resultSet.getString("shape_id");
            return new Trip(route, calendarDate, tripId, tripHeadsign, tripShortName, direction, shape);
        };
    }
}
