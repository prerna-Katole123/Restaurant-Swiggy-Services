package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.SOrder;
import java.util.List;

public interface SwiggyRepository extends JpaRepository<SOrder, Integer> {
	List<SOrder> findByCustomerPhone(String customerPhone);

	List<SOrder> findByDeliveryAddress(String deliveryAddress);
}
