package it.sevenbits.fourth_workshop;

import it.sevenbits.fourth_workshop.buffer.IBuffer;
import it.sevenbits.fourth_workshop.manager.sm.State;
import it.sevenbits.fourth_workshop.network.NetworkPackage;

public class Container {
    private State currentState;
    private NetworkPackage p;
    private IBuffer buffer;

    public IBuffer getBuffer() {
        return buffer;
    }

    public void setBuffer(final IBuffer buffer) {
        this.buffer = buffer;
    }

    public State getCurrentState() {
        return currentState;
    }

    public NetworkPackage getPackage() {
        return p;
    }

    public void setState(final State state) {
        currentState = state;
    }

    public void setPackage(final NetworkPackage p) {
        this.p = p;
    }

}
