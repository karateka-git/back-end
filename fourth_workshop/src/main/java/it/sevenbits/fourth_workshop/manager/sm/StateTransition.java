package it.sevenbits.fourth_workshop.manager.sm;

import it.sevenbits.fourth_workshop.network.NetworkPackage;

public final class StateTransition {

    private final StateMap stateMap;

    public StateTransition() {
        this.stateMap = new StateMap();
    }

    public State nextState(final State state, final NetworkPackage p) {
        return stateMap.getNextState(state, p.getType());
    }

    public State getStartState() {
        return this.stateMap.getStartState();
    }
}
