package com.openapi.fcds.test.steps.common;

import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class CommonDataProvider {

  private static final ConcurrentHashMap<Long, CommonData> commonDataMap =
      new ConcurrentHashMap<>();
  private static final Logger LOGGER = LoggerFactory.getLogger(CommonDataProvider.class);

  private CommonDataProvider() {}
  
  static void newCommonData(Long uniqueId) {
    newCommonData(uniqueId, false);
  }

  static void newCommonData(Long uniqueId, boolean copyRegisteredUser) {
    LOGGER.info("Attempting to create new common data object for id : {}", uniqueId);

    var commonData = commonDataMap.get(uniqueId);

      commonDataMap.put(uniqueId, new CommonData());

    LOGGER.info("Created common data object for id: {}", uniqueId);
    
    
  }

  public static CommonData get(Long uniqueId) {
    return commonDataMap.get(uniqueId);
  }
}
