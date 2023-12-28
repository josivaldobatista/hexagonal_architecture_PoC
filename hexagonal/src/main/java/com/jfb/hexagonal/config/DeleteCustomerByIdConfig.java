package com.jfb.hexagonal.config;

import com.jfb.hexagonal.adapters.output.DeleteCustomerByIdAdapter;
import com.jfb.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import com.jfb.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

  @Bean
  public DeleteCustomerByIdUseCase deleteCustomerByIduseCase(
      FindCustomerByIdUseCase findCustomerByIdUseCase,
      DeleteCustomerByIdAdapter deleteCustomerByIdAdapter
  ) {
    return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter);
  }
}
