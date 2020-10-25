package com.mizuiro.bootbus.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Trip {
    private String route;
    private String calendarDate;
    private String tripId;
    private String tripHeadsign;
    private String tripShortName;
    private Integer direction;
    private String shape;

    public Trip(@JsonProperty("routeId") String route,
                @JsonProperty("serviceId") String calendarDate,
                @JsonProperty("tripId") String tripId,
                @JsonProperty("tripHeadsign") String tripHeadsign,
                @JsonProperty("tripShortName") String tripShortName,
                @JsonProperty("directionId") int direction,
                @JsonProperty("shapeId") String shape) {
        this.route = route;
        this.calendarDate = calendarDate;
        this.tripId = tripId;
        this.tripHeadsign = tripHeadsign;
        this.tripShortName = tripShortName;
        this.direction = direction;
        this.shape = shape;
    }

    public String getRoute() {
        return route;
    }

    public String getCalendarDate() {
        return calendarDate;
    }

    public String getTripId() {
        return tripId;
    }

    public String getTripHeadsign() {
        return tripHeadsign;
    }

    public String getTripShortName() {
        return tripShortName;
    }

    public int getDirection() {
        return direction;
    }

    public String getShape() {
        return shape;
    }
}
