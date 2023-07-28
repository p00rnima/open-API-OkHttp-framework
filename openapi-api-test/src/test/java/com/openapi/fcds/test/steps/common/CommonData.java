package com.openapi.fcds.test.steps.common;

import com.openapi.fcds.test.client.api.*;
import com.openapi.fcds.test.pojo.openapi.response.SinglePersonDetails;
import com.openapi.fcds.test.pojo.openapi.response.SwapiAllPeopleDetails;
import cucumber.api.Scenario;

import java.util.Collection;

public class CommonData {

  public Scenario scenario;
  public SinglePersonDetails singlePersonDetails;
  public SwapiAllPeopleDetails swapiAllPeopleDetails;
  private SwapiRequestRestClient swapiRequestRestClient;

  public CommonData() {
  }

  public SwapiRequestRestClient getSwapiRequestRestClient() {
    if (swapiRequestRestClient == null) {
      swapiRequestRestClient = new SwapiRequestRestClient();
    }
    return swapiRequestRestClient;
  }

  public Collection<String> scenarioTags() {
    return scenario.getSourceTagNames();
  }

}
