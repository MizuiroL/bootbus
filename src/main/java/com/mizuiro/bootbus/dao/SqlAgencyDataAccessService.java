package com.mizuiro.bootbus.dao;

import com.mizuiro.bootbus.exceptions.EntityNotFoundException;
import com.mizuiro.bootbus.model.Agency;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.TimeZone;

@Repository("agencySql")
public class SqlAgencyDataAccessService implements AgencyDao {
    private final JdbcTemplate jdbcTemplate;
    private String sqlQuery;

    public SqlAgencyDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    // TODO write method
    @Override
    public int addAgency(Agency agency) {
        return 0;
    }

    @Override
    public List<Agency> getAllAgencies() {
        String sqlQuery = "SELECT * FROM agency";
        return jdbcTemplate.query(sqlQuery, mapAgency());
    }

    @Override
    public Agency getAgencyById(String agencyId) throws EntityNotFoundException {
        String sqlQuery = "SELECT * FROM agency WHERE agency_id='" + agencyId + "'";
        List<Agency> resultSet = jdbcTemplate.query(sqlQuery, mapAgency());
        if(resultSet.isEmpty()) return null;
        else return resultSet.get(0);
    }

    private RowMapper<Agency> mapAgency() {
        return (resultSet, i) -> {
            String agencyId = resultSet.getString("agency_id");
            String agencyName = resultSet.getString("agency_name");
            String agencyUrl = resultSet.getString("agency_url");
            TimeZone agencyTimezone = TimeZone.getTimeZone(resultSet.getString("agency_timezone"));
            String agencyLanguage = resultSet.getString("agency_lang");
            return new Agency(agencyId, agencyName, agencyUrl, agencyTimezone, agencyLanguage);
        };
    }
}
