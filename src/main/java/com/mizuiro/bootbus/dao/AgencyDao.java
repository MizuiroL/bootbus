package com.mizuiro.bootbus.dao;

import com.mizuiro.bootbus.exceptions.EntityNotFoundException;
import com.mizuiro.bootbus.model.Agency;

import java.util.List;

public interface AgencyDao {
    int addAgency(Agency agency);

    List<Agency> getAllAgencies();

    Agency getAgencyById(String AgencyId) throws EntityNotFoundException;
}
