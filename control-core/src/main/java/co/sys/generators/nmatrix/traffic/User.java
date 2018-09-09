package co.sys.generators.nmatrix.traffic;

import co.sys.concept.models.agent.Agent;
import co.sys.concept.models.adt.entities.Attributes;
import co.sys.concept.models.adt.entities.Relationships;

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
