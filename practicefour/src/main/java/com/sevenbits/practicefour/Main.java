package com.sevenbits.practicefour;

import com.sevenbits.practicefour.FixedStorage.FixedStorage;
import com.sevenbits.practicefour.FixedStorage.IFixedStorage;
import com.sevenbits.practicefour.UniqueStorage.IUniqueStorage;
import com.sevenbits.practicefour.UniqueStorage.UniqueStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    final static Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(final String[] args) {
        final int SIZE = 7;
        IUniqueStorage uniqueStorage = new UniqueStorage();
        IFixedStorage fixedStorage = new FixedStorage(SIZE);
        List<Planet> listPlanet = new ArrayList<>();
        for (int i = 1; i <= SIZE; i++) {
            listPlanet.add(new Planet("planet" + i));
            fixedStorage.add(listPlanet.get(i - 1).getId(), listPlanet.get(i - 1));
            uniqueStorage.add(listPlanet.get(i - 1));
        }
        int i = 1;
        while (i <= SIZE && uniqueStorage.contains(fixedStorage.get(listPlanet.get(i - 1).getId()))) {
            i++;
        }
        if (SIZE == i) {
            System.out.println("uniqueStorage contains 7/7 elements fixedStorage");
        }
    }
}
