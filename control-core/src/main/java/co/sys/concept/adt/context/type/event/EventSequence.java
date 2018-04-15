package co.sys.concept.adt.context.type.event;

import co.sys.concept.env.space.Sequence;

import java.util.LinkedHashMap;

public abstract class EventSequence<Event, EventCompound> implements Sequence<Event, EventCompound> {

    private LinkedHashMap<Event, EventCompound> events;

    public EventSequence(LinkedHashMap<Event, EventCompound> events) {
        this.events = events;
    }

    public EventSequence() {
        this.events = new LinkedHashMap<>();
    }

    public EventSequence(Event event) {
        set(event);
    }

    @Override
    public LinkedHashMap<Event, EventCompound> get() {
        return events;
    }

    @Override
    public EventSequence<Event, EventCompound> set(LinkedHashMap<Event, EventCompound> events) {
        this.events = events;
        return this;
    }

    @Override
    public EventSequence<Event, EventCompound> set(Event event) {
        this.events = new LinkedHashMap<>();
        this.events.put(event, null);
        return this;
    }

    @Override
    public EventCompound get(Event Event){
        return events.get(Event);
    }
}
