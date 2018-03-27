/*
 * Copyright (c) 2018. ceosilvajr All rights reserved
 */

package com.ceosilvajr.microserviceuuid.exceptions;

/**
 * Created date 27/03/2018
 *
 * @author ceosilvajr@gmail.com
 **/
public class UniqueIdentifierException extends RuntimeException {

  private static final long serialVersionUID = 2118414357134880698L;

  public UniqueIdentifierException(final Throwable t) {
    super("Can't generate unique identifier error:" + t.getMessage());
  }
}
