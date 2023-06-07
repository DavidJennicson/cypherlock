package com.example.cypher.controllers;
import com.example.cypher.response.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;

@RestController
@RequestMapping("/files")
public class FileEncryptorController {

    private static final String AES = "AES";

    private static final String TARGET_DIRECTORY = "C:\\Users\\david\\IdeaProjects\\cypher\\storage\\29\\";

    @PostMapping("/encrypt")
    public Response encryptFile(@RequestParam("file") MultipartFile file,@RequestParam("password")String passw) {
        String key="hVmYq3t6v9y$B&E)H@McQfTjWnZr4u7x";
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        System.out.println(passw);
        try {
            byte[] fileBytes = file.getBytes();
            byte[] encryptedBytes = encryptBytes(fileBytes, key);
            String targetFilePath = TARGET_DIRECTORY + file.getOriginalFilename();
            writeBytesToFile(encryptedBytes, targetFilePath);
            Response res= new Response("File encrypted successfully.",200);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            Response res=new Response("Failed to encrypt the file.",400);
            return res;
        }
    }

    @PostMapping("/decrypt")
    public Response decryptFile(@RequestParam("file") MultipartFile file) {
        String key="hVmYq3t6v9y$B&E)H@McQfTjWnZr4u7x";
        try {
            byte[] fileBytes = file.getBytes();
            byte[] decryptedBytes = decryptBytes(fileBytes, key);
            String targetFilePath = TARGET_DIRECTORY + file.getOriginalFilename();
            writeBytesToFile(decryptedBytes, targetFilePath);
            Response res= new Response("File encrypted successfully.",200);
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            Response res=new Response("Failed to encrypt the file.",400);
            return res;
        }
    }

    private static void writeBytesToFile(byte[] bytes, String targetFilePath) throws IOException {
        try (OutputStream os = new FileOutputStream(targetFilePath)) {
            os.write(bytes);
        }
    }

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
