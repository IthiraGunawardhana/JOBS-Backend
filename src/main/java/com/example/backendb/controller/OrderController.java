package com.example.backendb.controller;

import com.example.backendb.entity.Order;
import com.example.backendb.entity.Product;
import com.example.backendb.exception.ResourceNotFoundException;
import com.example.backendb.repository.UserRepository;
import com.example.backendb.repository.OrderRepository;
import com.example.backendb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;


@RestController
//@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    //Get all orders
    @GetMapping("/Orders")
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get an order by id
    @GetMapping("/Order/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + id));
    }

    // Create a new order
    @PostMapping("/newOrder")
    public Order createOrder( @RequestBody Order order) {
        return orderRepository.save(order);
    }

    // Update an order
    @PutMapping("/updateOrder/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
        return orderRepository.save(order);
    }

    // Delete an order
    @DeleteMapping("/deleteOrder/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + id));
        orderRepository.delete(order);

        return ResponseEntity.ok().build();
    }

}
