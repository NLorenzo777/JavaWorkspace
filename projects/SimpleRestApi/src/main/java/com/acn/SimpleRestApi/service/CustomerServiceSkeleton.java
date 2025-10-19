package com.acn.SimpleRestApi.service;

import com.acn.SimpleRestApi.entity.Customer;

public interface CustomerServiceSkeleton {
  Customer getCustomer(Long id);
  String addCustomer(Customer customer);
  String updateCustomer(Customer customer);
}