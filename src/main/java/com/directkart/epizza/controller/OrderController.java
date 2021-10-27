package com.directkart.epizza.controller;

import com.directkart.epizza.model.Address;
import com.directkart.epizza.model.Order;
import com.directkart.epizza.repository.IAddressRepository;
import com.directkart.epizza.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.directkart.epizza.utils.constants.ApplicationConstants;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

    @Autowired
    IOrderRepository orderRepository;

    @Autowired
    IAddressRepository addressRepository;

    @GetMapping("/api/orders/{order_id}")
    @ResponseBody
    public ResponseEntity<Order> getOrderInfo (@NotNull @PathVariable("order_id") String orderId) {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @GetMapping("/api/orders/list")
    @ResponseBody
    public ResponseEntity<List<Order>> getAllOrders() {
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/api/orders")
    public ResponseEntity<Order> createOrder (@RequestBody Map<String, String> orderRequest) {

        Address shippingAddress = Address.builder()
                .zipCode(orderRequest.get(ApplicationConstants.ZIP_CODE))
                .cityName(orderRequest.get(ApplicationConstants.CITY_NAME))
                .country(orderRequest.get(ApplicationConstants.COUNTRY))
                .state(orderRequest.get(ApplicationConstants.STATE))
                .street(orderRequest.get(ApplicationConstants.STREET))
                .build();
        addressRepository.save(shippingAddress);
        Order order = Order.builder().customerId(orderRequest.get("customerId")).build();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(order);
    }
}
