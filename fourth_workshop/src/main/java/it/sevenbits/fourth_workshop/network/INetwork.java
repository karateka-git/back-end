package it.sevenbits.fourth_workshop.network;

public interface INetwork {

    boolean hasPackage();

    NetworkPackage getPackage();

    void addPackage(String message, String type);
}
