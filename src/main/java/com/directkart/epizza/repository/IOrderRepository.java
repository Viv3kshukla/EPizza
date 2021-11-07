package com.directkart.epizza.repository;

import com.directkart.epizza.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.Set;

@Repository
public interface IOrderRepository extends JpaRepository<Order, String> {
    Optional<Order> findById (String orderId);
    Set<Order> findAllByCustomerId(Long customerId);
}
