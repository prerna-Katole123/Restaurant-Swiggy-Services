package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Order;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	List<Order> findByCustomerPhone(String customerPhone);

	List<Order> findByDeliveryAddress(String deliveryAddress);
}
