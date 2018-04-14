package co.sys.agent;

import co.sys.concept.i.Sequence;

import java.util.LinkedHashMap;

public abstract class AgentSequence<Agent, AgentCompound> implements Sequence<Agent, AgentCompound> {

    private LinkedHashMap<Agent, AgentCompound> agents;

    public AgentSequence(LinkedHashMap<Agent, AgentCompound> agents) {
        this.agents = agents;
    }

    public AgentSequence() {
        this.agents = new LinkedHashMap<>();
    }

    public AgentSequence(Agent agent) {
        set(agent);
    }

    @Override
    public LinkedHashMap<Agent, AgentCompound> get() {
        return agents;
    }

    @Override
    public AgentSequence<Agent, AgentCompound> set(LinkedHashMap<Agent, AgentCompound> agents) {
        this.agents = agents;
        return this;
    }

    @Override
    public AgentSequence<Agent, AgentCompound> set(Agent agent) {
        this.agents = new LinkedHashMap<>();
        this.agents.put(agent, null);
        return this;
    }

    @Override
    public AgentCompound get(Agent agent){
        return agents.get(agent);
    }
}
