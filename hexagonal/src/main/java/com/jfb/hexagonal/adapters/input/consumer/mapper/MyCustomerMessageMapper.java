package com.jfb.hexagonal.adapters.input.consumer.mapper;

import com.jfb.hexagonal.adapters.input.consumer.message.CustomerMessage;
import com.jfb.hexagonal.application.core.domain.Customer;

public class MyCustomerMessageMapper {

  public Customer toCustomer(CustomerMessage customerMessage) {
    return Customer.builder()
        .id(customerMessage.getId())
        .name(customerMessage.getName())
        .cpf(customerMessage.getCpf())
        .validCpf(customerMessage.getValidCpf())
        .build();
  }
}
