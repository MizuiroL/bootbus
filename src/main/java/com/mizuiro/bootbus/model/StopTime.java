package com.mizuiro.bootbus.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Time;

public class StopTime {
    private String trip;
    private Time arrivalTime;
    private Time departureTime;
    private String stop;
    private Integer stopSequence;
    private Double shapeDistTraveled;

    public StopTime(@JsonProperty("tripId") String trip,
                    @JsonProperty("arrivalTime") Time arrivalTime,
                    @JsonProperty("departureTime") Time departureTime,
                    @JsonProperty("stopId") String stop,
                    @JsonProperty("stopSequence") Integer stopSequence,
                    @JsonProperty("shapeDistTraveled") Double shapeDistTraveled) {
        this.trip = trip;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.stop = stop;
        this.stopSequence = stopSequence;
        this.shapeDistTraveled = shapeDistTraveled;
    }

    public String getTrip() {
        return trip;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public String getStop() {
        return stop;
    }

    public Integer getStopSequence() {
        return stopSequence;
    }

    public Double getShapeDistTraveled() {
        return shapeDistTraveled;
    }
}
