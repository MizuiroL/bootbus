package com.mizuiro.bootbus.service;

import com.mizuiro.bootbus.dao.StopDao;
import com.mizuiro.bootbus.model.Stop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StopService {
    private final StopDao stopDao;

    @Autowired
    public StopService(@Qualifier("stopSql") StopDao stopDao) {
        this.stopDao = stopDao;
    }

    public int addStop(Stop stop) {
        return stopDao.addStop(stop);
    }

    public List<Stop> getAllStops() {
        return stopDao.getAllStops();
    }

    public Stop getStopById(String stopId) {
        return stopDao.getStopById(stopId);
    }


}
