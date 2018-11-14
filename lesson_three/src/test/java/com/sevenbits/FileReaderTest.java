package com.sevenbits;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

public class FileReaderTest {
    private FileReader fileReader;
    @Before
    public void setUp() {
        String fileNameReadable = "Homework3.txt";
        String fileSeparator = File.separator;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("src").append(fileSeparator).append("main").append(fileSeparator)
                .append("resources").append(fileSeparator).append("files");

        File dir = new File(String.valueOf(stringBuilder));
        File file = new File(dir, fileNameReadable);
        try {
            fileReader = new FileReader(file);
        } catch (IOException e) {
            fail("IOException");
        }
    }

    @Test
    public void testCorrecthasMoreLines() {
        boolean trueCurrent = true;
        boolean current = fileReader.hasMoreLines();
        Assert.assertEquals(trueCurrent, current);
    }
}
