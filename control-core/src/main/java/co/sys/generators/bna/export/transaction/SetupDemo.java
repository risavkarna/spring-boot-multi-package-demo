package co.sys.generators.bna.export.transaction;

import co.sys.concept.env.Attributes;
import co.sys.concept.env.Relationships;
import co.sys.concept.env.Transaction;

public class SetupDemo<B> extends Transaction<B> {

    public SetupDemo(Attributes attributes, Relationships relationships) {
        super(attributes, relationships);
    }

    public SetupDemo() {
        super(null, null);
    }
}
