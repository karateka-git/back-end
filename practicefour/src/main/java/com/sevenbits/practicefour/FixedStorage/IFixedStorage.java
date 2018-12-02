package com.sevenbits.practicefour.FixedStorage;

import com.sevenbits.practicefour.Planet;

public interface IFixedStorage {
    void add(String key, Planet planet);
    void remove(String key);
    Planet get(String key);
    boolean contains(Planet planet);
}
