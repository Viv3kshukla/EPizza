package com.directkart.epizza.repository;

import com.directkart.epizza.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, String> {
    Optional<Customer> findById (Long customerId);
}
