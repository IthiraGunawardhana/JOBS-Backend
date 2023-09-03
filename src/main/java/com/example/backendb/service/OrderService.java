package com.example.backendb.service;

import com.example.backendb.entity.Order;
import com.example.backendb.exception.OrderNotFoundException;
import com.example.backendb.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order getOrderById(Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (!optionalOrder.isPresent()) {
            throw new OrderNotFoundException("Order with ID " + id + " not found");
        }
        return optionalOrder.get();
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order order) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (!optionalOrder.isPresent()) {
            throw new OrderNotFoundException("Order with ID " + id + " not found");
        }
        order.setId(id);
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (!optionalOrder.isPresent()) {
            throw new OrderNotFoundException("Order with ID " + id + " not found");
        }
        orderRepository.delete(optionalOrder.get());
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }


}
