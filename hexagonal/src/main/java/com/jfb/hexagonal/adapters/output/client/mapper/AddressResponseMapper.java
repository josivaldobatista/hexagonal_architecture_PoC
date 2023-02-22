package com.jfb.hexagonal.adapters.output.client.mapper;

import com.jfb.hexagonal.adapters.output.client.response.AddressResponse;
import com.jfb.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

  Address toAddress(AddressResponse addressResponse);
}
