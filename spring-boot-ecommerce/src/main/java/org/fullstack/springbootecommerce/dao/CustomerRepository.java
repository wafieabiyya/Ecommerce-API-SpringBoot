package org.fullstack.springbootecommerce.dao;

import org.fullstack.springbootecommerce.etinty.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
    
}
