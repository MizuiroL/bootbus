package com.mizuiro.bootbus.dao;

import com.mizuiro.bootbus.exceptions.EntityNotFoundException;
import com.mizuiro.bootbus.model.Trip;

import java.util.List;

public interface TripDao {
    int addTrip(Trip trip);

    List<Trip> getAllTrips();

    List<Trip> getTripsByRoute(String routeId);

    List<Trip> getTripsByService(String serviceId);

    Trip getTripById(String tripId) throws EntityNotFoundException;

}
