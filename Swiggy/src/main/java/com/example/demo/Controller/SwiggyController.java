package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.SOrder;
import com.example.demo.Service.SwiggyService;

@RestController
public class SwiggyController {

	@Autowired
	SwiggyService ss;

	@PostMapping("swiggyorder")
	 ResponseEntity<String> placeOrder(@RequestBody SOrder o) {
		ResponseEntity<String> response = ss.saveOrderInfo(o);
		return response;

	}

	@GetMapping("swiggyorder/id/{id}")
	 ResponseEntity<SOrder> getItemById(@PathVariable int id) {
		ResponseEntity<SOrder> response = ss.getItemById(id);
		return response;
	}

	@GetMapping("swiggyorder/address/{address}")
	ResponseEntity<List<SOrder>> getItemByAddress(@PathVariable String address) {
		ResponseEntity<List<SOrder>> response = ss.getItemByAddress(address);
		return response;
	}

	@GetMapping("swiggyorder/phone/{customerPhone}")
	 ResponseEntity<List<SOrder>> getItemById(@PathVariable String customerPhone) {
		ResponseEntity<List<SOrder>> response = ss.getItemByCustomerPhone(customerPhone);
		return response;
	}

	@GetMapping("swiggyorders")
	ResponseEntity<List<SOrder>> getAllItems() {
		ResponseEntity<List<SOrder>> response = ss.listOfAllItems();
		return response;
	}

	@DeleteMapping("swiggyorder/delete/{id}")
	 ResponseEntity<Void> deleteItemById(@PathVariable int id) {
		ResponseEntity<Void> response = ss.deleteItemById(id);
		return response;
	}

}
