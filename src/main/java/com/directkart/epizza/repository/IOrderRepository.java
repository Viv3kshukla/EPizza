package com.directkart.epizza.repository;

import com.directkart.epizza.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IOrderRepository extends JpaRepository<Order, String> {
    Optional<Order> findById (String id);
}
