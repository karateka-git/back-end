package it.sevenbits.fourth_workshop.manager.command;

import it.sevenbits.fourth_workshop.Container;
import it.sevenbits.fourth_workshop.buffer.IBuffer;
import it.sevenbits.fourth_workshop.buffer.StringBuilderBuffer;
import it.sevenbits.fourth_workshop.network.NetworkPackage;

public class Add implements INetworkManagerCommand {
    private IBuffer buffer;
    private NetworkPackage p;
    private Container container;

    Add(final Container container) {
        this.container = container;
        this.buffer = container.getBuffer();
    }
    @Override
    public void execute() {
        this.p = container.getPackage();
        buffer.add(p);
    }
}
