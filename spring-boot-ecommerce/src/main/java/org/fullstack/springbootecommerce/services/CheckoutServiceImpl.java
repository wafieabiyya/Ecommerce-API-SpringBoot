package org.fullstack.springbootecommerce.services;

import java.util.Set;
import java.util.UUID;

import org.fullstack.springbootecommerce.dao.CustomerRepository;
import org.fullstack.springbootecommerce.dto.Purchase;
import org.fullstack.springbootecommerce.dto.PurchaseResponse;
import org.fullstack.springbootecommerce.etinty.Customer;
import org.fullstack.springbootecommerce.etinty.Order;
import org.fullstack.springbootecommerce.etinty.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public PurchaseResponse placeOrder(Purchase purchase){
        // 1.Retrieve order from DTO        
        Order order = purchase.getOrder();

        //2. Generate Tracking Number
        String orderTracking = generateTrackingNumber();
        order.setOrderTracking(orderTracking);

        //3. Gabungkan order dengan order items
        Set<OrderItem> orderItems = order.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        //4. Gabungkan order dengan shipping address dan billing address
        order.setShippingAddress(purchase.getShippingAddress());
        order.setBillingAddress(purchase.getBillingAddress());

        //5. Gabungkan customer dengan order
        Customer customer = purchase.getCustomer();
        customer.add(order);

        //6. Simpan order pada db
        customerRepository.save(customer);

        return new PurchaseResponse(orderTracking);
    }
    private String generateTrackingNumber(){
        return UUID.randomUUID().toString();
    }
    
}
