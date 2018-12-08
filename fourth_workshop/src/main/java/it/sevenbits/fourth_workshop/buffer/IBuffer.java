package it.sevenbits.fourth_workshop.buffer;

import it.sevenbits.fourth_workshop.network.NetworkPackage;

public interface IBuffer {
    void add(NetworkPackage p);
    void clear();
    void outputBuffer();
}
