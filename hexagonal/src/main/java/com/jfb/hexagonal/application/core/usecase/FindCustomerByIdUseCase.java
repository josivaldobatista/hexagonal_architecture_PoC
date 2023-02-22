package com.jfb.hexagonal.application.core.usecase;

import com.jfb.hexagonal.application.core.domain.Customer;
import com.jfb.hexagonal.application.ports.input.FindCustomerByIdInputPort;
import com.jfb.hexagonal.application.ports.output.FindCustomerByIdOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

  private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

  public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
    this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
  }

  @Override
  public Customer find(String id) {
    return findCustomerByIdOutputPort.find(id).orElseThrow(() -> new RuntimeException("Customer not found"));
  }
}
