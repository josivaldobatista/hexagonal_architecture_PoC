package com.jfb.hexagonal.config;

import com.jfb.hexagonal.adapters.output.DeleteCustomerByIdAdapter;
import com.jfb.hexagonal.application.core.usecase.DeleteCustomerByIduseCase;
import com.jfb.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

  @Bean
  public DeleteCustomerByIduseCase deleteCustomerByIduseCase(
      FindCustomerByIdUseCase findCustomerByIdUseCase,
      DeleteCustomerByIdAdapter deleteCustomerByIdAdapter
  ) {
    return new DeleteCustomerByIduseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter);
  }
}
