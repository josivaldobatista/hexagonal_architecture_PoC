package com.jfb.hexagonal.config;

import com.jfb.hexagonal.adapters.output.FindAddressByZipCodeAdapter;
import com.jfb.hexagonal.adapters.output.InsertCustomerAdapter;
import com.jfb.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

  @Bean
  public InsertCustomerUseCase insertCustomerUseCase(
      FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
      InsertCustomerAdapter insertCustomerAdapter
  ) {
    return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter);
  }
}
