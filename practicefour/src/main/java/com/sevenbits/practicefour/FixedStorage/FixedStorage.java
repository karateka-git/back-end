package com.sevenbits.practicefour.FixedStorage;

import com.sevenbits.practicefour.Planet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FixedStorage implements IFixedStorage {

    static final Logger logger = LoggerFactory.getLogger(FixedStorage.class);
    private Map<String, Planet> map;
    private int mapSize;

    public FixedStorage(int size) {
        mapSize = size;
        map = new HashMap<>(size);
    }
    @Override
    public void add(final String key, final Planet planet) {
        try {
            if (map.size() == mapSize) {
                logger.warn("Collection is full, lost planet: name - " + planet.getName() + " id - " + key);
            } else if (contains(planet)) {
                map.replace(key, planet);
                throw new IndexOutOfBoundsException("The container already contains this planet.");
            } else {
                map.put(key, planet);
                logger.info("Add planet: name - " + planet.getName() + " id - " + key);
            }
        } catch (IndexOutOfBoundsException e) {
            logger.warn(e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void remove(final String key) {
        try {
            if (!map.containsKey(key)) {
                throw new IndexOutOfBoundsException("The container does not contains this key.");
            } else {
                logger.info("Remove planet: name - " + map.get(key).getName() + " id - " + key);
                map.remove(key);
            }
        } catch (IndexOutOfBoundsException e) {
            logger.warn(e.getMessage());
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Planet get(final String key) {
        try {
            if (!map.containsKey(key)) {
                throw new IndexOutOfBoundsException("The container does not contains this key.");
            } else {
                Planet planet = map.get(key);
                logger.info("Get planet: name - " + planet.getName() + " id - " + key);
                return planet;
            }
        } catch (IndexOutOfBoundsException e) {
            logger.warn(e.getMessage());
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean contains(final Planet planet) {
        for (Map.Entry<String, Planet> planetCurrent : map.entrySet()) {
            if (planetCurrent.getValue().getName().equals(planet.getName())) {
                return true;
            }
        }
        return false;
    }
}
