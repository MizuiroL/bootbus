package com.mizuiro.bootbus.service;

import com.mizuiro.bootbus.dao.TripDao;
import com.mizuiro.bootbus.exceptions.EntityNotFoundException;
import com.mizuiro.bootbus.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {
    private final TripDao tripDao;

    @Autowired
    public TripService(@Qualifier("tripSql") TripDao tripDao) {
        this.tripDao = tripDao;
    }

    public int addTrip(Trip trip) {
        return tripDao.addTrip(trip);
    }

    public List<Trip> getAllTrips() {
        return tripDao.getAllTrips();
    }

    public List<Trip> getTripsByRoute(String routeId) {
        return tripDao.getTripsByRoute(routeId);
    }

    public List<Trip> getTripsByService(String serviceId) {
        return tripDao.getTripsByService(serviceId);
    }

    public Trip getTripById(String tripId) throws EntityNotFoundException {
        return tripDao.getTripById(tripId);
    }
}
