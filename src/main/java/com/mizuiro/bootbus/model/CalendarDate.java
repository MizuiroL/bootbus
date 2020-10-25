package com.mizuiro.bootbus.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class CalendarDate {
    private String serviceId;
    private LocalDate date;
    private Integer exceptionType;

    public CalendarDate(@JsonProperty("serviceId") String serviceId,
                        @JsonProperty("date") LocalDate date,
                        @JsonProperty("exceptionType") int exceptionType) {
        this.serviceId = serviceId;
        this.date = date;
        this.exceptionType = exceptionType;
    }

    public String getServiceId() {
        return serviceId;
    }

    public LocalDate getDate() {
        return date;
    }

    public Integer getExceptionType() {
        return exceptionType;
    }
}
