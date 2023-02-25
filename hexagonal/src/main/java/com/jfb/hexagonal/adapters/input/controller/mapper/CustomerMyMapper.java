package com.jfb.hexagonal.adapters.input.controller.mapper;

import com.jfb.hexagonal.adapters.input.controller.request.CustomerRequest;
import com.jfb.hexagonal.application.core.domain.Customer;

public class CustomerMyMapper {

  public Customer toCustomer(CustomerRequest customerRequest) {
    return Customer.builder()
        .name(customerRequest.getName())
        .cpf(customerRequest.getCpf())
        .build();
  }
}
