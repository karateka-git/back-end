package it.sevenbits.fourth_workshop.manager.command;

import it.sevenbits.fourth_workshop.Container;
import it.sevenbits.fourth_workshop.buffer.IBuffer;
import it.sevenbits.fourth_workshop.buffer.StringBuilderBuffer;
import it.sevenbits.fourth_workshop.manager.sm.Pair;
import it.sevenbits.fourth_workshop.manager.sm.State;
import it.sevenbits.fourth_workshop.network.NetworkPackage;

import java.util.HashMap;
import java.util.Map;

public class CommandClient {
    private final Map<Pair<String, String>, INetworkManagerCommand> states;
    private final Container container;

    public CommandClient(final Container container) {
        this.container = container;
        states = new HashMap<>();
//        states.put(new Pair<>("LISTEN", "MESSAGE"), new Add(this.container));
////        states.put(new Pair<>("LISTEN", "TRASH"), null);
//
//        states.put(new Pair<>("IGNORE", "MESSAGE"), new Add(this.container));
////        states.put(new Pair<>("IGNORE", "TRASH"), null);
//
//        states.put(new Pair<>("TRASH_SUSPICION", "MESSAGE"), new Add(this.container));
//        states.put(new Pair<>("TRASH_SUSPICION", "TRASH"), new Clear(this.container));

        //TODO task2
        states.put(new Pair<>("IGNORE", "MESSAGE_START"), new Add(this.container));

        states.put(new Pair<>("LISTEN", "MESSAGE"), new Add(this.container));
        states.put(new Pair<>("LISTEN", "MESSAGE_FINISH"), new Output(this.container));

        states.put(new Pair<>("TRASH_SUSPICION", "MESSAGE"), new Add(this.container));
        states.put(new Pair<>("TRASH_SUSPICION", "TRASH"), new Clear(this.container));
        states.put(new Pair<>("TRASH_SUSPICION", "MESSAGE_FINISH"), new Output(this.container));
    }
    public void runningCommand() {
        CommandInvoker commandInvoker = new CommandInvoker();
        commandInvoker.submit(states.get(new Pair<>(container.getCurrentState().toString(),
                container.getPackage().getType())));
//        commandInvoker.submit(states.get(new Pair<>(currentState.toString(), p.getType())));
    }
}
