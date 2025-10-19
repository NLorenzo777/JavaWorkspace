package com.acn.SimpleRestApi.service;

import com.acn.SimpleRestApi.exceptions.NoSuchCustomerExistsException;
import com.acn.SimpleRestApi.entity.Customer;
import com.acn.SimpleRestApi.repository.CustomerRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements CustomerServiceSkeleton {

  @Autowired(required = false)
  private CustomerRepository customerRepository;


  @Override
  public Customer getCustomer(Long id) {
    return customerRepository.findById(id).orElseThrow(
        () -> new NoSuchCustomerExistsException("NO VALID CUSTOMER WITH ID: " + id)
    );

  }

  @Override
  public String addCustomer(Customer customer) {
    Optional<Customer> existingCustomer = customerRepository.findById(customer.getId());

    if (existingCustomer.isPresent()) {
      customerRepository.save(customer);
      return "CUSTOMER WITH ID: " + customer.getId() + " ADDED SUCCESSFULLY";
    } else {
      throw new NoSuchCustomerExistsException("INVALID CUSTOMER ID");
    }
  }

  @Override
  public String updateCustomer(Customer customer) {
    Optional<Customer> existingCustomer = customerRepository.findById(customer.getId());

    if (existingCustomer.isPresent()) {
      existingCustomer.get().setName(customer.getName());
      existingCustomer.get().setEmail(customer.getEmail());
      existingCustomer.get().setAddress(customer.getAddress());

      customerRepository.save(existingCustomer.get());
      return "CUSTOMER WITH ID: " + customer.getId() + " UPDATED SUCCESSFULLY";
    } else {
      throw new NoSuchCustomerExistsException("INVALID CUSTOMER ID");
    }
  }
}
