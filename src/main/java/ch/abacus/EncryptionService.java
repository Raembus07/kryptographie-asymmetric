package ch.abacus;/*
 * EncryptionService.java
 *
 * Creator:
 * 14.06.2024 11:02 josia.schweizer
 *
 * Maintainer:
 * 14.06.2024 11:02 josia.schweizer
 *
 * Last Modification:
 * $Id:$
 *
 * Copyright (c) 2024 ABACUS Research AG, All Rights Reserved
 */

import java.security.KeyPair;

public interface EncryptionService {

  KeyPair getKeyPair() throws Exception;
}
