package com.example.cypher.enc;
import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
public class FileEncryptor {
    private static final String AES="AES";
    private static byte[] encryptBytes(byte[] bytes, String key) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), AES);
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        return cipher.doFinal(bytes);
    }

    private static byte[] decryptBytes(byte[] encryptedBytes, String key) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), AES);
        Cipher cipher = Cipher.getInstance(AES);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        return cipher.doFinal(encryptedBytes);
    }
}
