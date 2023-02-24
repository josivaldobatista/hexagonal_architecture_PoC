package com.jfb.hexagonal.adapters.input.consumer.mapper;

import com.jfb.hexagonal.adapters.input.consumer.message.CustomerMessage;
import com.jfb.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {

  @Mapping(target = "address", ignore = true)
  Customer toCustomer(CustomerMessage customerMessage);
}
