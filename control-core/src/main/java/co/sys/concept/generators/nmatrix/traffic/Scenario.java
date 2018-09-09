package co.sys.concept.generators.nmatrix.traffic;

import co.sys.concept.patterns.things.adt.entities.env.actions.Action;
import co.sys.concept.patterns.things.agent.Agent;
import co.sys.concept.patterns.things.adt.entities.Attributes;
import co.sys.concept.patterns.things.adt.entities.Relationships;

public class Scenario extends Agent {

	private Action action;

	private Attributes attributes;

	private Relationships relationships;


	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
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
