package com.jfb.hexagonal.adapters.input.consumer;

import com.jfb.hexagonal.adapters.input.consumer.mapper.MyCustomerMessageMapper;
import com.jfb.hexagonal.adapters.input.consumer.message.CustomerMessage;
import com.jfb.hexagonal.application.ports.input.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

  @Autowired
  private UpdateCustomerInputPort updateCustomerInputPort;

  @KafkaListener(topics = "tp-cpf-validated", groupId = "jfbatis")
  public void receive(CustomerMessage customerMessage) {
    var customer = new MyCustomerMessageMapper().toCustomer(customerMessage);
    updateCustomerInputPort.update(customer, customerMessage.getZipCode());
  }
}
