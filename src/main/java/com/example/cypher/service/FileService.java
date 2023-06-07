package com.example.cypher.service;
import java.io.*;
public interface FileService {
    public String StoreFile(File fil1);
    public String Addpassword(Long fileid);
    public String DecryptFile(File encfile);
}
