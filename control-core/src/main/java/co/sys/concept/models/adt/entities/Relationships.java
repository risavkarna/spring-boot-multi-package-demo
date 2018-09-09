package co.sys.concept.models.adt.entities;

import co.sys.concept.Concept;

import java.util.HashMap;
import java.util.Map;

public class Relationships extends Concept.Component<Relationships>{

    public Relationships(Map<String, Object> all) {
        this.setAll(all);
    }

    public Relationships() {
        this.setAll(new HashMap<>());
    }

    public Relationships add(Concept.Atom<?> item) {
        if (!this.getAll().containsKey(key(item.value().getClass().getTypeName()))) {
            put(key(item.value().getClass().getTypeName()), item.value());
        }
        return this;
    }

    public Relationships remove(Concept.Atom<?> item) {
        this.getAll().remove(item.value().getClass().getTypeName());
        return this;
    }
}
