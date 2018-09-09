package co.sys.concept.models.adt.env.contexts.type.state;

import co.sys.concept.models.adt.env.space.Sequence;

import java.util.LinkedHashMap;

public abstract class StateSequence<State, StateCompound> implements Sequence<State, StateCompound> {

    private LinkedHashMap<State, StateCompound> states;

    public StateSequence(LinkedHashMap<State, StateCompound> states) {
        this.states = states;
    }

    public StateSequence() {
        this.states = new LinkedHashMap<>();
    }

    public StateSequence(State state) {
        set(state);
    }

    @Override
    public LinkedHashMap<State, StateCompound> get() {
        return states;
    }

    @Override
    public StateSequence<State, StateCompound> set(LinkedHashMap<State, StateCompound> states) {
        this.states = states;
        return this;
    }

    @Override
    public StateSequence<State, StateCompound> set(State state) {
        this.states = new LinkedHashMap<>();
        this.states.put(state, null);
        return this;
    }

    @Override
    public StateCompound get(State State){
        return states.get(State);
    }
}