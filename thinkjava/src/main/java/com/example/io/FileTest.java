package com.example.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class FileTest {
    String path = "D:\\des_tmp\\filetest";
    private SimpleDateFormat FileFormat = new SimpleDateFormat("yyyyMMdd");

    public static void main(String[] args) {
        FileTest fileTest = new FileTest();
        File fileRoot = new File(fileTest.path);
        System.out.println(fileRoot.exists());
        File file = new File(fileTest.path, fileTest.FileFormat.format(System.currentTimeMillis()) + "_suffix.txt");
        BufferedWriter bufWriter = null;
        try {
            System.out.println(file.exists());
            bufWriter = new BufferedWriter(new FileWriter(file, true));
            System.out.println(file.exists());
            bufWriter.write("hello world");
            System.out.println(file.exists());
            bufWriter.newLine();
            System.out.println(file.exists());
            bufWriter.flush();
            System.out.println(file.exists());
        } catch (Exception e) {
            e.printStackTrace();
            if (bufWriter != null) {
                try {
                    bufWriter.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }



    }
}
