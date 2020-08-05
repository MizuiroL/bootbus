package com.mizuiro.bootbus.dao;

import com.mizuiro.bootbus.exceptions.EntityNotFoundException;
import com.mizuiro.bootbus.model.Route;

import java.util.List;

public interface RouteDao {
    int addRoute(Route route);

    List<Route> getAllRoutes();

    List<Route> getRoutesByAgency(String agency);

    Route getRouteById(String routeId) throws EntityNotFoundException;

}
