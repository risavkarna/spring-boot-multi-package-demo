package co.sys.generators.bna.meta;

import co.sys.concept.Concept;

import java.util.HashMap;
import java.util.Map;

public class Relationship<C> {

    private Map<String, C> others;

    public Relationship(Map<String, C> others) {
        this.others = others;
    }

    public Relationship() {
        this.others = new HashMap<>();
    }

    public Map<String, C> getOthers() {
        return others;
    }

    public void setOthers(Map<String, C> others) {
        this.others = others;
    }

    public Relationship add(Concept.Atom<? extends C> item) {
        if (!others.keySet().contains(item.value().getClass().getTypeName())) {
            others.put(item.value().getClass().getTypeName(), item.value());
        }
        return this;
    }

    public Relationship remove(Concept.Atom<? extends C> item) {
        others.remove(item.value().getClass().getTypeName());
        return this;
    }
}
