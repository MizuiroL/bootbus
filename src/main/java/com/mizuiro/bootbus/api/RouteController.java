package com.mizuiro.bootbus.api;

import com.mizuiro.bootbus.exceptions.EntityNotFoundException;
import com.mizuiro.bootbus.model.Route;
import com.mizuiro.bootbus.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/route")
@RestController
public class RouteController {
    private final RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping
    public int addRoute(@NonNull @RequestBody Route route) {
        return routeService.addRoute(route);
    }

    @GetMapping
    public List<Route> getAllRoutes() {
        return routeService.getAllRoutes();
    }

    @GetMapping(path = "by-agency/{agency}")
    public List<Route> getRoutesByAgency(@PathVariable("agency") String agency) {
        return routeService.getRoutesByAgency(agency);
    }

    @GetMapping(path = "{routeId}")
    public Route getRouteById(@PathVariable("routeId") String routeId) {
        Route route = routeService.getRouteById(routeId);
        if(route == null) throw new EntityNotFoundException(routeId);
        else return route;
    }
}
