/*
 * Copyright (c) 2018. ceosilvajr All rights reserved
 */

package com.ceosilvajr.microserviceuuid;

import com.ceosilvajr.microserviceuuid.exceptions.UniqueIdentifierException;
import com.ceosilvajr.microserviceuuid.helpers.Paraphrase;
import com.ceosilvajr.microserviceuuid.helpers.Suffix;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.UUID;

/**
 * Created date 27/03/2018
 *
 * @author ceosilvajr@gmail.com
 **/
public class UniqueIdentifier {

  private String paraphrase;

  private UniqueIdentifier(final String paraphrase) {
    this.paraphrase = paraphrase;
  }

  public static UniqueIdentifier getInstanceOf(final String paraphrase) {
    return new UniqueIdentifier(paraphrase);
  }

  public static UniqueIdentifier getDefault() {
    return new UniqueIdentifier("");
  }

  public static UniqueIdentifier getZeus() {
    return new UniqueIdentifier(Paraphrase.ZEUS.getValue());
  }

  public static UniqueIdentifier getAphrodite() {
    return new UniqueIdentifier(Paraphrase.APHRODITE.getValue());
  }

  public String generateUniqueId(final String suffix) {
    try {
      return generateFromKey(paraphrase, suffix);
    } catch (final NoSuchAlgorithmException e) {
      throw new UniqueIdentifierException(e);
    }
  }

  public String generateUserUniqueId() {
    try {
      return generateFromKey(paraphrase, Suffix.USER.getValue());
    } catch (final NoSuchAlgorithmException e) {
      throw new UniqueIdentifierException(e);
    }
  }

  public String generateAccountUniqueId() {
    try {
      return generateFromKey(paraphrase, Suffix.ACCOUNT.getValue());
    } catch (final NoSuchAlgorithmException e) {
      throw new UniqueIdentifierException(e);
    }
  }

  public String generateTransactionUniqueId() {
    try {
      return generateFromKey(paraphrase, Suffix.TRANSACTION.getValue());
    } catch (final NoSuchAlgorithmException e) {
      throw new UniqueIdentifierException(e);
    }
  }

  private String generateFromKey(final String paraphrase, final String suffix)
      throws NoSuchAlgorithmException {
    final String source = String.format("%s%s", paraphrase, System.currentTimeMillis());
    final SecureRandom secureRandom = SecureRandom.getInstanceStrong();
    final UUID uuid = UUID.nameUUIDFromBytes(secureRandom.generateSeed(source.length()));
    return String.format("%s%s", suffix, uuid.toString().replace("-", ""));
  }
}
