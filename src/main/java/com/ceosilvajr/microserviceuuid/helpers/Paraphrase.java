/*
 * Copyright (c) 2018. ceosilvajr All rights reserved
 */

package com.ceosilvajr.microserviceuuid.helpers;

/**
 * Created date 27/03/2018
 *
 * @author ceosilvajr@gmail.com
 **/
public enum Paraphrase {

  ZEUS("It is not possible either to trick or escape the mind of Zeus."),
  APHRODITE("Behind each woman rises the austere, sacred and mysterious face of Aphrodite.");

  private String value;

  Paraphrase(final String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

}
