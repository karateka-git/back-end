package com.sevenbits;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class ExampleTest {
    private FileReader fileReader;
    private Example example;
    @Before
    public void setUp() {
        fileReader = mock(FileReader.class);
        example = new Example();
    }

    @Test
    public void testZeroLinesInFile() {
        when(fileReader.hasMoreLines()).thenReturn(false);
        int trueCurrent = 0;
        try {
            int current = example.getLongestLineCharsCount(fileReader);
            Assert.assertEquals(trueCurrent, current);
        } catch (IOException e) {
            fail("IOException: " + e.getMessage());
        }
    }

    @Test
    public void testReturnLineValidity() {
        when(fileReader.hasMoreLines()).thenReturn(true).thenReturn(false);;
        int trueCurrent = 36;
        try {
            when(fileReader.readString()).thenReturn("there are 36 characters in this line");
        } catch (IOException e) {
            fail("IOException: " + e.getMessage());
        }
        try {
            int current = example.getLongestLineCharsCount(fileReader);
            Assert.assertEquals(trueCurrent, current);
        } catch (IOException e) {
            fail("IOException: " + e.getMessage());
        }

    }
}
