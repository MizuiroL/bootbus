package com.mizuiro.bootbus.dao;

import com.mizuiro.bootbus.exceptions.EntityNotFoundException;
import com.mizuiro.bootbus.model.Route;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("routeSql")
public class SqlRouteDataAccessService implements RouteDao {
    private final JdbcTemplate jdbcTemplate;

    public SqlRouteDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addRoute(Route route) {
        return 0;
    }

    @Override
    public List<Route> getAllRoutes() {
        String sqlQuery = "SELECT * FROM pt.routes";
        return jdbcTemplate.query(sqlQuery, mapRoute());
    }

    @Override
    public List<Route> getRoutesByAgency(String agency) {
        String sqlQuery = "SELECT * FROM pt.routes WHERE agency_id='" + agency + "'";
        return jdbcTemplate.query(sqlQuery, mapRoute());
    }

    @Override
    public Route getRouteById(String routeId) throws EntityNotFoundException {
        String sqlQuery = "SELECT * FROM pt.routes WHERE route_id='" + routeId + "'";
        List<Route> resultSet = jdbcTemplate.query(sqlQuery, mapRoute());
        if(resultSet.isEmpty()) return null;
        else return resultSet.get(0);
    }

    private RowMapper<Route> mapRoute() {
        return (resultSet, i) -> {
            String routeId = resultSet.getString("route_id");
            String routeAgency = resultSet.getString("agency_id");
            String routeShortName = resultSet.getString("route_short_name");
            String routeLongName = resultSet.getString("route_long_name");
            Integer routeType = resultSet.getInt("route_type");
            String routeColor = resultSet.getString("route_color");
            String routeTextColor = resultSet.getString("route_text_color");
            return new Route(routeId, routeAgency, routeShortName, routeLongName, routeType, routeColor, routeTextColor);
        };
    }
}
