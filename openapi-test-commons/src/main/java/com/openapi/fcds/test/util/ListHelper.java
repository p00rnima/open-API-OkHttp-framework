package com.openapi.fcds.test.util;

import java.util.List;

public class ListHelper {

  public static boolean doesItemExistsInList(List<String> list, String substring) {
    return list.stream()
        .anyMatch(item -> item.toLowerCase().contains(substring.toLowerCase()));
  }

}
