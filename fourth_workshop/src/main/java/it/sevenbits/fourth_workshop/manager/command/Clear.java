package it.sevenbits.fourth_workshop.manager.command;

import it.sevenbits.fourth_workshop.Container;
import it.sevenbits.fourth_workshop.buffer.IBuffer;

public class Clear implements INetworkManagerCommand {
    private IBuffer buffer;

    Clear(final Container container) {
        this.buffer = container.getBuffer();
    }

    @Override
    public void execute() {
        buffer.clear();
    }
}
