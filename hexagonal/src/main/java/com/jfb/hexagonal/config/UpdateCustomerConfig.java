package com.jfb.hexagonal.config;

import com.jfb.hexagonal.adapters.output.FindAddressByZipCodeAdapter;
import com.jfb.hexagonal.adapters.output.UpdateCustomerAdapter;
import com.jfb.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.jfb.hexagonal.application.core.usecase.UpdateCustomerUsercase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

  @Bean
  public UpdateCustomerUsercase updateCustomerUsercase(
      FindCustomerByIdUseCase findCustomerByIdUseCase,
      FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
      UpdateCustomerAdapter updateCustomerAdapter
  ) {
    return new UpdateCustomerUsercase(
        findCustomerByIdUseCase,
        findAddressByZipCodeAdapter,
        updateCustomerAdapter);
  }
}
