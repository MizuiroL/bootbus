package com.mizuiro.bootbus.dao;

import com.mizuiro.bootbus.model.StopTime;

import java.util.List;

public interface StopTimeDao {
    public int addStopTime(StopTime stopTime);

    public List<StopTime> getAllTrips();

    public List<StopTime> getStopTimesByStop(String stopId);

    public List<StopTime> getStopTimesByTrip(String tripId);
}
