package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Entity.SOrder;

@Service
public class SwiggyService {

	@Autowired
	RestTemplate rt;

	public ResponseEntity<String> saveOrderInfo(SOrder o) {
		ResponseEntity<String> response = rt.postForEntity("http://localhost:8080/order", o, String.class);

		return response;
	}

	public ResponseEntity<List<SOrder>> listOfAllItems() {
		ResponseEntity<List<SOrder>> response = rt.exchange("http://localhost:8080/orders", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<SOrder>>() {
				});
		return response;
	}

	public ResponseEntity<SOrder> getItemById(int id) {
		ResponseEntity<SOrder> response = rt.getForEntity("http://localhost:8080/order/id/{id}", SOrder.class, id);
		return response;
	}

	public ResponseEntity<List<SOrder>> getItemByCustomerPhone(String customerPhone) {
		ResponseEntity<List<SOrder>> response = rt.exchange("http://localhost:8080/order/phone/{customerPhone}", HttpMethod.GET, null, new ParameterizedTypeReference <List<SOrder>>() {
		}, customerPhone);
		return response;
	}

	public ResponseEntity<List<SOrder>> getItemByAddress(String address) {
		ResponseEntity<List<SOrder>> response = rt.exchange("http://localhost:8080/order/address/{address}", HttpMethod.GET, null, new ParameterizedTypeReference <List<SOrder>>() {
		}, address);
		return response;
	}

	public ResponseEntity<Void> deleteItemById(int id) {
		ResponseEntity<Void> response = rt.exchange("http://localhost:8080/order/delete/{id}", HttpMethod.DELETE, null, Void.class, id);
		return response;

	}
}
