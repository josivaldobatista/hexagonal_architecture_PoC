package com.jfb.hexagonal.adapters.input.controller;

import com.jfb.hexagonal.adapters.input.controller.mapper.CustomerMapper;
import com.jfb.hexagonal.adapters.input.controller.mapper.CustomerMyMapper;
import com.jfb.hexagonal.adapters.input.controller.request.CustomerRequest;
import com.jfb.hexagonal.adapters.input.controller.response.CustomerResponse;
import com.jfb.hexagonal.application.core.domain.Customer;
import com.jfb.hexagonal.application.ports.input.DeleteCustomerByIdInputPort;
import com.jfb.hexagonal.application.ports.input.FindCustomerByIdInputPort;
import com.jfb.hexagonal.application.ports.input.InsertCustomerInputPort;
import com.jfb.hexagonal.application.ports.input.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

  @Autowired
  private InsertCustomerInputPort insertCustomerInputPort;
  @Autowired
  private FindCustomerByIdInputPort findCustomerByIdInputPort;
  @Autowired
  private UpdateCustomerInputPort updateCustomerInputPort;
  @Autowired
  private DeleteCustomerByIdInputPort deleteCustomerByIdInputPort;
  @Autowired
  private CustomerMapper customerMapper;

  @PostMapping
  public ResponseEntity<Void> insert(@RequestBody @Valid CustomerRequest customerRequest) {
    Customer customer = new CustomerMyMapper().toCustomer(customerRequest);
    insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
    return ResponseEntity.ok().build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {
    var customer = findCustomerByIdInputPort.find(id);
    var customerResponse = customerMapper.toCustomerResponse(customer);
    return ResponseEntity.ok().body(customerResponse);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> update(@PathVariable final String id, @RequestBody CustomerRequest customerRequest) {
    Customer customer = customerMapper.toCustomer(customerRequest);
    customer.setId(id);
    updateCustomerInputPort.update(customer, customerRequest.getZipCode());
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable("id") String id) {
    deleteCustomerByIdInputPort.delete(id);
    return ResponseEntity.noContent().build();
  }
}
