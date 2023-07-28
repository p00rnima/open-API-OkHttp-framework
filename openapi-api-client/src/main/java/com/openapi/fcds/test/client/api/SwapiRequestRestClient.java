package com.openapi.fcds.test.client.api;

import com.openapi.fcds.test.client.http.GenericHttpClient;
import com.openapi.fcds.test.message.http.HttpRequestMessage;
import com.openapi.fcds.test.message.http.HttpResponseMessage;

import static com.openapi.fcds.test.util.PropertyHelper.prop;
import static com.openapi.fcds.test.util.StringHelper.substitute;

public class SwapiRequestRestClient {

    private static final GenericHttpClient httpClient;
    public static final String SWAPI_BASE_URL = prop("swapiBaseUrl");
    public static final String GET_PEOPLE_DETAILS = prop("getPeopleDetails");
    public static final String GET_ALL_PEOPLE_DETAILS = prop("getAllPeopleDetails");
    public static final String PEOPLE_ID = "people_id";

    static {
        httpClient =
                new GenericHttpClient(
                        "SwapiRequestRestClient",
                        (Integer.parseInt(prop("swapiRequestConnectionPoolSize", "10"))));
    }

    public HttpResponseMessage getSinglePersonDetails(String peopleId) {

        var url = SWAPI_BASE_URL + GET_PEOPLE_DETAILS;
        url = substitute(url, PEOPLE_ID, peopleId);
        var httpRequestMessage = new HttpRequestMessage()
                .withUrl(url);
        return httpClient.get(
                httpRequestMessage.withAcceptAsJson());
    }

    public HttpResponseMessage getAllPeopleDetails() {

        var url = SWAPI_BASE_URL + GET_ALL_PEOPLE_DETAILS;
        var httpRequestMessage = new HttpRequestMessage()
                .withUrl(url);
        return httpClient.get(
                httpRequestMessage.withAcceptAsJson());
    }
}
