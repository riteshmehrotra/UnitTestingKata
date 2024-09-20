package org.xperience.domain.guards;

import org.xperience.domain.PaymentService;
import org.xperience.domain.exceptions.InvalidPaymentMethodException;

public class PaymentGuard {
    public static void againstInvalidPaymentMethod(PaymentService paymentService) {
        if(!paymentService.isValidMethod())
            throw new InvalidPaymentMethodException("Payment method is invalid");
    }
}
