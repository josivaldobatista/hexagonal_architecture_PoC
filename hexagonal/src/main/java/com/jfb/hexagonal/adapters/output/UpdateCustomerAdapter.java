package com.jfb.hexagonal.adapters.output;

import com.jfb.hexagonal.adapters.output.repository.CustomerRepository;
import com.jfb.hexagonal.adapters.output.repository.mapper.MyCustomerEntityMapper;
import com.jfb.hexagonal.application.core.domain.Customer;
import com.jfb.hexagonal.application.ports.output.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

  @Autowired
  private CustomerRepository customerRepository;

  @Override
  public void update(Customer customer) {
    var customerEntity = new MyCustomerEntityMapper().toCustomerEntity(customer);
    customerRepository.save(customerEntity);
  }
}
