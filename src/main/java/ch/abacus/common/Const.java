/*
 * Const.java
 *
 * Creator:
 * 14.06.2024 07:44 josia.schweizer
 *
 * Maintainer:
 * 14.06.2024 07:44 josia.schweizer
 *
 * Last Modification:
 * $Id:$
 *
 * Copyright (c) 2024 ABACUS Research AG, All Rights Reserved
 */
package ch.abacus.common;

public class Const {
  private Const(){
    //this constructor has to be empty
  }

  public static final String AES = "AES";
  public static final String AES_GCM_NO_PADDING = "AES/GCM/NoPadding";
  public static final int TAG_LENGTH = 128;
  public static final String SYMETRIC_ALGORITHM_SAVE = "AES/GCM/NoPadding";

  public static final String CLIENT_KEYSTORE_FILE = "client.jks";
  public static final String CLIENT_KEYSTORE_PASSWORD = "changeit";
  public static final String CLIENT_PRIVATE_KEY_ALIAS = "marco";
  public static final String CLIENT_PRIVATE_KEY_PASSWORD = "changeit";
  public static final String CLIENT_PUBLIC_KEY_ALIAS = "abacollege";

  public static final String SERVER_KEYSTORE_FILE = "server.jks";
  public static final String SERVER_KEYSTORE_PASSWORD = "elielieli";
  public static final String SERVER_PRIVATE_KEY_ALIAS = "abacollege";
  public static final String SERVER_PRIVATE_KEY_PASSWORD = "elielieli";
  public static final String SERVER_PUBLIC_KEY_ALIAS = "marco";
}