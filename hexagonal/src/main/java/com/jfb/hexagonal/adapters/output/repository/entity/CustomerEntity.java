package com.jfb.hexagonal.adapters.output.repository.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "customers")
public class CustomerEntity {

  @Id
  private String id;
  private String name;
  private String cpf;
  private Boolean validCpf;
  private AddressEntity address;
}
