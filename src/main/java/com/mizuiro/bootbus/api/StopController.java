package com.mizuiro.bootbus.api;

import com.mizuiro.bootbus.exceptions.EntityNotFoundException;
import com.mizuiro.bootbus.model.Stop;
import com.mizuiro.bootbus.service.StopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/stop")
@RestController
public class StopController {
    private final StopService stopService;

    @Autowired
    public StopController(StopService stopService) {
        this.stopService = stopService;
    }

    @PostMapping
    public void addStop(@NonNull @RequestBody Stop stop) {
        stopService.addStop(stop);
    }

    @GetMapping
    public List<Stop> getAllStops() {
        return stopService.getAllStops();
    }

    @GetMapping(path = "{stopId}")
    public Stop getStopById(@PathVariable("stopId") String stopId) {
        Stop stop = stopService.getStopById(stopId);
        if(stop == null) throw new EntityNotFoundException(stopId);
        else return stop;
    }
}
