package co.sys.concept.generators.bna.export.transaction;

import co.sys.concept.patterns.things.adt.entities.Attributes;
import co.sys.concept.patterns.things.adt.entities.Relationships;
import co.sys.concept.patterns.things.adt.entities.Transaction;

public class SetupDemo<B> extends Transaction<B> {

    public SetupDemo(Attributes attributes, Relationships relationships) {
        super(attributes, relationships);
    }

    public SetupDemo() {
        super(null, null);
    }
}
