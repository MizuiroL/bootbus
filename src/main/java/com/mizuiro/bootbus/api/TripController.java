package com.mizuiro.bootbus.api;

import com.mizuiro.bootbus.exceptions.EntityNotFoundException;
import com.mizuiro.bootbus.model.Trip;
import com.mizuiro.bootbus.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/trip")
@RestController
public class TripController {
    private final TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @PostMapping
    public int addTrip(@NonNull @RequestBody Trip trip) {
        return tripService.addTrip(trip);
    }

    @GetMapping
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }

    @GetMapping(path = "by-route/{route}")
    public List<Trip> getTripsByRoute(String route) {
        return tripService.getTripsByRoute(route);
    }

    @GetMapping(path = "by-service/{service}")
    public List<Trip> getTripsByService(String service) {
        return tripService.getTripsByService(service);
    }

    @GetMapping(path = "{tripId}")
    public Trip getTripById(@PathVariable("tripId") String tripId) throws EntityNotFoundException {
        Trip trip = tripService.getTripById(tripId);
        if(trip == null) throw new EntityNotFoundException(tripId);
        else return trip;
    }
}
