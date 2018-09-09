package co.sys.concept.models.adt.env.space;

import co.sys.concept.models.adt.entities.Sum;

import java.util.Map;
import java.util.Optional;
public interface Compound<A, M> {

    Compound set(Compound<A, M> compound);

    Compound set(Map<A, M> m);

    Compound set(Sum<Map<A, M>, Sum<A, M>> f);

    void setMapOrSum(Sum<Map<A, M>, Sum<A, M>> mapOrSum);

    Optional<? super A> getAtom();

    Optional<Map<A, M>> getCompound();

}
