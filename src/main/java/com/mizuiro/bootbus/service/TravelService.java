package com.mizuiro.bootbus.service;

import com.mizuiro.bootbus.dao.TravelDao;
import com.mizuiro.bootbus.exceptions.TravelNotFoundException;
import com.mizuiro.bootbus.model.Travel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelService {

    private final TravelDao travelDao;

    @Autowired
    public TravelService(@Qualifier("travelSql") TravelDao travelDao) {
        this.travelDao = travelDao;
    }

    public List<Travel> getTravelTimes(String departureStopId, String arrivalStopId) throws TravelNotFoundException {
        return travelDao.getTravelTimes(departureStopId, arrivalStopId);
    }

}
