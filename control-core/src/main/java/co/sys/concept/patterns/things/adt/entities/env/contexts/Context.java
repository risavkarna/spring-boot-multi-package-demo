package co.sys.concept.patterns.things.adt.entities.env.contexts;

import co.sys.concept.Concept;
import co.sys.concept.patterns.things.adt.entities.Sum;

import java.util.Optional;

public abstract class Context extends Concept{

	public abstract Sum getMapOrSum();

	public abstract Optional getAtomicAction();

	public abstract Optional getAtomicState();
}
