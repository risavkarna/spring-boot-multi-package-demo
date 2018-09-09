package co.sys.concept.patterns.models.adt.entities;

import co.sys.concept.Concept;

public class Transaction<B>  extends Control implements  Concept.Atom<Transaction>{

    private Attributes attributes;

    private Relationships relationships;

    public Transaction(Attributes attributes, Relationships relationships) {
        this.attributes = attributes != null ? attributes : new Attributes();
        this.relationships = relationships != null ? relationships : new Relationships();
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public Object get(String key) {
        return attributes.getAll().containsKey(key) ? attributes.get(key) : relationships.getAll().get(key);
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

    @Override
    public Transaction<B> value() {
        return this;
    }

    @Override
    public String identifiedBy() {
        return String.valueOf(attributes.get("id"));
    }


}
