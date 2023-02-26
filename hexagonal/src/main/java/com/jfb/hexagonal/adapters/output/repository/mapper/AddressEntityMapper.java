package com.jfb.hexagonal.adapters.output.repository.mapper;

import com.jfb.hexagonal.adapters.output.repository.entity.AddressEntity;
import com.jfb.hexagonal.application.core.domain.Address;

public class AddressEntityMapper {

  public AddressEntity toAddressEntity(Address address) {
    return AddressEntity.builder()
        .street(address.getStreet())
        .city(address.getCity())
        .state(address.getState())
        .build();
  }

  public Address toAddress(AddressEntity addressEntity) {
    return Address.builder()
        .street(addressEntity.getStreet())
        .city(addressEntity.getCity())
        .state(addressEntity.getState())
        .build();
  }
}
