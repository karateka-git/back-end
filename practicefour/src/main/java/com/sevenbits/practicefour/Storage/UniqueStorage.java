package com.sevenbits.practicefour.Storage;

import com.sevenbits.practicefour.Planet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.HashSet;
import java.util.Iterator;

public class UniqueStorage implements IUniqueStorage {
    private HashSet<Planet> hashSet = new HashSet<Planet>();
    static final Logger logger = LoggerFactory.getLogger(UniqueStorage.class);

    @Override
    public void add(final Planet planet) {
        if (contains(planet)) {
            logger.warn("The container already contains this planet.");
        } else {
            hashSet.add(planet);
            logger.info("Add planet: name - " + planet.getName() + " id - " + planet.getId());
        }
    }

    @Override
    public void remove(final Planet planet) {
        hashSet.remove(planet);
        logger.info("Remove planet: name - " + planet.getName() + " id - " + planet.getId());
    }

    @Override
    public boolean contains(final Planet planet) {
        for (Planet planetCurrent : hashSet) {
            if (planetCurrent.getName().equals(planet.getName())) {
                return true;
            }
        }
        return false;
    }
}
