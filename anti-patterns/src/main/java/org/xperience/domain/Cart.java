package org.xperience.domain;

import org.xperience.domain.exceptions.InvalidPaymentMethodException;
import org.xperience.domain.guards.PaymentGuard;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<OrderItem> orderItems;
    InventoryService inventoryService;
    PaymentService paymentService;

    public Cart(InventoryService inventoryService, PaymentService paymentService) {
        orderItems = new ArrayList<>();
        this.inventoryService = inventoryService;
        this.paymentService = paymentService;
    }

    public void add(OrderItem orderItem) {
        PaymentGuard.againstInvalidPaymentMethod(paymentService);
        ItemStatus inventoryResponse = inventoryService.reserve(orderItem.code(), orderItem.quantity());
        if (inventoryResponse.equals(ItemStatus.RESERVED))
            orderItems.add(orderItem);

    }


    public List<OrderItem> getItems() {
        return orderItems;
    }
}



