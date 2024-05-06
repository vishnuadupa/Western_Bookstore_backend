package com.avp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avp.models.Address;
import com.avp.models.CreditCard;
import com.avp.models.Customer;
import com.avp.models.CustomerDTO;
import com.avp.models.CustomerUpdateDTO;
import com.avp.models.Order;
import com.avp.models.SessionDTO;
import com.avp.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	// Handler to get a list of all customers

	@CrossOrigin("*")
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomersHandler(@RequestHeader("token") String token){
		return new ResponseEntity<>(customerService.getAllCustomers(token), HttpStatus.ACCEPTED);
	}
	
	
	// Handler to Get a customer details of currently logged in user - sends data as per token

	@CrossOrigin("*")
	@GetMapping("/customer/current")
	public ResponseEntity<Customer> getLoggedInCustomerDetailsHandler(@RequestHeader("token") String token){
		return new ResponseEntity<>(customerService.getLoggedInCustomerDetails(token), HttpStatus.ACCEPTED);
	}
	
	
	// Handler to Update a customer
	@CrossOrigin("*")
	@PutMapping("/customer")
	public ResponseEntity<Customer> updateCustomerHandler(@Valid @RequestBody CustomerUpdateDTO customerUpdate, @RequestHeader("token") String token){
		return new ResponseEntity<>(customerService.updateCustomer(customerUpdate, token), HttpStatus.ACCEPTED);
	}
	
	
	// Handler to update a customer email-id or mobile no
	@CrossOrigin("*")
	@PutMapping("/customer/update/credentials")
	public ResponseEntity<Customer> updateCustomerMobileEmailHandler(@Valid @RequestBody CustomerUpdateDTO customerUpdate, @RequestHeader("token") String token){
		return new ResponseEntity<>(customerService.updateCustomerMobileNoOrEmailId(customerUpdate, token), HttpStatus.ACCEPTED);
	}
	
	
	// Handler to update customer password
	@CrossOrigin("*")
	@PutMapping("/customer/update/password")
	public ResponseEntity<SessionDTO> updateCustomerPasswordHandler(@Valid @RequestBody CustomerDTO customerDto, @RequestHeader("token") String token){		
		return new ResponseEntity<>(customerService.updateCustomerPassword(customerDto, token), HttpStatus.ACCEPTED);
	}
	
	
	// Handler to Add or update new customer Address
	@CrossOrigin("*")
	@PutMapping("/customer/update/address")
	public ResponseEntity<Customer> updateAddressHandler(@Valid @RequestBody Address address, @RequestParam("type") String type, @RequestHeader("token") String token){
		return new ResponseEntity<>(customerService.updateAddress(address, type, token), HttpStatus.ACCEPTED);
	}
	
	
	// Handler to update Credit card details
	@CrossOrigin("*")
	@PutMapping("/customer/update/card")
	public ResponseEntity<Customer> updateCreditCardHandler(@RequestHeader("token") String token, @Valid @RequestBody CreditCard newCard){
		return new ResponseEntity<>(customerService.updateCreditCardDetails(token, newCard), HttpStatus.ACCEPTED);
	}
	
	
	// Handler to Remove a user address
	@CrossOrigin("*")
	@DeleteMapping("/customer/delete/address")
	public ResponseEntity<Customer> deleteAddressHandler(@RequestParam("type") String type, @RequestHeader("token") String token){
		return new ResponseEntity<>(customerService.deleteAddress(type, token), HttpStatus.ACCEPTED);
	}
	
	// Handler to delete customer
	@CrossOrigin("*")
	@DeleteMapping("/customer")
	public ResponseEntity<SessionDTO> deleteCustomerHandler(@Valid @RequestBody CustomerDTO customerDto, @RequestHeader("token") String token){
		return new ResponseEntity<>(customerService.deleteCustomer(customerDto, token), HttpStatus.ACCEPTED);
	}



	@CrossOrigin("*")
	@GetMapping("/customer/orders")
	public ResponseEntity<List<Order>> getCustomerOrdersHandler(@RequestHeader("token") String token){
		return new ResponseEntity<>(customerService.getCustomerOrders(token), HttpStatus.ACCEPTED);
	}
}
