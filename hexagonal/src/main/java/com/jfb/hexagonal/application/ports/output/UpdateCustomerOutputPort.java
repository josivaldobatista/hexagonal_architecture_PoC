package com.jfb.hexagonal.application.ports.output;

import com.jfb.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {

  void update(Customer customer);
}
