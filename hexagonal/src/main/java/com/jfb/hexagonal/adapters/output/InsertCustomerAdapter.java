package com.jfb.hexagonal.adapters.output;

import com.jfb.hexagonal.adapters.output.repository.CustomerRepository;
import com.jfb.hexagonal.adapters.output.repository.entity.CustomerEntity;
import com.jfb.hexagonal.adapters.output.repository.mapper.MyCustomerEntityMapper;
import com.jfb.hexagonal.application.core.domain.Customer;
import com.jfb.hexagonal.application.ports.output.InsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

  @Autowired
  private CustomerRepository customerRepository;

  @Override
  public void insert(Customer customer) {
    CustomerEntity customerEntity = new MyCustomerEntityMapper().toCustomerEntity(customer);
    customerRepository.save(customerEntity);
  }
}
