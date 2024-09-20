package org.xperience.iteration2.domain.exceptions;

public class LowBatteryException extends RuntimeException {
    public LowBatteryException(String exception) {
        super(exception);
    }
}
