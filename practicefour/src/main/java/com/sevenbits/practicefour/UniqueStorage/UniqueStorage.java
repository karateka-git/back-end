package com.sevenbits.practicefour.UniqueStorage;

import com.sevenbits.practicefour.Planet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class UniqueStorage implements IUniqueStorage {
    private Set<Planet> hashSet = new HashSet<>();
    static final Logger logger = LoggerFactory.getLogger(UniqueStorage.class);

    @Override
    public void add(final Planet planet) {
        try {
            if (contains(planet)) {
                throw new IndexOutOfBoundsException("The container already contains this planet.");
            } else {
                hashSet.add(planet);
                logger.info("Add planet: name - " + planet.getName() + " id - " + planet.getId());
            }
        } catch (IndexOutOfBoundsException e) {
            logger.warn(e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void remove(final Planet planet) {
        try {
            if (!contains(planet)) {
                throw new IndexOutOfBoundsException("The container does not contains this planet.");
            } else {
                Iterator<Planet> iterator = hashSet.iterator();
                while (iterator.hasNext()) {
                    Planet planetCurrent = iterator.next();
                    if (planetCurrent.getName().equals(planet.getName())) {
                        logger.info("Remove planet: name - " + planetCurrent.getName() + " id - " + planetCurrent.getId());
                        iterator.remove();
                        break;
                    }
                }
            }
        } catch (IndexOutOfBoundsException e) {
            logger.warn(e.getMessage());
            System.out.println(e.getMessage());
        }
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
