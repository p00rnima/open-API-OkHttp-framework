package com.openapi.fcds.test.util;

import static org.assertj.core.api.Assertions.assertThat;

public final class AssertHelper {

  private AssertHelper() {
  }

  public static void aT(Boolean actualValue, String description) {
    assertThat(actualValue)
        .as(description)
        .isTrue();
  }

  public static void aF(Boolean actualValue, String description) {
    assertThat(actualValue)
        .as(description)
        .isFalse();
  }

  public static <T> void aE(T expectedValue, T actualValue, String description) {
    assertThat(actualValue)
        .as(description)
        .isEqualTo(expectedValue);
  }

  public static <T> void aNE(T expectedValue, T actualValue, String description) {
    assertThat(actualValue)
        .as(description)
        .isNotEqualTo(expectedValue);
  }
}
