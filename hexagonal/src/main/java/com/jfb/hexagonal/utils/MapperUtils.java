package com.jfb.hexagonal.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapperUtils {

  private static final ObjectMapper mapper = new ObjectMapper();
  private static final Logger log = LoggerFactory.getLogger(MapperUtils.class);

  public static <T> T jsonToObject(String jsonString, Class<T> target) {
    try {
      return mapper.readValue(jsonString, target);
    } catch (Exception ex) {
      log.error("Error json to object: " + ex.getMessage());
      return null;
    }
  }

  @SneakyThrows
  public static String formatResponseObject(Object obj) {
    return mapper.writeValueAsString(obj);
  }
}
