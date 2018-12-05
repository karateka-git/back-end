package it.sevenbits.fourth_workshop.manager;

import it.sevenbits.fourth_workshop.network.INetwork;

public interface INetworkManager {

    void listen(INetwork network) throws NetworkManagerException;

    void stop();
}
