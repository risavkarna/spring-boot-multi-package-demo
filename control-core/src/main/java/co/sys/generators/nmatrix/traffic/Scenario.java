package co.sys.generators.nmatrix.traffic;

import co.sys.agent.Agent;
import co.sys.concept.adt.event.Event;
import co.sys.concept.env.Attributes;
import co.sys.concept.env.Relationships;

public class Scenario extends Agent {

	private Event event;

	private Attributes attributes;

	private Relationships relationships;


	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Attributes getAttributes() {
		return attributes;
	}

	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}

	public Relationships getRelationships() {
		return relationships;
	}

	public void setRelationships(Relationships relationships) {
		this.relationships = relationships;
	}
}
