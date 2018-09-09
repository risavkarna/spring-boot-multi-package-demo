package co.sys.concept.patterns.models.adt.entities.env.space;

import java.util.LinkedHashMap;

public interface Sequence<A, C> {

    LinkedHashMap<A, C> get();

    Sequence<A,C> set(LinkedHashMap<A, C> hashMap);

    Sequence<A,C> set(A state);

    C get(A a);
}
