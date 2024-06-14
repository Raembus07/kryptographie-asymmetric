/*
 * Client.java
 *
 * Creator:
 * 14.06.2024 10:55 josia.schweizer
 *
 * Maintainer:
 * 14.06.2024 10:55 josia.schweizer
 *
 * Last Modification:
 * $Id:$
 *
 * Copyright (c) 2024 ABACUS Research AG, All Rights Reserved
 */
package ch.abacus;

import ch.abacus.common.Const;

import java.security.KeyPair;

import static ch.abacus.RSAKeyPairLoader.loadKeyPairFromKeyStore;

public class ClientEncryptionService implements EncryptionService {

  @Override
  public KeyPair getKeyPair() throws Exception {
    return loadKeyPairFromKeyStore(Const.CLIENT_KEYSTORE_FILE, Const.CLIENT_KEYSTORE_PASSWORD, Const.CLIENT_PRIVATE_KEY_ALIAS, Const.CLIENT_PRIVATE_KEY_PASSWORD, Const.CLIENT_PUBLIC_KEY_ALIAS);
  }
}