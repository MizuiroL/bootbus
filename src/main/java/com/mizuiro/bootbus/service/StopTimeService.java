package com.mizuiro.bootbus.service;

import com.mizuiro.bootbus.dao.StopTimeDao;
import com.mizuiro.bootbus.model.StopTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StopTimeService {
    private final StopTimeDao stopTimeDao;

    @Autowired
    public StopTimeService(@Qualifier("stopTimeSql") StopTimeDao stopTimeDao) {
        this.stopTimeDao = stopTimeDao;
    }

    public int addStopTime(StopTime stopTime) {
        return stopTimeDao.addStopTime(stopTime);
    }

    public List<StopTime> getAllStopTimes() {
        return stopTimeDao.getAllTrips();
    }

    public List<StopTime> getStopTimesByStop(String stopId) {
        return stopTimeDao.getStopTimesByStop(stopId);
    }

    public List<StopTime> getStopTimesByTrip(String tripId) {
        return stopTimeDao.getStopTimesByTrip(tripId);
    }
}
