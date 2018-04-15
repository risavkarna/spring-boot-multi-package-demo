package co.sys.agent;

import co.sys.concept.adt.context.ContextCompound;
import co.sys.concept.env.Sum;

import java.util.Map;
import java.util.Optional;

public abstract class AgentCompound<AgentControl, AgentCapability> extends ContextCompound<AgentControl, AgentCapability>{

    private Sum<Map<? extends AgentControl, ? extends AgentCapability>,
            Sum<? extends AgentControl, ? extends AgentCapability>> agency;

    public AgentCompound(Sum<
            Map<? extends AgentControl, ? extends AgentCapability>,
            Sum<? extends AgentControl, ? extends AgentCapability>
            > agency) {
        this.agency = agency;
    }

    public Optional<? super Map<? extends AgentControl, ? extends AgentCapability>> getAgencyMap() {
        return agency.fromLeft();
    }

    public Optional<? super AgentControl> getControl() {
        return agency.isRight() ? agency.fromRight().map(Sum::fromLeft) : Optional.empty();
    }

    public Optional<? super AgentCapability> getCapability() {
        return agency.isRight() ? agency.fromRight().map(Sum::fromRight) : Optional.empty();
    }
}
