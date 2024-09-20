package org.xperience.domain;

import org.junit.jupiter.api.Test;
import org.xperience.domain.exceptions.InvalidPaymentMethodException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class CartTests {

    @Test
    public void should_add_item_to_cart() {
        //Arrange
        InventoryService inventoryService = mock(InventoryService.class);
        PaymentService paymentService = mock(PaymentService.class);
        Cart cart = new Cart(inventoryService, paymentService);
        OrderItem item = new OrderItem("A01", 5);
        when(inventoryService.reserve(item.code(), item.quantity()))
                .thenReturn(ItemStatus.RESERVED);
        when(paymentService.isValidMethod()).thenReturn(true);

        //Act
        cart.add(item);

        //Assert
        assertThat(cart.getItems().size(), is(equalTo(1)));
        verify(inventoryService,times(1)).reserve("A01",5);
    }

    @Test
    public void should_fail_with_invalid_payment_method() {
        InventoryService inventoryService = mock(InventoryService.class);
        PaymentService paymentService = mock(PaymentService.class);
        Cart cart = new Cart(inventoryService, paymentService);
        OrderItem item = new OrderItem("A01", 5);

        when(inventoryService.reserve(item.code(), item.quantity()))
                .thenReturn(ItemStatus.RESERVED);
        when(paymentService.isValidMethod()).thenReturn(false);

        assertThrows(InvalidPaymentMethodException.class,()->cart.add(item));
    }
}
