package com.openapi.fcds.test.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;

public class JsonObject {

  private JsonObject() {
  }

  public static String objectToJson(Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      throw new JsonDeSerialisationException(e.getMessage());
    }
  }

  public static <T> T jsonToObject(String json, Class<T> clazz) {
    try {
      return new ObjectMapper().readValue(json, clazz);
    } catch (IOException e) {
      throw new JsonDeSerialisationException(e.getMessage());
    }
  }

  public static <T> List<T> jsonToList(String json, Class<T> clazz) {
    try {
      return new ObjectMapper().readValue(json, new ObjectMapper()
          .getTypeFactory().constructCollectionType(List.class, clazz));
    } catch (IOException e) {
      throw new JsonDeSerialisationException(e.getMessage());
    }
  }

  private static class JsonDeSerialisationException extends RuntimeException {

    JsonDeSerialisationException(String msg) {
      super(msg);
    }
  }


}
