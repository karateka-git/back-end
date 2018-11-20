package it.sevenbits.workshop.output;

import java.io.IOException;

public interface ByteReader {
    int read() throws IOException;
    boolean hasNext() throws IOException ;
}
