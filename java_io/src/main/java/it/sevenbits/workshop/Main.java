package it.sevenbits.workshop;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    private static int iteration = 0;
    public static void main(final String[] args) throws Exception{

        try (
                Writer fileWriter = new OutputStreamWriter(new FileOutputStream(new File("test.txt")), StandardCharsets.UTF_8);
        ) {
            getListFiles("/home/mrvladislav/Desktop/courses/test/", fileWriter, 0);
        }
    }

    private static void getListFiles(String str, Writer fileWriter, int n) throws IOException{
        File f = new File(str);
        for (File s : f.listFiles()) {
            Main.iteration++;
            char r = (Files.isReadable(Paths.get(s.getAbsolutePath()))) ? 'r' : '-';
            char w = (Files.isWritable(Paths.get(s.getAbsolutePath()))) ? 'w' : '-';
            char x = (Files.isExecutable(Paths.get(s.getAbsolutePath()))) ? 'x' : '-';
            if (s.isFile()) {
                fileWriter.write(repeat(' ',n) + s.getName()+" file "+r+w+x + ' ' + s.getAbsolutePath() + '\n');
            } else if (s.isDirectory()) {
                fileWriter.write(s.getName()+" directory "+r+w+x + ' ' + s.getAbsolutePath() + '\n');
                getListFiles(s.getAbsolutePath(), fileWriter, n+1);
            }
            if (Main.iteration == 5) {
                fileWriter.flush();
            }
        }
    }

    private static StringBuilder repeat(char symbol, int n) {
        StringBuilder str = new StringBuilder();
        for (int i=0; i<n;i++) {
            str.append(symbol);
        }
        return str;
    }

}
