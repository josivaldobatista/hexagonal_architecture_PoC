package com.jfb.hexagonal.application.ports.input;

import com.jfb.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

  void insert(Customer customer, String zipCode);
}
