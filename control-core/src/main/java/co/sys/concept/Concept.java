package co.sys.concept;

import co.sys.concept.adt.context.Context;
import co.sys.concept.env.Sum;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Concept {

    private Map<Concept, Map<Context, Concept>> concept;

    public interface Atom<E> {
        E value();
    }

    public interface Compound<A, M> {

        co.sys.concept.env.space.Compound set(co.sys.concept.env.space.Compound<A, M> compound);

        co.sys.concept.env.space.Compound set(Map<A, M> m);

        co.sys.concept.env.space.Compound set(Sum<Map<A, M>, Sum<A, M>> f);

        void setMapOrSum(Sum<Map<A, M>, Sum<A, M>> mapOrSum);

        Optional<? super A> getAtom();

        Optional<? super Map<A, M>> getCompound();

    }

    public interface Sequence<A, C> {

        LinkedHashMap<A, C> get();

        co.sys.concept.env.space.Sequence<A,C> set(LinkedHashMap<A, C> hashMap);

        co.sys.concept.env.space.Sequence<A,C> set(A state);

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
