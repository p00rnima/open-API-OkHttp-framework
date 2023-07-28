package com.openapi.fcds.test.util;

import static org.assertj.core.api.Assertions.assertThat;

import com.openapi.fcds.test.message.http.HttpResponseMessage;

public final class HttpAssertHelper {

  private HttpAssertHelper() {
  }

  private static void assertHttpStatus(int expectedStatus, HttpResponseMessage httpResponseMessage) {
    assertThat(httpResponseMessage.getStatusCode())
        .as("HTTP status code not matched on %s", httpResponseMessage.getUrl())
        .isEqualTo(expectedStatus);
  }

  public static void assertHttpStatusAsForbidden(HttpResponseMessage httpResponseMessage) {
    assertHttpStatus(403, httpResponseMessage);
  }
  
  public static void assertHttpStatusUnauthorized(HttpResponseMessage httpResponseMessage) {
    assertHttpStatus(401, httpResponseMessage);
  }

  public static void assertHttpStatusAsFound(HttpResponseMessage httpResponseMessage) {
    assertHttpStatus(302, httpResponseMessage);
  }
  
  public static void assertHttpStatusAsPaymentRequired(HttpResponseMessage httpResponseMessage) {
    assertHttpStatus(402, httpResponseMessage);
  }
  
  
  public static void assertHttpStatusAsConflict(HttpResponseMessage httpResponseMessage) {
    assertHttpStatus(409, httpResponseMessage);
  }

  public static void assertHttpStatusAsOk(HttpResponseMessage httpResponseMessage) {
    assertHttpStatus(200, httpResponseMessage);
  }

  public static void assertHttpStatusAsBadRequest(HttpResponseMessage httpResponseMessage) {
    assertHttpStatus(400, httpResponseMessage);
  }

  public static void assertHttpStatusAsInternalServerError(HttpResponseMessage httpResponseMessage) {
    assertHttpStatus(500, httpResponseMessage);
  }

  public static void assertHttpStatusNotImplemented(HttpResponseMessage httpResponseMessage) {
    assertHttpStatus(501, httpResponseMessage);
  }

  public static void assertHttpStatusAsNotFound(HttpResponseMessage httpResponseMessage) {
    assertHttpStatus(404, httpResponseMessage);
  }
  
  public static void assertHttpStatusAsUnprocessableEntity(HttpResponseMessage httpResponseMessage) {
    assertHttpStatus(422, httpResponseMessage);
  }

  public static void assertHttpStatusAsCreated(HttpResponseMessage httpResponseMessage) {
    assertHttpStatus(201, httpResponseMessage);
  }
  
  public static void assertHttpStatusAsAccepted(HttpResponseMessage httpResponseMessage) {
    assertHttpStatus(202, httpResponseMessage);
  }

  public static void assertHttpStatusAsMethodNotFound(HttpResponseMessage httpResponseMessage) {
    assertHttpStatus(405, httpResponseMessage);
  }

  public static void assertHttpStatusAs4xx(HttpResponseMessage httpResponseMessage) {
    assertThat((String.valueOf(httpResponseMessage.getStatusCode()).startsWith("4")))
        .as("HTTP status code is not 4xx on %s", httpResponseMessage.getUrl())
        .isTrue();
  }

  public static void assertHttpStatusNoContent(HttpResponseMessage httpResponseMessage) {
    assertHttpStatus(204, httpResponseMessage);
  }
}
