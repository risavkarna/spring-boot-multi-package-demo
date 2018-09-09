package co.sys.concept;

import co.sys.concept.patterns.models.adt.entities.env.contexts.Context;
import co.sys.concept.patterns.models.adt.entities.Sum;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Concept {

    private Map<Concept, Map<Context, Concept>> concept;

    public static abstract class Component<A>{
        private Map<String, Object> all;

        public static final String SPRTR = "__";

        public Component setAll(Map<String, Object> all){
            this.all = all;
            return this;
        }

        public Map<String, Object> getAll() {
            return all;
        }

        public void put(String name, Object object) {
             this.getAll().put(key(name, object), object);
        }

        public void put(Object object) {
            this.getAll().put(key(object), object);
        }

        public String key(Object object) {
            return object.getClass().getTypeName() + SPRTR + object.getClass().getTypeName();
        }

        public String key(String name, Object object) {
            return object.getClass().getTypeName() + SPRTR + name;
        }

        public String key(String name) {
            return name + SPRTR + name;
        }

        public void put(String name) {
            put(key(name), name);
        }

    }

    public interface Atom<E> {
        E value();
        String identifiedBy();
    }

    public interface Related<X, Y> {

    }

    public interface Compound<A, M> {

        co.sys.concept.patterns.models.adt.entities.env.space.Compound set(co.sys.concept.patterns.models.adt.entities.env.space.Compound<A, M> compound);

        co.sys.concept.patterns.models.adt.entities.env.space.Compound set(Map<A, M> m);

        co.sys.concept.patterns.models.adt.entities.env.space.Compound set(Sum<Map<A, M>, Sum<A, M>> f);

        void setMapOrSum(Sum<Map<A, M>, Sum<A, M>> mapOrSum);

        Optional<? super A> getAtom();

        Optional<? super Map<A, M>> getCompound();

    }

    public interface Sequence<A, C> {

        LinkedHashMap<A, C> get();

        co.sys.concept.patterns.models.adt.entities.env.space.Sequence<A,C> set(LinkedHashMap<A, C> hashMap);

        co.sys.concept.patterns.models.adt.entities.env.space.Sequence<A,C> set(A state);

        C get(A a);
    }


    public Concept(Map<Concept, Map<Context, Concept>> concept) {
        this.concept = concept;
    }

    public Concept() {
        this.concept = new ConcurrentHashMap<>();
    }

    public Map<Concept, Map<Context, Concept>> getConcept() {
        return concept;
    }

    public void setConcept(Map<Concept, Map<Context, Concept>> concept) {
        this.concept = concept;
    }
}
