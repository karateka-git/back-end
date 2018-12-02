package com.sevenbits.practicefour.Storage;

import com.sevenbits.practicefour.Planet;

public interface IUniqueStorage {
    void add(Planet planet);
    void remove(Planet planet);
    boolean contains(Planet planet);
}
