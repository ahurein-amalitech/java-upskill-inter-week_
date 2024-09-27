package org.example.part_three_testing.service;

import org.example.part_three_testing.entities.Order;
import org.example.part_three_testing.entities.Product;
import org.example.part_three_testing.repository.OrderRepository;
import org.example.part_three_testing.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public Optional<Product> findProductById(int id) {
        return this.productRepository.findById(id);
    }

    public Order findOrderByProductId(int id) {
        Optional<Order> order = orderRepository.findByProduct_Id(id);
        return order.orElse(null);
    }

    public List<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }
}
