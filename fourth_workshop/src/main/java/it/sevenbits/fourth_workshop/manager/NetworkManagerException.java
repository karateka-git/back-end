package it.sevenbits.fourth_workshop.manager;

public class NetworkManagerException extends Exception {

    public NetworkManagerException(String message, Throwable cause) {
        super(message, cause);
    }

    public NetworkManagerException(String message) {
        super(message);
    }
}
