package com.jfb.hexagonal.adapters.input.controller.response;

import com.jfb.hexagonal.adapters.output.client.response.AddressResponse;
import lombok.Data;

@Data
public class CustomerResponse {

  private String name;
  private AddressResponse address;
  private String cpf;
  private Boolean validCpf;

}
