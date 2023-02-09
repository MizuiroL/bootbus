package com.mizuiro.bootbus.service;

import com.mizuiro.bootbus.dao.TravelDao;
import com.mizuiro.bootbus.exceptions.TravelNotFoundException;
import com.mizuiro.bootbus.model.Travel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TravelService {

    private final TravelDao travelDao;

    @Autowired
    public TravelService(@Qualifier("travelSql") TravelDao travelDao) {
        this.travelDao = travelDao;
    }
    
    public List<Travel> getTravelTimes(String departureStopId, String arrivalStopId) throws TravelNotFoundException {
        List<Travel> travels = travelDao.getTravelTimes(departureStopId, arrivalStopId);
        travels = travels.stream().filter(t -> t.getTravelTime() > 0).collect(Collectors.toList());
        return travels;
    }

}
