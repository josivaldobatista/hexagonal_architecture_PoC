package com.jfb.hexagonal.adapters.input.controller.mapper;

import com.jfb.hexagonal.adapters.input.controller.request.CustomerRequest;
import com.jfb.hexagonal.adapters.input.controller.response.CustomerResponse;
import com.jfb.hexagonal.adapters.output.client.mapper.MyAddressResponseMapper;
import com.jfb.hexagonal.adapters.output.client.response.AddressResponse;
import com.jfb.hexagonal.application.core.domain.Customer;

import java.util.UUID;

public class MyCustomerMapper {

  public Customer toCustomer(CustomerRequest customerRequest) {
    return Customer.builder()
        .id(UUID.randomUUID().toString())
        .name(customerRequest.getName())
        .cpf(customerRequest.getCpf())
        .validCpf(false)
        .build();
  }

  public CustomerResponse toCustomerResponse(Customer customer) {
    return CustomerResponse.builder()
        .name(customer.getName())
        .address(new MyAddressResponseMapper().toAddressResponse(customer.getAddress()))
        .cpf(customer.getCpf())
        .validCpf(customer.getValidCpf())
        .build();
  }
}
