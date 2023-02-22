package com.jfb.hexagonal.adapters.input.controller.mapper;

import com.jfb.hexagonal.adapters.input.controller.request.CustomerRequest;
import com.jfb.hexagonal.adapters.input.controller.response.CustomerResponse;
import com.jfb.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "address", ignore = true)
  @Mapping(target = "validCpf", ignore = true)
  Customer toCustomer(CustomerRequest customerRequest);

  CustomerResponse toCustomerResponse(Customer customer);

}
