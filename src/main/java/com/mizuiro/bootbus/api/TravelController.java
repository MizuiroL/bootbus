package com.mizuiro.bootbus.api;

import com.mizuiro.bootbus.model.Travel;
import com.mizuiro.bootbus.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/v1/travel")
@RestController
public class TravelController {
    private final TravelService travelService;

    @Autowired
    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }

    @GetMapping(path = "{departure}/{arrival}")
    public List<Travel> getTravelTimes(@PathVariable("departure") String departure, @PathVariable("arrival") String arrival) {
        return travelService.getTravelTimes(departure, arrival);
    }
}
