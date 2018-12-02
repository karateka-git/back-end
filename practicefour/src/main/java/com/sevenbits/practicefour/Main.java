package com.sevenbits.practicefour;

import com.sevenbits.practicefour.Storage.IUniqueStorage;
import com.sevenbits.practicefour.Storage.UniqueStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    final static Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(final String[] args) {
        IUniqueStorage storage = new UniqueStorage();
        storage.add(new Planet("planet2"));
        storage.add(new Planet("planet5"));
        for (int i = 1; i <= 7; i++) {
            storage.add(new Planet("planet" + i));
        }
        storage.remove(new Planet("planet2"));
        storage.remove(new Planet("planet3"));

    }
}
