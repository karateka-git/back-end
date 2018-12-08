package it.sevenbits.fourth_workshop.manager.sm;

import it.sevenbits.fourth_workshop.Container;
import it.sevenbits.fourth_workshop.buffer.IBuffer;
import it.sevenbits.fourth_workshop.buffer.StringBuilderBuffer;
import it.sevenbits.fourth_workshop.log.MessageFormatter;
import it.sevenbits.fourth_workshop.manager.INetworkManager;
import it.sevenbits.fourth_workshop.manager.NetworkManagerException;
import it.sevenbits.fourth_workshop.manager.command.CommandClient;
import it.sevenbits.fourth_workshop.network.INetwork;
import it.sevenbits.fourth_workshop.network.NetworkPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StateMachineNetworkManager implements INetworkManager {

    private boolean isInterrupted = false;
    private final long TIMEOUT = 500;
    private final StateTransition stateTransition;
    final static Logger logger = LoggerFactory.getLogger(StateMachineNetworkManager.class);

    public StateMachineNetworkManager() {
        this.stateTransition = new StateTransition();
    }

    @Override
    public void listen(final INetwork network) throws NetworkManagerException {
        Container container = new Container();
        State currentState = stateTransition.getStartState();
        IBuffer buffer = new StringBuilderBuffer();
        container.setBuffer(buffer);
        CommandClient commandClient = new CommandClient(container);
        MessageFormatter messageFormatter = new MessageFormatter();
        try {
            while (!isInterrupted) {
                while (network.hasPackage()) {
                    NetworkPackage p = network.getPackage();
                    System.out.println(String.format("%1$s: %2$s", p.getType(), currentState.toString()));
                    container.setState(currentState);
                    container.setPackage(p);
                    commandClient.runningCommand();  //TODO: Add cmd
                    logger.info(messageFormatter.getStringFormatByType(p.getType()));  //TODO: Add packages logging (use MessageFormatter)
                    currentState = stateTransition.nextState(currentState, p);
                }

                Thread.sleep(TIMEOUT);
            }
        } catch (InterruptedException e) {
            logger.error("Network manager was interrupted unexpectedly");  // TODO:: Add error log
            throw new NetworkManagerException("Network manager was interrupted unexpectedly", e);
        }
    }

    @Override
    public void stop() {
        logger.info("Stop");  // TODO:: Add log
        isInterrupted = true;
    }
}
