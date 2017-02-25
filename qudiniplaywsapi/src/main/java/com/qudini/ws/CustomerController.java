package com.qudini.ws;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qudini.bean.Customer;

@RestController
public class CustomerController {

	@RequestMapping("/customer/sort")
	public Customer[] sort(@RequestBody List<Customer> customers) {
		System.out.println("customer..." + customers);
		if (customers == null) {
			return null;
		}
		Collections.sort(customers, new Comparator<Customer>() {
			public int compare(Customer c1, Customer c2) {
				return c1.getDuetime().compareTo(c2.getDuetime());
			}
		});
		return (Customer[]) customers.stream().toArray(Customer[]::new);
	}
}
