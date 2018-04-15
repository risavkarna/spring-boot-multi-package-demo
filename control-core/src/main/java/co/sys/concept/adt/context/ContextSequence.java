package co.sys.concept.adt.context;

import co.sys.concept.env.space.Sequence;

import java.util.LinkedHashMap;

public abstract class ContextSequence<Context, ContextCompound> implements Sequence<Context, ContextCompound> {

    private LinkedHashMap<Context, ContextCompound> contexts;

    public ContextSequence(LinkedHashMap<Context, ContextCompound> contexts) {
        this.contexts = contexts;
    }

    public ContextSequence() {
        this.contexts = new LinkedHashMap<>();
    }

    public ContextSequence(Context context) {
        set(context);
    }

    @Override
    public LinkedHashMap<Context, ContextCompound> get() {
        return contexts;
    }

    @Override
    public ContextSequence<Context, ContextCompound> set(LinkedHashMap<Context, ContextCompound> contexts) {
        this.contexts = contexts;
        return this;
    }

    @Override
    public ContextSequence<Context, ContextCompound> set(Context context) {
        this.contexts = new LinkedHashMap<>();
        this.contexts.put(context, null);
        return this;
    }

    @Override
    public ContextCompound get(Context context){
        return contexts.get(context);
    }
}
