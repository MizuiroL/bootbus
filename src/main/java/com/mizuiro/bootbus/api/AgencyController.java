package com.mizuiro.bootbus.api;

import com.mizuiro.bootbus.exceptions.EntityNotFoundException;
import com.mizuiro.bootbus.model.Agency;
import com.mizuiro.bootbus.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/agency")
@RestController
public class AgencyController {
    private final AgencyService agencyService;

    @Autowired
    public AgencyController(AgencyService agencyService) {
        this.agencyService = agencyService;
    }

    @PostMapping
    public void addAgency(@NonNull @RequestBody Agency agency) {
        agencyService.addAgency(agency);
    }

    @GetMapping
    public List<Agency> getAllAgencies() {
        return agencyService.getAllAgencies();
    }

    @GetMapping(path = "{agencyId}")
    public Agency getAgencyById(@PathVariable("agencyId") String agencyId) {
        Agency agency = agencyService.getAgencyById(agencyId);
        if(agency == null) throw new EntityNotFoundException(agencyId);
        else return agency;
    }

}
