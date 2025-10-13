package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Order;
import com.example.demo.Repo.OrderRepository;

@Service
@Scope("prototype")
public class OrderService {

	@Autowired
	OrderRepository or;

	public void placeOrder(Order o) {
		or.save(o);
	}

	public Order getItemById(int id) {
		return or.findById(id).get();
	}

	public List<Order> getAllItems() {
		return or.findAll();
	}

	public List<Order> getItemByAddress(String address) {
		return or.findByDeliveryAddress(address);
	}

	public List<Order> getItemByCustomerPhone(String customerPhone) {
		return or.findByCustomerPhone(customerPhone);
	}

	public void deleteItemById(int id) {
		or.deleteById(id);
	}
}
