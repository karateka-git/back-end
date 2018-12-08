package it.sevenbits.fourth_workshop.manager.command;

public class CommandInvoker {
    public void submit(final INetworkManagerCommand command) {
        if (command != null) {
            command.execute();
        }
    }
}
