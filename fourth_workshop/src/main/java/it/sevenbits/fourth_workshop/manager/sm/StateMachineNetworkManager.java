package it.sevenbits.fourth_workshop.manager.sm;

import it.sevenbits.fourth_workshop.manager.INetworkManager;
import it.sevenbits.fourth_workshop.manager.NetworkManagerException;
import it.sevenbits.fourth_workshop.network.INetwork;
import it.sevenbits.fourth_workshop.network.NetworkPackage;

public class StateMachineNetworkManager implements INetworkManager {

    private boolean isInterrupted = false;
    private final long TIMEOUT = 500;
    private final StateTransition stateTransition;

    public StateMachineNetworkManager() {
        this.stateTransition = new StateTransition();
    }

    @Override
    public void listen(INetwork network) throws NetworkManagerException {
        State currentState = stateTransition.getStartState();
        try {
            while(!isInterrupted){
                while(network.hasPackage()){
                    NetworkPackage p = network.getPackage();
                    //TODO: add cmd
                    //TODO: add packages logging (use MessageFormatter)
                    currentState = stateTransition.nextState(currentState, p);
                    System.out.println(String.format("%1$s: %2$s", p.getType(), currentState.toString()));

                }

                Thread.sleep(TIMEOUT);
            }
        } catch (InterruptedException e){
            // TODO:: add error log
            throw new NetworkManagerException("Network manager was interrupted unexpectedly", e);
        }
    }

    @Override
    public void stop() {
        // TODO:: add log
        isInterrupted = true;
    }
}
