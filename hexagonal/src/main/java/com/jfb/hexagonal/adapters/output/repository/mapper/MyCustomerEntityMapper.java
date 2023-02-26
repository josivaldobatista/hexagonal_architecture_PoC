package com.jfb.hexagonal.adapters.output.repository.mapper;

import com.jfb.hexagonal.adapters.output.repository.entity.CustomerEntity;
import com.jfb.hexagonal.application.core.domain.Customer;

public class MyCustomerEntityMapper {

  public CustomerEntity toCustomerEntity(Customer customer) {
    return CustomerEntity.builder()
        .id(customer.getId())
        .name(customer.getName())
        .cpf(customer.getCpf())
        .validCpf(customer.getValidCpf())
        .address(new AddressEntityMapper().toAddressEntity(customer.getAddress()))
        .build();
  }

  public Customer toCustomer(CustomerEntity customerEntity) {
    return Customer.builder()
        .id(customerEntity.getId())
        .name(customerEntity.getName())
        .cpf(customerEntity.getCpf())
        .validCpf(customerEntity.getValidCpf())
        .address(new AddressEntityMapper().toAddress(customerEntity.getAddress()))
        .build();
  }
}
