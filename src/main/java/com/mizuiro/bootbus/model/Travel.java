package com.mizuiro.bootbus.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Time;
import java.time.Duration;
import java.time.LocalDate;

public class Travel {
    private String departureStopCode;
    private String departureStopName;
    private Time departureTime;
    private String arrivalStopCode;
    private String arrivalStopName;
    private Time arrivalTime;
    private LocalDate date;
    private Duration travelTime;

    public Travel(@JsonProperty("departureStopCode") String departureStopCode,
                  @JsonProperty("departureStopName") String departureStopName,
                  @JsonProperty("departureTime") Time departureTime,
                  @JsonProperty("arrivalStopCode") String arrivalStopCode,
                  @JsonProperty("arrivalStopName") String arrivalStopName,
                  @JsonProperty("arrivalTime") Time arrivalTime,
                  @JsonProperty("date")LocalDate date,
                  @JsonProperty("travelTime") Duration travelTime) {

        this.departureStopCode = departureStopCode;
        this.departureStopName = departureStopName;
        this.departureTime = departureTime;
        this.arrivalStopCode = arrivalStopCode;
        this.arrivalStopName = arrivalStopName;
        this.arrivalTime = arrivalTime;
        this.date = date;
        this.travelTime = travelTime;
    }

    public String getDepartureStopCode() {
        return departureStopCode;
    }

    public String getDepartureStopName() {
        return departureStopName;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public String getArrivalStopCode() {
        return arrivalStopCode;
    }

    public String getArrivalStopName() {
        return arrivalStopName;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public Long getTravelTime() { return travelTime.toMinutes(); }
}
