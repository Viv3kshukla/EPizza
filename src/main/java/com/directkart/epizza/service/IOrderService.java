package com.directkart.epizza.service;

import com.directkart.epizza.model.Order;

import java.util.List;

public interface IOrderService {

    public Order getOrderInfo();

    public Order createOrder();

    public List<Order> getAllOrders();
}
