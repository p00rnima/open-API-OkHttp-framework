package com.openapi.fcds.test.message.http;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class AbstractHttpMessage {

  Multimap<String, String> headers = ArrayListMultimap.create();
  Set<String> cookies = new HashSet<>();
  String url;
  String payload;
  String location;

  public String getPayload() {
    return payload;
  }

  public void setPayload(String payload) {
    this.payload = payload;
  }

  public Multimap<String, String> getHeaders() {
    return headers;
  }

  public void setHeaders(Multimap<String, String> headers) {
    this.headers = headers;
  }

  public Set<String> getCookies() {
    return cookies;
  }

  public void setCookies(Set<String> cookies) {
    this.cookies = cookies;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
  
}
