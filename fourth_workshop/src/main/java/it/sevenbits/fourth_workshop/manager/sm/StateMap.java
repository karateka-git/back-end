package it.sevenbits.fourth_workshop.manager.sm;

import java.util.HashMap;
import java.util.Map;

class StateMap {
    private final State defaultState = new State("IGNORE");

    private final Map<Pair<State, String>, State> states;

    StateMap() {
        states = new HashMap<>();
        State listenState = new State("LISTEN");
        State stubSuspicion = new State("TRASH_SUSPICION");

        states.put(new Pair<>(defaultState, "MESSAGE"), listenState);
        states.put(new Pair<>(defaultState, "TRASH"), defaultState);

        states.put(new Pair<>(listenState, "MESSAGE"), listenState);
        states.put(new Pair<>(listenState, "TRASH"), stubSuspicion);

        states.put(new Pair<>(stubSuspicion, "MESSAGE"), stubSuspicion);
        states.put(new Pair<>(stubSuspicion, "TRASH"), defaultState);
    }

    public State getStartState() {
        return defaultState;
    }

    public State getNextState(final State state, final String signal) {
        return states.getOrDefault(new Pair<>(state, signal), defaultState);
    }
}
