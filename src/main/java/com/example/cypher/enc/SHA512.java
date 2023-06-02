package com.example.cypher.enc;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SHA512 {
//    public static void main(String[] args) {
//        String originalMessage = "Hello, world!";
//
//        try {
//            // Perform SHA-512 encryption
//            String encryptedMessage = encryptSHA512(originalMessage);
//            System.out.println("Encrypted message: " + encryptedMessage);
//
//            // Perform SHA-512 decryption (SHA-512 is a one-way hashing algorithm, so decryption is not possible)
//            // However, you can compare the original message with a newly encrypted version to check for a match.
//            boolean isMatch = verifySHA512(originalMessage, encryptedMessage);
//            System.out.println("Verification result: " + isMatch);
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//    }

    public static String encryptSHA512(String message) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-512");
        byte[] hashedBytes = digest.digest(message.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(hashedBytes).toLowerCase();
    }

    public static boolean verifySHA512(String originalMessage, String encryptedMessage) throws NoSuchAlgorithmException {
        String newEncryptedMessage = encryptSHA512(originalMessage);
        return encryptedMessage.equals(newEncryptedMessage);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xFF & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
