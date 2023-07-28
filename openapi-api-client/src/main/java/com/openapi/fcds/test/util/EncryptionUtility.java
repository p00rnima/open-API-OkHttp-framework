package com.openapi.fcds.test.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.Base64;

/**
 * Contains encryption and decryption APIs.
 */
public class EncryptionUtility {
  public EncryptionUtility() {
  }
  
  
  private final static Logger LOGGER = LoggerFactory.getLogger(EncryptionUtility.class);

  /**
   * Generate the SHA-256 hash of the text passed in.
   *
   * @param text
   *          The text to generate a hash from.
   * @return The SHA-256 hash of the text passed in, as a hex string, or null if the text is null or
   *         there was an error.
   */
  public static String generateSHA256Hash(String text) {
    if (text == null) {
      return null;
    }

    try {
      MessageDigest md = MessageDigest.getInstance("SHA-256");
      md.update(text.getBytes());
      byte byteData[] = md.digest();

      StringBuilder sb = new StringBuilder();
      for (byte element : byteData) {
        String hex = Integer.toHexString(0xff & element);
        if (hex.length() == 1) {
          sb.append('0');
        }
        sb.append(hex);
      }

      System.out.println("Password 256 hash   " + sb.toString() + "  End of password 256");
      return sb.toString();
    }
    catch (NoSuchAlgorithmException e) {
      LOGGER.error("[generateSHA256Hash] NoSuchAlgorithmException", e);
    }
    return null;
  }
  
  /**
   * Generate the Base64 hash of the text passed in.
   *
   * @param text
   *          The text to generate a hash from.
   * @return The Base64 hash of the text passed in, as a hex string, or null if the text is null or
   *         there was an error.
   */
  public static String generateBase64Hash(String text) {
    if (text == null) {
      return null;
    }
  
    String encodeBytes = Base64.getEncoder().encodeToString(text.getBytes());
    System.out.println("Password Base 64 hash   " + encodeBytes + "  End of password Base 64");
    return encodeBytes;
  }

  /**
   * Generate the MD5 hash of the text passed in.
   *
   * @param text
   *          The text to generate a hash from.
   * @return The MD5 hash of the text passed in, as a hex string, or null if the text is null or
   *         there was an error.
   */
  public static String generateMD5Hash(String text) {
    if (text == null) {
      return null;
    }

    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      md.update(text.getBytes());
      byte byteData[] = md.digest();

      StringBuilder sb = new StringBuilder();
      for (byte element : byteData) {
        String hex = Integer.toHexString(0xff & element);
        if (hex.length() == 1) {
          sb.append('0');
        }
        sb.append(hex);
      }

      return sb.toString();
    }
    catch (NoSuchAlgorithmException e) {
      LOGGER.error("[generateMD5Hash] NoSuchAlgorithmException", e);
    }
    return null;
  }
}