package com.jfb.hexagonal.adapters.output;

import com.jfb.hexagonal.application.ports.output.SendCpfForValidationOutputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SendCpfForValidationAdapter implements SendCpfForValidationOutputPort {

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  @Override
  public void send(String cpf) {
    kafkaTemplate.send("tp-cpf-validation", cpf).addCallback(
        success -> log.info("Mensagem enviada com sucesso!"),
        failure -> log.error("Falha ao enviar mensagem")
    );
  }
}
