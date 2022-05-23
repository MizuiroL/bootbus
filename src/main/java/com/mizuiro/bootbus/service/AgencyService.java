package com.mizuiro.bootbus.service;

import com.mizuiro.bootbus.dao.AgencyDao;
import com.mizuiro.bootbus.model.Agency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgencyService {
    private final AgencyDao agencyDao;

    @Autowired
    public AgencyService(@Qualifier("agencySql") AgencyDao agencyDao) {
        this.agencyDao = agencyDao;
    }

    public int addAgency(Agency agency) {
        return agencyDao.addAgency(agency);
    }

    public List<Agency> getAllAgencies() {
        return agencyDao.getAllAgencies();
    }

    public Agency getAgencyById(String agencyId) {
        return agencyDao.getAgencyById(agencyId);
    }

}
