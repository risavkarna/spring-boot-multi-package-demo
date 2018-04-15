package co.sys.concept.adt.context;

import co.sys.concept.Concept;
import co.sys.concept.env.Sum;

import java.util.Optional;

public abstract class Context extends Concept{

	public abstract Sum getMapOrSum();

	public abstract Optional getAtomicEvent();

	public abstract Optional getAtomicState();
}
