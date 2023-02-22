package com.jfb.hexagonal.application.ports.output;

import com.jfb.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {

  Optional<Customer> find(String id);

}
