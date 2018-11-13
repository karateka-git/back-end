package com.sevenbits;

import java.io.*;

public class Main {
    public static void main(final String[] args) {
        String fileNameReadable = "Homework3.txt";
        String fileNameCreated = "MyHomework.txt";
        byte[] mySecondName = {'E', 'r', 'o', 'f', 'e', 'e', 'v'};
        String fileSeparator = File.separator;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("src").append(fileSeparator).append("main").append(fileSeparator)
                .append("resources").append(fileSeparator).append("files");

        File dir = new File(String.valueOf(stringBuilder));
        File fileCreated = new File(dir, fileNameCreated);
        File fileReadable = new File(dir, fileNameReadable);

        try {
            if (!fileCreated.createNewFile()) {
                System.out.println("file already exists");
            } else {
                System.out.println("file created");
            }
        } catch (IOException e) {
            e.getMessage();
        }


        byte[] data = new byte[(int) fileReadable.length()];
        try {
            new FileInputStream(fileReadable).read(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            OutputStream recording = new FileOutputStream(fileCreated);
            recording.write(data);
            recording.write(mySecondName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            FileReader fileReader = new FileReader(fileCreated);
            while (fileReader.hasMoreLines()) {
                System.out.println(fileReader.readLine());
            }
        } catch (IOException e) {
            e.getMessage();
        }

        Example example = new Example();
        try {
            System.out.println(example.getLongestLineCharsCount(new FileReader(fileCreated)));
        } catch (IOException e) {
            e.getMessage();
        }

    }
}
