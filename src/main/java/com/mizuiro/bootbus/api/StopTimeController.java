package com.mizuiro.bootbus.api;

import com.mizuiro.bootbus.model.StopTime;
import com.mizuiro.bootbus.service.StopTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/stoptime")
@RestController
public class StopTimeController {
    private final StopTimeService stopTimeService;

    @Autowired
    public StopTimeController(StopTimeService stopTimeService) {
        this.stopTimeService = stopTimeService;
    }

    @PostMapping
    public int addStopTime(@NonNull @RequestBody StopTime stopTime) {
        return stopTimeService.addStopTime(stopTime);
    }

    @GetMapping
    public List<StopTime> getAllStopTimes() {
        return stopTimeService.getAllStopTimes();
    }

    @GetMapping(path = "by-trip/{trip}")
    public List<StopTime> getStopTimesByTrip(String trip) {
        return stopTimeService.getStopTimesByTrip(trip);
    }

    @GetMapping(path = "by-stop/{stop}")
    public List<StopTime> getStopTimesByStop(String stop) {
        return stopTimeService.getStopTimesByStop(stop);
    }
}
