package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Order;
import com.example.demo.Service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService os;

	@PostMapping("order")
	ResponseEntity<String> placeOrder(@RequestBody Order o) {
		os.placeOrder(o);
		return new ResponseEntity<String>("order placed", HttpStatus.CREATED);
	}

	@GetMapping("order/id/{id}")
	ResponseEntity<Order> getItemById(@PathVariable int id) {
		Order o = os.getItemById(id);
		return new ResponseEntity<Order>(o, HttpStatus.OK);
	}

	@GetMapping("order/phone/{customerPhone}")
	ResponseEntity<List<Order>> getItemByPhone(@PathVariable String customerPhone) {
		List<Order> o = os.getItemByCustomerPhone(customerPhone);
		return new ResponseEntity<List<Order>>(o, HttpStatus.OK);
	}

	@GetMapping("order/address/{address}")
	ResponseEntity<List<Order>> getItemByAddress(@PathVariable String address) {
		List<Order> o = os.getItemByAddress(address);
		return new ResponseEntity<List<Order>>(o, HttpStatus.OK);
	}

	@GetMapping("orders")
	ResponseEntity<List<Order>> getAllItems() {
		List<Order> o = os.getAllItems();
		if (o.size() == 0)
			return new ResponseEntity<List<Order>>(HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Order>>(o, HttpStatus.OK);

	}

	@DeleteMapping("order/delete/{id}")
	ResponseEntity<Order> deleteOrderById(@PathVariable int id) {
		os.deleteItemById(id);
		return new ResponseEntity<Order>(HttpStatus.OK);
	}

}
