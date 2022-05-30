package com.mizuiro.bootbus.exceptions;

public class TravelNotFoundException extends RuntimeException {
    public TravelNotFoundException(String depId, String arrId) {
        super("Could not find travel times between " + depId + " and " + arrId);
    }
}
