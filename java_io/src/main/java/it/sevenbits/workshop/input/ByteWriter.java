package it.sevenbits.workshop.input;

import java.io.IOException;

public interface ByteWriter {
    void write(int b) throws IOException;
}
