package co.sys.concept.i;

import co.sys.concept.Sum;

import java.util.Map;
import java.util.Optional;
public interface Compound<A, M> {

    Compound set(Compound<A, M> compound);

    Compound set(Map<A, M> m);

    Compound set(Sum<Map<A, M>, Sum<A, M>> f);

    Optional<? super A> getAtom();

    Optional<? super Map<A, M>> getCompound();

}
