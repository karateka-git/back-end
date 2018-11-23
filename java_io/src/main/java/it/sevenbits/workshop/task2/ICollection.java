package it.sevenbits.workshop.task2;

import java.io.IOException;

public interface ICollection {
    void add(User user) throws IOException;
    User get(long index) throws IOException;
}
