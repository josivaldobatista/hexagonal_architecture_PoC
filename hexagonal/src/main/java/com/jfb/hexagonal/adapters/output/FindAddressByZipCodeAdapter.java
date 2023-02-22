package com.jfb.hexagonal.adapters.output;

import com.jfb.hexagonal.adapters.output.client.FindAddressByZipCodeClient;
import com.jfb.hexagonal.adapters.output.client.mapper.AddressResponseMapper;
import com.jfb.hexagonal.application.core.domain.Address;
import com.jfb.hexagonal.application.ports.output.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

  @Autowired
  private FindAddressByZipCodeClient findAddressByZipCodeClient;
  @Autowired
  private AddressResponseMapper addressResponseMapper;

  @Override
  public Address find(String zipCode) {
    var addressResponse = findAddressByZipCodeClient.find(zipCode);
    return addressResponseMapper.toAddress(addressResponse);
  }
}