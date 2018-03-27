/*
 * Copyright (c) 2018. ceosilvajr All rights reserved
 */

package com.ceosilvajr.microserviceuuid.helpers;

/**
 * Created date 27/03/2018
 *
 * @author ceosilvajr@gmail.com
 **/
public enum Suffix {

  USER("US"), ACCOUNT("AC"), TRANSACTION("TS");

  private String value;

  Suffix(final String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
