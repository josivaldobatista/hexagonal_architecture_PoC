package com.jfb.hexagonal.adapters.output.repository.mapper;

import com.jfb.hexagonal.adapters.output.repository.entity.CustomerEntity;
import com.jfb.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

  CustomerEntity toCustomerEntity(Customer customer); // customer para customerEntity
  Customer toCustomer(CustomerEntity customerEntity); // customerEntity para customer
}
