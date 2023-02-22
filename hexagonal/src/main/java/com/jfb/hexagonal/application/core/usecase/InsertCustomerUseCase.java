package com.jfb.hexagonal.application.core.usecase;

import com.jfb.hexagonal.application.core.domain.Customer;
import com.jfb.hexagonal.application.ports.input.InsertCustomerInputPort;
import com.jfb.hexagonal.application.ports.output.FindAddressByZipCodeOutputPort;
import com.jfb.hexagonal.application.ports.output.InsertCustomerOutputPort;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerUseCase implements InsertCustomerInputPort {

  private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
  private final InsertCustomerOutputPort insertCustomerOutputPort;

  public InsertCustomerUseCase(
      FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
      InsertCustomerOutputPort insertCustomerOutputPort) {
    this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
    this.insertCustomerOutputPort = insertCustomerOutputPort;
  }

  @Override
  public void insert(Customer customer, String zipCode) {
    var address = findAddressByZipCodeOutputPort.find(zipCode);
    customer.setAddress(address);
    insertCustomerOutputPort.insert(customer);
  }
}
