package com.mizuiro.bootbus.service;

import com.mizuiro.bootbus.dao.RouteDao;
import com.mizuiro.bootbus.model.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {
    private final RouteDao routeDao;

    @Autowired
    public RouteService(@Qualifier("routeSql") RouteDao routeDao) {
        this.routeDao = routeDao;
    }

    public int addRoute(Route route) {
        return routeDao.addRoute(route);
    }

    public List<Route> getAllRoutes() {
        return routeDao.getAllRoutes();
    }

    public Route getRouteById(String routeId) {
        return routeDao.getRouteById(routeId);
    }

    public List<Route> getRoutesByAgency(String agency) {
        return routeDao.getRoutesByAgency(agency);
    }
}
