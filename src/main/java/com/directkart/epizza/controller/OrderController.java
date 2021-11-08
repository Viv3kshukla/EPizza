package com.directkart.epizza.controller;

import com.directkart.epizza.api.OrderRequest;
import com.directkart.epizza.exception.InvalidRequestException;
import com.directkart.epizza.exception.ResourceNotFoundException;
import com.directkart.epizza.model.Address;
import com.directkart.epizza.model.Customer;
import com.directkart.epizza.model.Order;
import com.directkart.epizza.model.OrderStatus;
import com.directkart.epizza.repository.IAddressRepository;
import com.directkart.epizza.repository.ICustomerRepository;
import com.directkart.epizza.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.Set;

@RestController
public class OrderController {

    @Autowired
    private IAddressRepository addressRepository;

    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private ICustomerRepository customerRepository;

    @GetMapping("/api/orders/{order_id}")
    @ResponseBody
    public ResponseEntity<Order> getOrderInfo(@NotNull @PathVariable("order_id") Long orderId) {
        return orderRepository.findById(orderId).map(order -> {
            return ResponseEntity.status(HttpStatus.OK).body(order);
        }).orElseThrow(ResourceNotFoundException::new);
    }

    @GetMapping("/api/{customer_id}/orders")
    @ResponseBody
    public ResponseEntity<Set<Order>> getAllOrders(@NotNull @PathVariable("customer_id") Long customerId) {
        Set<Order> orderSet = orderRepository.findAllByCustomerId(customerId);
        if (!orderSet.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(orderSet);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/api/orders")
    @ResponseBody
    public ResponseEntity<Order> createOrder (@RequestBody OrderRequest orderRequest) {

        Address shippingAddress = Address.builder()
                .zipCode(orderRequest.getShippingZipCode())
                .cityName(orderRequest.getShippingCityName())
                .country(orderRequest.getShippingCountry())
                .state(orderRequest.getShippingState())
                .street(orderRequest.getShippingStreetName())
                .build();
        addressRepository.save(shippingAddress);
        Customer customer;
        Optional<Customer> customerOptional = customerRepository.findById(orderRequest.getCustomerId());
        if (customerOptional.isPresent()) {
            customer = customerOptional.get();
        } else {
            customer = Customer.builder()
                    .id(orderRequest.getCustomerId())
                    .firstName(orderRequest.getFirstName())
                    .lastName(orderRequest.getLastName())
                    .customerPhone(orderRequest.getCustomerPhone())
                    .customerEmail(orderRequest.getCustomerEmail())
                    .build();
            customerRepository.save(customer);
        }

        Order order = Order.builder()
                .customer(customer)
                .shippingAddress(shippingAddress)
                .orderStatus(OrderStatus.INITIATED)
                .build();
        orderRepository.save(order);
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }
}
