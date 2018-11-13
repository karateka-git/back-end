package com.sevenbits;

import java.io.IOException;

public class Example {
    public void Example(){}
    public int getLongestLineCharsCount(final FileReader fileReader) throws IOException {
        String line;
        int maxSymbolLine = 0;
        while (fileReader.hasMoreLines()) {
            line = fileReader.readLine();
            if (maxSymbolLine < line.length()) {
                maxSymbolLine = line.length();
            }
        }
        return maxSymbolLine;
    }
}
