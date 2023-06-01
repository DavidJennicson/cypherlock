package com.example.cypher.enc;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ZipFileEncryption {
    private static final String KEY = "97#p8N&!OxOV7ov5"; // Replace with your secret key
    private static final String ALGORITHM = "AES";

    public static void encryptZipFile(File inputFile, File outputFile) throws Exception {
        byte[] keyBytes = KEY.getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile);
             CipherOutputStream cos = new CipherOutputStream(fos, cipher)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                cos.write(buffer, 0, bytesRead);
            }
        }
    }

    public static void decryptZipFile(File inputFile, File outputFile) throws Exception {
        byte[] keyBytes = KEY.getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

        try (FileInputStream fis = new FileInputStream(inputFile);
             CipherInputStream cis = new CipherInputStream(fis, cipher);
             FileOutputStream fos = new FileOutputStream(outputFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = cis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    public static void main(String[] args) {
        String inputFile = "C:\\Users\\david\\IdeaProjects\\cypher\\src\\main\\java\\com\\example\\cypher\\enc\\gth.zip"; // Replace with your input file path
   String encryptedFile = "C:\\Users\\david\\IdeaProjects\\cypher\\src\\main\\java\\com\\example\\cypher\\enc\\gthenc.zip"; // Replace with your encrypted file path
       String decryptedFile = "C:\\Users\\david\\IdeaProjects\\cypher\\src\\main\\java\\com\\example\\cypher\\enc\\gthdec.zip"; // Replace with your input file path
        // Replace with your decrypted file path

        try {
//            encryptZipFile(new File(inputFile), new File(encryptedFile));
//            System.out.println("File encrypted successfully!");

            decryptZipFile(new File(encryptedFile), new File(decryptedFile));
            System.out.println("File decrypted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
