package com.openapi.fcds.test.steps;

import com.openapi.fcds.test.client.api.*;
import com.openapi.fcds.test.steps.common.CommonData;
import com.openapi.fcds.test.steps.common.CommonDataProvider;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class AbstractApiBase {
  protected static final String todayDate = LocalDate.now()
      .format(DateTimeFormatter.ISO_LOCAL_DATE);
  protected static final String yesterdayDate = LocalDate.now().minusDays(1)
      .format(DateTimeFormatter.ISO_LOCAL_DATE);
  protected static final String tomorrowDate = LocalDate.now().plusDays(1)
      .format(DateTimeFormatter.ISO_LOCAL_DATE);
  protected static final String dayAfterTomorrowDate = LocalDate.now().plusDays(2)
      .format(DateTimeFormatter.ISO_LOCAL_DATE);

  protected final CommonData commonData;
  protected final SwapiRequestRestClient swapiRequestRestClient;

  public AbstractApiBase() {
    this.commonData = CommonDataProvider.get(Thread.currentThread().getId());
    this.swapiRequestRestClient = commonData.getSwapiRequestRestClient();
  }
}
