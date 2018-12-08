package it.sevenbits.fourth_workshop.network;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentLinkedDeque;

public class Network implements INetwork {
    private final int maxSize;
    private ConcurrentLinkedDeque<NetworkPackage> packages = new ConcurrentLinkedDeque<NetworkPackage>();
    final static Logger logger = LoggerFactory.getLogger(Network.class);

    public Network(final int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public boolean hasPackage() {
       return packages.size() > 0;
    }

    @Override
    public NetworkPackage getPackage() {
        logger.debug("Package get");  // TODO: Add debug log
        return packages.removeFirst();
    }

    @Override
    public void addPackage(final String message, final String type) {
        if (packages.size() < maxSize) {
            logger.debug("Package add");  // TODO: Add debug log
            packages.addLast(new NetworkPackage(type, message));
        }
        logger.error("error, size package > maxSize");  // TODO: Add error log
    }
}
