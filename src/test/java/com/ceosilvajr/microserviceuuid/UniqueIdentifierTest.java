/*
 * Copyright (c) 2018. ceosilvajr All rights reserved
 */

package com.ceosilvajr.microserviceuuid;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created date 27/03/2018
 *
 * @author ceosilvajr@gmail.com
 **/
public class UniqueIdentifierTest {

  @Test
  public void test() throws UnsupportedEncodingException, NoSuchAlgorithmException {
    final int size = 1000;
    final List<String> data = new ArrayList<>();
    for (int x = 0; x < size; x++) {
      final String uniqueId = UniqueIdentifier.getAphrodite().generateTransactionUniqueId();
      data.add(uniqueId);
    }
    boolean isUnique = data.stream().allMatch(new HashSet<>()::add);
    assertTrue(isUnique);
  }
}
