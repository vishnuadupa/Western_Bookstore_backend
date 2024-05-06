package com.avp.service;

import java.util.List;

import com.avp.exception.CustomerException;
import com.avp.exception.CustomerNotFoundException;
import com.avp.models.Address;
import com.avp.models.CreditCard;
import com.avp.models.Customer;
import com.avp.models.CustomerDTO;
import com.avp.models.CustomerUpdateDTO;
import com.avp.models.Order;
import com.avp.models.SessionDTO;

public interface CustomerService {
	
	public Customer addCustomer(Customer customer) throws CustomerException;
	
	public Customer getLoggedInCustomerDetails(String token) throws CustomerNotFoundException;
	
	public List<Customer> getAllCustomers(String token) throws CustomerNotFoundException;
	
	public Customer updateCustomer(CustomerUpdateDTO customer, String token) throws CustomerNotFoundException;
	
	public Customer updateCustomerMobileNoOrEmailId(CustomerUpdateDTO customerUpdateDTO, String token) throws CustomerNotFoundException;
	
	public Customer updateCreditCardDetails(String token, CreditCard card) throws CustomerException;
	
	public SessionDTO updateCustomerPassword(CustomerDTO customerDTO, String token) throws CustomerNotFoundException;
	
	public SessionDTO deleteCustomer(CustomerDTO customerDTO, String token) throws CustomerNotFoundException;
	
	public Customer updateAddress(Address address, String type, String token) throws CustomerException;
	
	public Customer deleteAddress(String type, String token) throws CustomerException, CustomerNotFoundException;

	public List<Order> getCustomerOrders(String token) throws CustomerException; 

}
