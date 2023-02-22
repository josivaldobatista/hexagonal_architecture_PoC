package com.jfb.hexagonal.application.core.usecase;

import com.jfb.hexagonal.application.ports.input.DeleteCustomerByIdInputPort;
import com.jfb.hexagonal.application.ports.input.FindCustomerByIdInputPort;
import com.jfb.hexagonal.application.ports.output.DeleteCustomerByIdOutputPort;

public class DeleteCustomerByIduseCase implements DeleteCustomerByIdInputPort {

  private final FindCustomerByIdInputPort findCustomerByIdInputPort;
  private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

  public DeleteCustomerByIduseCase(FindCustomerByIdInputPort findCustomerByIdInputPort, DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort) {
    this.findCustomerByIdInputPort = findCustomerByIdInputPort;
    this.deleteCustomerByIdOutputPort = deleteCustomerByIdOutputPort;
  }

  @Override
  public void delete(String id) {
    findCustomerByIdInputPort.find(id);
    deleteCustomerByIdOutputPort.delete(id);
  }
}
