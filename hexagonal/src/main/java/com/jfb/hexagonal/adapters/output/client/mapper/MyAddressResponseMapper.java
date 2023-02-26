package com.jfb.hexagonal.adapters.output.client.mapper;

import com.jfb.hexagonal.adapters.output.client.response.AddressResponse;
import com.jfb.hexagonal.application.core.domain.Address;

public class MyAddressResponseMapper {

  public Address toAddress(AddressResponse addressResponse) {
    return Address.builder()
        .street(addressResponse.getStreet())
        .city(addressResponse.getCity())
        .state(addressResponse.getState())
        .build();
  }

  public AddressResponse toAddressResponse(Address address) {
    return AddressResponse.builder()
        .street(address.getStreet())
        .city(address.getCity())
        .state(address.getState())
        .build();
  }
}
