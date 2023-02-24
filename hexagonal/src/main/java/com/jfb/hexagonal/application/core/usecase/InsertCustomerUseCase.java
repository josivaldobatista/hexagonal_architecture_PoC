package com.jfb.hexagonal.application.core.usecase;

import com.jfb.hexagonal.application.core.domain.Customer;
import com.jfb.hexagonal.application.ports.input.InsertCustomerInputPort;
import com.jfb.hexagonal.application.ports.output.FindAddressByZipCodeOutputPort;
import com.jfb.hexagonal.application.ports.output.InsertCustomerOutputPort;
import com.jfb.hexagonal.application.ports.output.SendCpfForValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

  private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
  private final InsertCustomerOutputPort insertCustomerOutputPort;
  private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

  public InsertCustomerUseCase(
      FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
      InsertCustomerOutputPort insertCustomerOutputPort, SendCpfForValidationOutputPort sendCpfForValidationOutputPort) {
    this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
    this.insertCustomerOutputPort = insertCustomerOutputPort;
    this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
  }

  @Override
  public void insert(Customer customer, String zipCode) {
    var address = findAddressByZipCodeOutputPort.find(zipCode);
    customer.setAddress(address);
    insertCustomerOutputPort.insert(customer);
    sendCpfForValidationOutputPort.send(customer.getCpf());
  }
}
