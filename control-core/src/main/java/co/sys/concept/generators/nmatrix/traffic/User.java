package co.sys.concept.generators.nmatrix.traffic;

import co.sys.concept.patterns.things.agent.Agent;
import co.sys.concept.patterns.things.adt.entities.Attributes;
import co.sys.concept.patterns.things.adt.entities.Relationships;

public class User extends Agent {

	private String id;

	private Attributes attributes;

	private Relationships relationships;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
