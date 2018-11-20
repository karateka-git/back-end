package it.sevenbits.workshop;

import it.sevenbits.workshop.input.BufferedByteWriter;
import it.sevenbits.workshop.output.BufferedByteReader;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {
    public static void main(final String[] args) throws Exception{
        try (
            BufferedByteWriter writer = new BufferedByteWriter(new FileOutputStream("out.txt"));
            BufferedByteReader reader = new BufferedByteReader(new FileInputStream("in.txt"))
        ){
            while (reader.hasNext()) {
                writer.write(reader.read());
            }
        }
    }
}
