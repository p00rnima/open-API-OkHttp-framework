package com.openapi.fcds.test.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.unitils.reflectionassert.ReflectionAssert.assertLenientEquals;

public class ComparatorHelper {
  private static final Logger LOGGER = LoggerFactory.getLogger(ComparatorHelper.class);
  private ComparatorHelper() {
  }

  /* Sample method to show how to use this helper:
  public static <T, V> void validateOutcomeInResponse(T outcomeInRequest, V outcomeInResponse) {
    ComparatorHelper.validateSourceFieldsInTarget(outcomeInRequest, outcomeInResponse);
  }*/

  public static <T, V> void validateSourceFieldsInTarget(T source, V target) {
    Map<String, Object> sourceMap = new ObjectMapper().convertValue(source, Map.class);
    Map<String, Object> targetMap = new ObjectMapper().convertValue(target, Map.class);
    sourceMap.forEach(
        (k,v) -> {
          if(v instanceof LinkedHashMap) {
            validateSourceFieldsInTarget(v,targetMap.get(k));
          } else {
            try {
              assertLenientEquals("value of field \"" + k + "\" do not match", v, targetMap.get(k));
            }
            catch(NullPointerException e){
              LOGGER.error("Error no value found in target for " + k);
              e.printStackTrace();
            }
          }
        }
    );
  }
}