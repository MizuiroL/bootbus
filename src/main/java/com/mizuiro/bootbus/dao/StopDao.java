package com.mizuiro.bootbus.dao;

import com.mizuiro.bootbus.exceptions.EntityNotFoundException;
import com.mizuiro.bootbus.model.Stop;

import java.util.List;

public interface StopDao {
    int addStop(Stop stop);

    List<Stop> getAllStops();

    Stop getStopById(String stopId) throws EntityNotFoundException;

}
