package org.example.part_three_testing.repository;

import org.example.part_three_testing.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    Optional<Order> findByProduct_Id(int id);
}
