package it.sevenbits.fourth_workshop;

import it.sevenbits.fourth_workshop.manager.INetworkManager;
import it.sevenbits.fourth_workshop.manager.SimpleNetworkManager;
import it.sevenbits.fourth_workshop.manager.sm.StateMachineNetworkManager;
import it.sevenbits.fourth_workshop.network.INetwork;
import it.sevenbits.fourth_workshop.network.Network;

public class Main {


    public static void main(String[] args) throws Exception {
//        final INetworkManager nm = new SimpleNetworkManager();
        final INetworkManager nm = new StateMachineNetworkManager();
        final INetwork network = new Network(500);

        PackagesGenerator packagesGenerator = new PackagesGenerator();
//        Thread createMessagesThread = packagesGenerator.packagesFillerTaskOne(nm, network);
        
        //TODO task2
        Thread createMessagesThread = packagesGenerator.packagesFillerTaskTwo(nm, network);


        createMessagesThread.start();
        nm.listen(network);
    }
}
