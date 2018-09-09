package co.sys.concept.models.adt.env.actions.type.mixin;

import co.sys.concept.models.agent.Agent;
import co.sys.concept.models.adt.entities.Sum;
import co.sys.concept.models.adt.env.contexts.ContextCompound;
import co.sys.concept.models.adt.env.contexts.type.event.Action;

import java.util.Optional;

public abstract class Do extends Action {

    private ContextCompound context;
    private Agent agent;

    @Override
    public Sum getMapOrSum() {
        return context.getMapOrSum();
    }

    @Override
    public Optional getAtomicAction() {
        return context.getAtomicAction();
    }

    @Override
    public Optional getAtomicState() {
        return context.getAtomicState();
    }

    abstract void work();
}
