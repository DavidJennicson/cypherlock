package com.example.cypher.enc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUnzipUtil {

    public static void zip(String sourcePath, String zipFilePath) throws IOException {
        FileOutputStream fos = new FileOutputStream(zipFilePath);
        ZipOutputStream zos = new ZipOutputStream(fos);
        File sourceFile = new File(sourcePath);
        zipFile(sourceFile, sourceFile.getName(), zos);
        zos.closeEntry();
        zos.close();
        System.out.println("Files zipped successfully.");
    }

    private static void zipFile(File fileToZip, String fileName, ZipOutputStream zos) throws IOException {
        if (fileToZip.isHidden()) {
            return;
        }

        if (fileToZip.isDirectory()) {
            File[] children = fileToZip.listFiles();
            for (File childFile : children) {
                zipFile(childFile, fileName + "/" + childFile.getName(), zos);
            }
        } else {
            FileInputStream fis = new FileInputStream(fileToZip);
            ZipEntry zipEntry = new ZipEntry(fileName);
            zos.putNextEntry(zipEntry);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) >= 0) {
                zos.write(buffer, 0, length);
            }

            fis.close();
        }
    }

    public static void unzip(String zipFilePath, String destDir) throws IOException {
        File destDirectory = new File(destDir);
        if (!destDirectory.exists()) {
            destDirectory.mkdirs();
        }

        byte[] buffer = new byte[1024];
        ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFilePath));
        ZipEntry zipEntry = zis.getNextEntry();
        while (zipEntry != null) {
            String fileName = zipEntry.getName();
            File newFile = new File(destDir + File.separator + fileName);

            if (zipEntry.isDirectory()) {
                newFile.mkdirs();
            } else {
                File parent = newFile.getParentFile();
                if (!parent.exists()) {
                    parent.mkdirs();
                }

                FileOutputStream fos = new FileOutputStream(newFile);
                int length;
                while ((length = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, length);
                }
                fos.close();
            }
            zis.closeEntry();
            zipEntry = zis.getNextEntry();
        }
        zis.close();
        System.out.println("Files unzipped successfully.");
    }

    public static void main(String[] args) {
        // Zip Example
//        String sourcePath = "C:\\Users\\david\\IdeaProjects\\cypher\\src\\main\\java\\com\\example\\cypher\\enc\\gth.txt";
//        String zipFilePath = "C:\\Users\\david\\IdeaProjects\\cypher\\src\\main\\java\\com\\example\\cypher\\enc\\gth.zip";
//
//        try {
//            ZipUnzipUtil.zip(sourcePath, zipFilePath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        // Unzip Example
        String unzipFilePath = "C:\\Users\\david\\IdeaProjects\\cypher\\src\\main\\java\\com\\example\\cypher\\enc\\gth.zip";
        String destDir = "C:\\Users\\david\\IdeaProjects\\cypher\\src\\main\\java\\com\\example\\cypher\\enc\\gthe.txt";

        try {
            ZipUnzipUtil.unzip(unzipFilePath, destDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
