package com.mizuiro.bootbus.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Route {
    private String routeId;
    private String routeAgency;
    private String routeShortName;
    private String routeLongName;
    private Integer routeType;
    private String routeColor; // Hex RGB
    private String routeTextColor; // Hex RGB

    public Route(@JsonProperty("routeId") String routeId,
                 @JsonProperty("routeAgency") String routeAgency,
                 @JsonProperty("routeShortName") String routeShortName,
                 @JsonProperty("routeLongName") String routeLongName,
                 @JsonProperty("routeType") Integer routeType,
                 @JsonProperty("routeColor") String routeColor,
                 @JsonProperty("routeTextColor") String routeTextColor) {
        this.routeId = routeId;
        this.routeAgency = routeAgency;
        this.routeShortName = routeShortName;
        this.routeLongName = routeLongName;
        this.routeType = routeType;
        this.routeColor = routeColor;
        this.routeTextColor = routeTextColor;
    }

    public String getRouteId() {
        return routeId;
    }

    public String getRouteAgency() {
        return routeAgency;
    }

    public String getRouteShortName() {
        return routeShortName;
    }

    public String getRouteLongName() {
        return routeLongName;
    }

    public Integer getRouteType() {
        return routeType;
    }

    public String getRouteColor() {
        return routeColor;
    }

    public String getRouteTextColor() {
        return routeTextColor;
    }
}
