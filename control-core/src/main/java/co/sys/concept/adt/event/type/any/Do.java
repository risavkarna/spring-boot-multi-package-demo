package co.sys.concept.adt.event.type.any;

import co.sys.agent.Agent;
import co.sys.concept.env.Sum;
import co.sys.concept.adt.context.ContextCompound;
import co.sys.concept.adt.context.type.event.Event;

import java.util.Optional;

public abstract class Do extends Event{

    private ContextCompound context;
    private Agent agent;

    @Override
    public Sum getMapOrSum() {
        return context.getMapOrSum();
    }

    @Override
    public Optional getAtomicEvent() {
        return context.getAtomicEvent();
    }

    @Override
    public Optional getAtomicState() {
        return context.getAtomicState();
    }

    abstract void work();
}
