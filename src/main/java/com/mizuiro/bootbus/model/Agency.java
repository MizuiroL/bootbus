package com.mizuiro.bootbus.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.TimeZone;

public class Agency {
    private String agencyId;
    private String agencyName;
    private String agencyUrl;
    private TimeZone agencyTimezone;
    private String agencyLanguage;

    public Agency(@JsonProperty("agencyId") String agencyId,
                  @JsonProperty("agencyName") String agencyName,
                  @JsonProperty("agencyUrl") String agencyUrl,
                  @JsonProperty("agencyTimezone") TimeZone agencyTimezone,
                  @JsonProperty("agencyLanguage") String agencyLanguage) {
        this.agencyId = agencyId;
        this.agencyName = agencyName;
        this.agencyUrl = agencyUrl;
        this.agencyTimezone = agencyTimezone;
        this.agencyLanguage = agencyLanguage;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public String getAgencyUrl() {
        return agencyUrl;
    }

    public TimeZone getAgencyTimezone() {
        return agencyTimezone;
    }

    public String getAgencyLanguage() {
        return agencyLanguage;
    }
}
