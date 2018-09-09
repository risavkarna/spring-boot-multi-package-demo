package co.sys.concept.patterns.models.adt.entities;

import co.sys.concept.Concept;

import java.util.HashMap;
import java.util.Map;

public class Attributes extends Concept.Component<Attributes>{

    public Attributes(Map<String, Object> all) {
        this.setAll(all);
    }

    public Attributes() {
        this.setAll(new HashMap<>());
    }

    public Attributes add(Object item) {
        return add(item.getClass().getTypeName(), item);
    }

    public Attributes update(String key, Object item) {
        put(key, item);
        return this;
    }

    public Object get(String item) {
        return this.getAll().get(item);
    }

    public Attributes add(String key, Object item) {
        if (!this.getAll().containsKey(key)) {
            return update(key, item);
        }
        return this;
    }

    public Attributes remove(Object item) {
        this.getAll().remove(item.getClass().getTypeName());
        return this;
    }

    public Attributes remove(String key) {
        this.getAll().remove(key);
        return this;
    }

    public Attributes add(Concept.Atom<?> item) {
        if (!this.getAll().containsKey(key(item.value().getClass().getTypeName()))) {
            put(key(item.value().getClass().getTypeName()), item.value());
        }
        return this;
    }

    public Attributes remove(Concept.Atom<?> item) {
        this.getAll().remove(item.value().getClass().getTypeName());
        return this;
    }

}
