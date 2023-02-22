package com.jfb.hexagonal.config;

import com.jfb.hexagonal.adapters.output.FindCustomerByIdAdapter;
import com.jfb.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

  @Bean
  public FindCustomerByIdUseCase findCustomerByIdUseCase(
      FindCustomerByIdAdapter findCustomerByIdAdapter
  ) {
    return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
  }
}
