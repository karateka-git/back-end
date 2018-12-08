package it.sevenbits.fourth_workshop.buffer;

import it.sevenbits.fourth_workshop.network.NetworkPackage;

public class StringBuilderBuffer implements IBuffer {
    private StringBuilder buffer = new StringBuilder();

    @Override
    public void add(final NetworkPackage p) {
        buffer.append(p.getMessage());
    }

    @Override
    public void clear() {
        buffer.setLength(0);
    }

    @Override
    public void outputBuffer() {
        System.out.println(buffer.toString() + '\n');
    }
}
