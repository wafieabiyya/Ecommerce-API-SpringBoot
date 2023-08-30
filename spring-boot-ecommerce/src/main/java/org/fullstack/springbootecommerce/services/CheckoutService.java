package org.fullstack.springbootecommerce.services;

import org.fullstack.springbootecommerce.dto.Purchase;
import org.fullstack.springbootecommerce.dto.PurchaseResponse;

public interface CheckoutService {
     PurchaseResponse placeOrder(Purchase purchase);
}
