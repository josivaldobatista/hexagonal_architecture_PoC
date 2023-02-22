package com.jfb.hexagonal.application.core.usecase;

import com.jfb.hexagonal.application.core.domain.Customer;
import com.jfb.hexagonal.application.ports.input.FindCustomerByIdInputPort;
import com.jfb.hexagonal.application.ports.output.FindAddressByZipCodeOutputPort;
import com.jfb.hexagonal.application.ports.output.UpdateCustomerOutputPort;

public class UpdateCustomerUsercase {

  private final FindCustomerByIdInputPort findCustomerByIdInputPort;
  private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
  private final UpdateCustomerOutputPort updateCustomerOutputPort;

  public UpdateCustomerUsercase(
      FindCustomerByIdInputPort findCustomerByIdInputPort,
      FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
      UpdateCustomerOutputPort updateCustomerOutputPort) {
    this.findCustomerByIdInputPort = findCustomerByIdInputPort;
    this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
    this.updateCustomerOutputPort = updateCustomerOutputPort;
  }

  public void update(Customer customer, String zipCode) {
    findCustomerByIdInputPort.find(customer.getId());
    var address = findAddressByZipCodeOutputPort.find(zipCode);
    customer.setAddress(address);
    updateCustomerOutputPort.update(customer);
  }
}
