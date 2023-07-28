package com.openapi.fcds.test.client.http;

@SuppressWarnings("squid:S00112")
public class FollowRedirectHttpClient extends GenericHttpClient {

  public FollowRedirectHttpClient(String identifier, int poolSize) {
    super(identifier, poolSize, true);
  }

  public FollowRedirectHttpClient(String identifier, int poolSize, boolean interceptHttp) {
    super(identifier, poolSize, interceptHttp);
    client.setFollowRedirects(true);
  }

}