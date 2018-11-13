package com.sevenbits;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileReader {
    private BufferedReader bufferedReader;
    private int numberLine = 0;
    private File file;
    public FileReader(final File fileName) throws FileNotFoundException {
        this.file = fileName;
        InputStream fileStream = new FileInputStream(file);
        Reader fileReader = new InputStreamReader(fileStream, StandardCharsets.UTF_8);
        this.bufferedReader = new BufferedReader(fileReader);
    }

    public String readLine() throws IOException {
        String line;
        line = this.bufferedReader.readLine();
        this.numberLine += 1;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.file.getName()).append(" line ").append(numberLine)
                .append(": ").append(line);
        return String.valueOf(stringBuilder);
    }

    public boolean hasMoreLines() {
        try {
            this.bufferedReader.mark(10); // я что-то не совсем понял как это работает.
            if (this.bufferedReader.readLine() != null) {
                this.bufferedReader.reset();
            } else {
                closeFile();
                return false;
            }
        } catch (IOException e) {
            e.getMessage();
        }
        return true;
    }

    public void closeFile() {
        try {
            this.bufferedReader.close();
        } catch (IOException e) {
            e.getMessage();
        }

    }

}
