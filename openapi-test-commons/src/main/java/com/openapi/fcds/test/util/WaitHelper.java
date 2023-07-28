package com.openapi.fcds.test.util;

public class WaitHelper {

  private WaitHelper() {
  }

  public static void sleep(Long seconds) {
    try {
      Thread.sleep(seconds * 1000);
    } catch (InterruptedException ignored) {
    }
  }
}
