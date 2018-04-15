package co.sys.concept.env;

import co.sys.concept.Concept;

import java.util.HashMap;
import java.util.Map;

public class Relationships {

    private Map<String, Object> all;

    public Relationships(Map<String, Object> all) {
        this.all = all;
    }

    public Relationships() {
        this.all = new HashMap<>();
    }

    public Map<String, Object> getAll() {
        return all;
    }

    public void setAll(Map<String, Object> all) {
        this.all = all;
    }

    public Relationships add(Concept.Atom<?> item) {
        if (!all.containsKey(item.value().getClass().getTypeName())) {
            all.put(item.value().getClass().getTypeName(), item.value());
        }
        return this;
    }

    public Relationships remove(Concept.Atom<?> item) {
        all.remove(item.value().getClass().getTypeName());
        return this;
    }
}
