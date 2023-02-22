package com.jfb.hexagonal.application.ports.output;

import com.jfb.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

  Address find(String zip);
}
