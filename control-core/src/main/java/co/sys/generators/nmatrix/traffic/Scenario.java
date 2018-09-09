package co.sys.generators.nmatrix.traffic;

import co.sys.concept.models.adt.env.actions.Action;
import co.sys.concept.models.agent.Agent;
import co.sys.concept.models.adt.entities.Attributes;
import co.sys.concept.models.adt.entities.Relationships;

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
