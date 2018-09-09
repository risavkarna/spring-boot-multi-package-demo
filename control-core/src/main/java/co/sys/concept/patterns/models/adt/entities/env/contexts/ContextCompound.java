package co.sys.concept.patterns.models.adt.entities.env.contexts;

import co.sys.concept.patterns.models.adt.entities.env.space.Compound;
import co.sys.concept.patterns.models.adt.entities.Sum;
import co.sys.util.Misc;

import java.util.Map;
import java.util.Optional;

public class ContextCompound<Event, State> extends Context implements Compound<Event, State>{

	private Sum<Map<Event, State>, Sum<Event, State>> mapOrSum;

	@Override
	public Sum<Map<Event, State>, Sum<Event, State>> getMapOrSum() {
		return mapOrSum;
	}

	@Override
	public void setMapOrSum(Sum<Map<Event, State>, Sum<Event, State>> mapOrSum) {
		this.mapOrSum = mapOrSum;
	}

	@Override
	public Optional<? super Event> getAtomicAction() {
		return mapOrSum.fromRight()
				.map(e -> {
					if (e.isLeft()) {
						return Optional.of(e);
					} else {
						return Optional.empty();
					}
				});
	}

	@Override
	public Optional<? super Event> getAtom() {
		return this.getAtomicAction();
	}

	@Override
	public Optional<? super State> getAtomicState() {
		return mapOrSum.fromRight()
				.map(s -> {
					if (s.isRight()) {
						return Optional.of(s);
					} else {
						return Optional.empty();
					}
				});
	}


	@Override
	public Optional<Map<Event, State>> getCompound() {
		return mapOrSum.fromLeft();
	}

	@Override
	public co.sys.concept.patterns.models.adt.entities.env.space.Compound set(co.sys.concept.patterns.models.adt.entities.env.space.Compound<Event, State> compound) {
		throw Misc.unsupported();
	}

	@Override
	public ContextCompound set(Map<Event, State> m) {
		throw Misc.unsupported();
	}

	@Override
	public ContextCompound set(Sum<Map<Event, State>, Sum<Event, State>> f) {
		throw Misc.unsupported();
	}


}
