package com.directkart.epizza.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@Entity
@Table (name="order_reference")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String customerId;
    private Integer shippingAddressId;
    private OrderStatus orderStatus;
    private Double orderAmount;
    private LocalDate dateCreated;
    private LocalDate lastUpdated;
}
