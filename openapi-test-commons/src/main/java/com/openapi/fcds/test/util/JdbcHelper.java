package com.openapi.fcds.test.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.jdbi.v3.Handle;
import org.jdbi.v3.Jdbi;
import org.jdbi.v3.pg.PostgresJdbiPlugin;

import java.util.List;
import java.util.Map;


@SuppressWarnings({"squid:S2095", "squid:S00112"})
@Slf4j
public class JdbcHelper {

  private Jdbi jdbi;
  private final String jdbcUrl;
  private final String dbUserName;
  private final String dbPassword;

  protected static final String EXECUTING_QUERY = "Executing query: ";

  public JdbcHelper(String jdbcUrl, String dbUserName, String dbPassword) {
    this.jdbcUrl = jdbcUrl;
    this.dbUserName = dbUserName;
    this.dbPassword = dbPassword;
  }

  private void initialiseJdBi() {
    try {
      jdbi = Jdbi.create(jdbcUrl, dbUserName, dbPassword).installPlugin(new PostgresJdbiPlugin());
    } catch (Exception e) {
      throw new RuntimeException("Database initialisation error");
    }
  }

  protected Handle getNewHandle() {
    if (jdbi == null) {
      initialiseJdBi();
    }
    return jdbi.open();
  }

  protected void closeHandle(Handle handle) {
    if (handle != null) {
      handle.close();
    }
  }

  private List<Map<String, Object>> getMaps(Handle handle, String query) {
    log.info(EXECUTING_QUERY + query + "\n");
    var searchCount = handle.select(query);
    closeHandle(handle);
    log.info(searchCount + "\n");
    return searchCount;
  }

}

