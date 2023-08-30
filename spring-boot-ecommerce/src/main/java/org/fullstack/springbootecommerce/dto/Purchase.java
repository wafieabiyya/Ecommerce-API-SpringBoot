package org.fullstack.springbootecommerce.dto;
import java.util.Set;

import org.fullstack.springbootecommerce.etinty.Address;
import org.fullstack.springbootecommerce.etinty.Customer;
import org.fullstack.springbootecommerce.etinty.Order;
import org.fullstack.springbootecommerce.etinty.OrderItem;

import lombok.Data;

@Data
public class Purchase {
    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
