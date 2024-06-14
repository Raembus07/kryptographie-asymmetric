/*
 * Server.java
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
import ch.abacus.components.PersonDTO;
import ch.abacus.symmetric.SecurityUtil;
import ch.abacus.symmetric.SymmetricCrypting;
import org.glassfish.jaxb.core.v2.TODO;

import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.util.Base64;

import static ch.abacus.RSAKeyPairLoader.loadKeyPairFromKeyStore;

public class ServerEncryptionService implements EncryptionService {

  private static final String SERVER_KEYSTORE_FILE = "server.jks";

  private final SymmetricCrypting symmetricCrypting = new SymmetricCrypting();

  @Override
  public KeyPair getKeyPair() throws Exception {
    return loadKeyPairFromKeyStore(Const.SERVER_KEYSTORE_FILE, Const.SERVER_KEYSTORE_PASSWORD, Const.SERVER_PRIVATE_KEY_ALIAS, Const.SERVER_PRIVATE_KEY_PASSWORD, Const.SERVER_PUBLIC_KEY_ALIAS);
  }

  protected SecuredMessage encode(PersonDTO personDTO) throws Exception {
    final var sessionKey = SecurityUtil.createSessionKey();
    final var encryptedPerson = symmetricCrypting.encodePersonDTO(personDTO, sessionKey);
    final var encryptedPersonBase64 = Base64.getEncoder().encodeToString(encryptedPerson.getBytes());
    //TODO: put everything that is connected to the session key down into the encodeKey except for the "sessionkeycreating"
    final var encryptedSessionKey = encodeKey(sessionKey);
    final var encryptedSessionKeyBase64 = Base64.getEncoder().encodeToString(encryptedSessionKey.getBytes());

    return new SecuredMessage(encryptedSessionKeyBase64, encryptedPersonBase64);
  }

  protected PersonDTO decode(SecuredMessage securedMessage) throws Exception{
    final var encryptedSessionKeyString = Base64.getDecoder().decode(securedMessage.sessionKey());
    final var sessionKeyString = decodeKey(encryptedSessionKeyString);
    final var sessionKey = SecurityUtil.createSesssionKeyFromKeystring(sessionKeyString);

    final var encryptedPersonDTOStringBase64 = securedMessage.message();
    return symmetricCrypting.decodePersonDTO(encryptedPersonDTOStringBase64, sessionKey);

  }

  private String encodeKey(SecretKey sessionKey) {
    return null;
  }

  private byte[] decodeKey(byte[] sessionKeyBase64) {
    return null;
  }

}