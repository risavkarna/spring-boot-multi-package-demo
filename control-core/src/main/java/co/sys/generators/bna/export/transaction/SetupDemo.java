package co.sys.generators.bna.export.transaction;

import co.sys.concept.patterns.models.adt.entities.Attributes;
import co.sys.concept.patterns.models.adt.entities.Relationships;
import co.sys.concept.patterns.models.adt.entities.Transaction;

public class SetupDemo<B> extends Transaction<B> {

    public SetupDemo(Attributes attributes, Relationships relationships) {
        super(attributes, relationships);
    }

    public SetupDemo() {
        super(null, null);
    }
}
