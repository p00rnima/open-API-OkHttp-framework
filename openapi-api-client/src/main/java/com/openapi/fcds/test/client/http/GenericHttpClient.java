package com.openapi.fcds.test.client.http;

import com.openapi.fcds.test.message.http.HttpRequestMessage;
import com.openapi.fcds.test.message.http.HttpResponseMessage;
import com.openapi.fcds.test.util.CustomLoggingInterceptor;
import com.google.common.collect.Multimap;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedTrustManager;
import lombok.extern.slf4j.Slf4j;

@SuppressWarnings("squid:S00112")
@Slf4j
public class GenericHttpClient {

  private static final String CONTENT_TYPE_HEADER = "Content-Type";
  private static final String MEDIA_TYPE_APP_JSON = "application/json";
  protected final OkHttpClient client;

  public GenericHttpClient(String identifier) {
    this(identifier, 0, true);
  }

  public GenericHttpClient(String identifier, int poolSize) {
    this(identifier, poolSize, true);
  }

  public GenericHttpClient(String identifier, int poolSize, boolean interceptHttp) {
    client = new OkHttpClient();
    client.setConnectTimeout(1, TimeUnit.MINUTES);
    client.setReadTimeout(1, TimeUnit.MINUTES);
    client.setFollowRedirects(false);
    if (interceptHttp) {
      Interceptor loggingInterceptor = new CustomLoggingInterceptor(log::info);
      client.interceptors().add(loggingInterceptor);
    }
    disableSsl();
    if (poolSize > 0) {
      client.setConnectionPool(new ConnectionPool(poolSize, 10, TimeUnit.MINUTES));
      log.info("Initialised Ok-http client for {} with connection pool size : {}", identifier,
          poolSize);
    }
  }

  private static HttpResponseMessage mapToHttpResponseMessage(final Response response) {
    var httpResponseMessage = new HttpResponseMessage();

    httpResponseMessage.setStatusCode(response.code());
    httpResponseMessage.setMessage(response.message());
    try {
      httpResponseMessage.setPayload(response.body().string());
    } catch (IOException e) {
      log.error(e.getMessage());
      throw new RuntimeException("Response body serialisation error");
    }

    response.headers().toMultimap().forEach((k, v) -> {
      if (k.equals("Set-Cookie")) {
        httpResponseMessage.setCookies(v.stream().map(i -> i.split(";")[0])
            .collect(Collectors.toSet()));
      } else {
        httpResponseMessage.getHeaders().put(k, v.get(0));
      }
    });

    return httpResponseMessage;
  }

  private static Headers buildHeadersFromMap(Multimap<String, String> headersMap) {
    var builder = new Headers.Builder();
    headersMap.asMap().forEach((k, v) -> v.forEach(i -> builder.add(k, i)));
    return builder.build();
  }

  private static HttpUrl buildHttpUrl(HttpRequestMessage httpRequestMessage) {
    var builder = HttpUrl.parse(httpRequestMessage.getUrl()).newBuilder();
    if (httpRequestMessage.getQueryParameters() != null) {
      httpRequestMessage.getQueryParameters().forEach(builder::addQueryParameter);
    }
    return builder.build();
  }

  public HttpResponseMessage get(HttpRequestMessage httpRequestMessage) {
    var request = new Request.Builder()
        .url(buildHttpUrl(httpRequestMessage))
        .headers(buildHeadersFromMap(httpRequestMessage.getHeaders()))
        .get()
        .build();
    return execute(request);
  }

  public HttpResponseMessage getWithBody(HttpRequestMessage httpRequestMessage, RequestBody requestBody) {
    var request = new Request.Builder()
            .url(buildHttpUrl(httpRequestMessage))
            .method("GET", requestBody)
            .headers(buildHeadersFromMap(httpRequestMessage.getHeaders()))
            .build();
    return execute(request);
  }

  public HttpResponseMessage post(final HttpRequestMessage httpRequestMessage,
                                     RequestBody requestBody) {
    final var request = new Request.Builder()
        .url(buildHttpUrl(httpRequestMessage))
        .headers(buildHeadersFromMap(httpRequestMessage.getHeaders()))
        .post(requestBody)
        .build();
    return execute(request);
  }

  public HttpResponseMessage post(final HttpRequestMessage httpRequestMessage) {
    var contentType = httpRequestMessage.getHeaders().get(CONTENT_TYPE_HEADER).stream()
        .findFirst();
    final var request = new Request.Builder()
        .url(buildHttpUrl(httpRequestMessage))
        .headers(buildHeadersFromMap(httpRequestMessage.getHeaders()))
        .post(RequestBody.create(
            MediaType.parse(contentType.isPresent() ? contentType.get() : MEDIA_TYPE_APP_JSON),
            httpRequestMessage.getPayload()))
        .build();
    return execute(request);
  }

  public HttpResponseMessage put(HttpRequestMessage httpRequestMessage) {
    var contentType = httpRequestMessage.getHeaders().get(CONTENT_TYPE_HEADER).stream()
        .findFirst();
    var request = new Request.Builder()
        .url(buildHttpUrl(httpRequestMessage))
        .headers(buildHeadersFromMap(httpRequestMessage.getHeaders()))
        .put(RequestBody.create(
            MediaType.parse(contentType.isPresent() ? contentType.get() : MEDIA_TYPE_APP_JSON),
            httpRequestMessage.getPayload()))
        .build();
    return execute(request);
  }

  public HttpResponseMessage patch(HttpRequestMessage httpRequestMessage) {
    var contentType = httpRequestMessage.getHeaders().get(CONTENT_TYPE_HEADER).stream()
        .findFirst();
    var request = new Request.Builder()
        .url(buildHttpUrl(httpRequestMessage))
        .headers(buildHeadersFromMap(httpRequestMessage.getHeaders()))
        .patch(RequestBody.create(
            MediaType.parse(contentType.isPresent() ? contentType.get() : MEDIA_TYPE_APP_JSON),
            httpRequestMessage.getPayload()))
        .build();
    return execute(request);
  }

  private HttpResponseMessage execute(final Request request) {
    try {
      var response = client.newCall(request).execute();
      return mapToHttpResponseMessage(response);
    } catch (IOException e) {
      log.error(e.getMessage());
      throw new RuntimeException(String
          .format("Http %s method failed with exception %s", request.method(), e.getMessage()));
    }
  }

  @SuppressWarnings("squid:S1186")
  // Disable ssl certification check
  private void disableSsl() {
    final var trustAllCerts = new TrustManager[]{new X509ExtendedTrustManager() {
      public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
      }

      public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {
      }

      public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {
      }

      @Override
      public void checkClientTrusted(X509Certificate[] arg0, String arg1, Socket arg2) {
      }

      @Override
      public void checkClientTrusted(X509Certificate[] arg0, String arg1, SSLEngine arg2) {
      }

      @Override
      public void checkServerTrusted(X509Certificate[] arg0, String arg1, Socket arg2) {
      }

      @Override
      public void checkServerTrusted(X509Certificate[] arg0, String arg1, SSLEngine arg2) {
      }
    }};

    // Install the all-trusting trust manager
    final SSLContext sslContext;
    try {
      sslContext = SSLContext.getInstance("SSL");
      sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

      // Create an ssl socket factory with our all-trusting manager
      final var sslSocketFactory = sslContext.getSocketFactory();

      client.setSslSocketFactory(sslSocketFactory);
      client.setHostnameVerifier((hostname, session) -> true);
    } catch (NoSuchAlgorithmException | KeyManagementException e) {
      log.error(e.getMessage());
    }
  }

  public HttpResponseMessage delete(HttpRequestMessage httpRequestMessage) {
    var contentType = httpRequestMessage.getHeaders().get(CONTENT_TYPE_HEADER).stream()
        .findFirst();
    var request = new Request.Builder()
        .url(buildHttpUrl(httpRequestMessage))
        .headers(buildHeadersFromMap(httpRequestMessage.getHeaders()))
        .delete(httpRequestMessage.getPayload() == null ? null :
            RequestBody.create(
                MediaType.parse(contentType.orElse(MEDIA_TYPE_APP_JSON)),
                httpRequestMessage.getPayload()))
        .build();
    return execute(request);
  }

}