package it.sevenbits.workshop.input;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class BufferedByteWriter implements ByteWriter, AutoCloseable {
    private BufferedOutputStream outputStream;

    public BufferedByteWriter(final OutputStream out) {
        outputStream = new BufferedOutputStream(out);
    }

    @Override
    public void write(int b) throws IOException {
        outputStream.write(b);
    }

    @Override
    public void close() throws Exception {
        outputStream.close();
    }
}
