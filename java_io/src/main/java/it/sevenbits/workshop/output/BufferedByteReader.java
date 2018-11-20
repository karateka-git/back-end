package it.sevenbits.workshop.output;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BufferedByteReader implements ByteReader, AutoCloseable {
    private BufferedInputStream inputStream;

    public BufferedByteReader(InputStream in) {
        this.inputStream = new BufferedInputStream(in);
    }

    @Override
    public void close() throws IOException {
        inputStream.close();
    }

    @Override
    public int read() throws IOException {
        return inputStream.read();
    }

    @Override
    public boolean hasNext() throws IOException {
        return inputStream.available() > 0;
    }
}
