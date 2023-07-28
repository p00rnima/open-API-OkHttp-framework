package com.openapi.fcds.test.message.http;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class HttpRequestMessage extends AbstractHttpMessage {
  
  private static final String CONTENT_TYPE_HEADER = "Content-Type";
  private Map<String, String> queryParameters;
  
  public HttpRequestMessage withJsonContentType() {
    getHeaders().put(CONTENT_TYPE_HEADER, "application/json; charset=utf-8");
    return this;
  }
  
  public HttpRequestMessage withXmlContentType() {
    getHeaders().put(CONTENT_TYPE_HEADER, "application/xml");
    return this;
  }
  
  public HttpRequestMessage withFormUrlEncodedContentType() {
    getHeaders().put(CONTENT_TYPE_HEADER, "application/x-www-form-urlencoded");
    return this;
  }
  
  public HttpRequestMessage withFormData() {
    getHeaders().put(CONTENT_TYPE_HEADER, "multipart/form-data");
    return this;
  }
  
  public HttpRequestMessage withQueryParameter(String name, String value) {
    if (queryParameters == null) {
      queryParameters = new HashMap<>();
    }
    try {
      queryParameters.put(name, value);
    } catch (Exception e) {
      log.error(e.getMessage());
    }
    return this;
  }
  
  public Map<String, String> getQueryParameters() {
    return queryParameters;
  }
  
  public HttpRequestMessage withHeader(String name, String val) {
    headers.put(name, val);
    return this;
  }
  
  public HttpRequestMessage withBearerAuthHeader(String val) {
    headers.put("authorization", "Bearer " + val);
    return this;
  }
  
  public HttpRequestMessage withBasicAuthHeader(String val) {
    headers.put("authorization", "Basic " + val);
    return this;
  }
  
  public HttpRequestMessage withXApiKey(String val) {
    headers.put("x-api-key", val);
    return this;
  }
  
  public HttpRequestMessage withCookie(String name, String val) {
    headers.put("Cookie", name + "=" + val);
    return this;
  }
  
  public HttpRequestMessage withCookie(Set<String> cookies) {
    if (!cookies.isEmpty()) {
      cookies.stream().reduce((s, s2) -> s + "; " + s2).ifPresent(s -> headers.put("Cookie", s));
    }
    return this;
  }
  
  public HttpRequestMessage withPayload(String payload) {
    this.payload = payload;
    return this;
  }
  
  public HttpRequestMessage withUrl(String url) {
    this.url = url;
    return this;
  }
  
  public HttpRequestMessage withAcceptAsJson() {
    return withHeader("Accept", "application/json");
  }
}
