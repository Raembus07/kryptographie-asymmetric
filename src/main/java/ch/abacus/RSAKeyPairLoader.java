/*
 * RSAKeyPairLoader.java
 *
 * Creator:
 * 14.06.2024 10:21 josia.schweizer
 *
 * Maintainer:
 * 14.06.2024 10:21 josia.schweizer
 *
 * Last Modification:
 * $Id:$
 *
 * Copyright (c) 2024 ABACUS Research AG, All Rights Reserved
 */
package ch.abacus;

import java.io.InputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;

public class RSAKeyPairLoader {

  protected static KeyPair loadKeyPairFromKeyStore(String keystoreFileName, String keystorePassword, String privateKeyAlias, String privateKeyPassword, String publicKeyAlias) throws Exception {
    InputStream is = RSAKeyPairLoader.class.getClassLoader().getResourceAsStream(keystoreFileName);
    if (is == null) {
      throw new IllegalArgumentException("Keystore file not found in resources: " + keystoreFileName);
    }

    KeyStore keystore = KeyStore.getInstance("JKS");
    keystore.load(is, keystorePassword.toCharArray());

    final var key = keystore.getKey(privateKeyAlias, privateKeyPassword.toCharArray());
    if (key instanceof PrivateKey) {
      final var privateKey = (PrivateKey) key;
      final var certifictate = keystore.getCertificate(publicKeyAlias);
      final var publicKey = certifictate.getPublicKey();

      return new KeyPair(publicKey, privateKey);
    } else {
      throw new KeyStoreException("No private key found for alias: " + privateKeyAlias);
    }
  }

}