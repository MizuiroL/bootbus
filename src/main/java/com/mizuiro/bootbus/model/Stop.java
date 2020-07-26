package com.mizuiro.bootbus.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stop {
    private String stopId;
    private String stopName;
    private double stopLat;
    private double stopLon;
    private String stopCode;

    public Stop(@JsonProperty("stopId") String stopId,
                @JsonProperty("stopName") String stopName,
                @JsonProperty("stopLat") double stopLat,
                @JsonProperty("stopLon") double stopLon,
                @JsonProperty("stopCode") String stopCode) {
        this.stopId = stopId;
        this.stopName = stopName;
        this.stopLat = stopLat;
        this.stopLon = stopLon;
        this.stopCode = stopCode;
    }

    public String getStopId() {
        return stopId;
    }

    public String getStopName() {
        return stopName;
    }

    public double getStopLat() {
        return stopLat;
    }

    public double getStopLon() {
        return stopLon;
    }

    public String getStopCode() {
        return stopCode;
    }
}
