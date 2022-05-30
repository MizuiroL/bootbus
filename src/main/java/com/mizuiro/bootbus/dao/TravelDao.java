package com.mizuiro.bootbus.dao;

import com.mizuiro.bootbus.exceptions.TravelNotFoundException;
import com.mizuiro.bootbus.model.Travel;

import java.util.List;

public interface TravelDao {
    List<Travel> getTravelTimes(String departureStopId, String arrivalStopId) throws TravelNotFoundException;
}
