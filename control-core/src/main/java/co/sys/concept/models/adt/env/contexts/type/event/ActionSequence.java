package co.sys.concept.models.adt.env.contexts.type.event;

import co.sys.concept.models.adt.env.space.Sequence;

import java.util.LinkedHashMap;

public abstract class ActionSequence<Event, EventCompound> implements Sequence<Event, EventCompound> {

    private LinkedHashMap<Event, EventCompound> events;

    public ActionSequence(LinkedHashMap<Event, EventCompound> events) {
        this.events = events;
    }

    public ActionSequence() {
        this.events = new LinkedHashMap<>();
    }

    public ActionSequence(Event event) {
        set(event);
    }

    @Override
    public LinkedHashMap<Event, EventCompound> get() {
        return events;
    }

    @Override
    public ActionSequence<Event, EventCompound> set(LinkedHashMap<Event, EventCompound> events) {
        this.events = events;
        return this;
    }

    @Override
    public ActionSequence<Event, EventCompound> set(Event event) {
        this.events = new LinkedHashMap<>();
        this.events.put(event, null);
        return this;
    }

    @Override
    public EventCompound get(Event Event){
        return events.get(Event);
    }
}
