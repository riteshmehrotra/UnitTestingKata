package org.xperience.domain.exceptions;

public class InvalidPaymentMethodException extends RuntimeException {
    public InvalidPaymentMethodException(String exception){
        super(exception);
    }
}
