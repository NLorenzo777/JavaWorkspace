package com.acn.SimpleRestApi.api;

import com.acn.SimpleRestApi.exceptions.NoSuchCustomerExistsException;
import com.acn.SimpleRestApi.entity.Customer;
import com.acn.SimpleRestApi.exceptions.CustomerAlreadyExistsException;
import com.acn.SimpleRestApi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerServiceController {

  @Autowired
  CustomerService customerService;

  @GetMapping("/getCustomer/{id}")
  public Customer getCustomer(@PathVariable("id") Long id) {
    return customerService.getCustomer(id);
  }

  @PostMapping("/addCustomer")
  public String addCustomer(@RequestBody Customer customer) {
    return customerService.addCustomer(customer);
  }

  @PutMapping("/putMapping")
  public String updateCustomer(@RequestBody Customer customer) {
  return customerService.updateCustomer(customer);
  }

  @ExceptionHandler(value = NoSuchCustomerExistsException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public @ResponseBody ErrorResponse handleInvalidCustomerId(NoSuchCustomerExistsException e) {
    return ErrorResponse.create(e, HttpStatus.NOT_FOUND, e.getMessage());
  }

  @ExceptionHandler(value = CustomerAlreadyExistsException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorResponse handleConflictCustomerId(CustomerAlreadyExistsException e) {
    return ErrorResponse.create(e, HttpStatus.NOT_FOUND, e.getMessage());
  }
}
