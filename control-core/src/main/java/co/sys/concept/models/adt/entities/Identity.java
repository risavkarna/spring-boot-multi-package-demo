package co.sys.concept.models.adt.entities;

import co.sys.concept.Concept;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * Created by rkarna on 11.04.18
 */
public class Identity<C> extends Concept{

    private C compound;

    public Identity(C a) {
        this.compound = a;
    }

    public static <T> Identity<T> of(T value) {
        return new Identity<>(value);
    }

    public C get() {
        if (compound == null) {
            throw new NoSuchElementException("No value present");
        }
        return compound;
    }

    public boolean isPresent() {
        return compound != null;
    }

    public void ifPresent(Consumer<? super C> consumer) {
        if (compound != null)
            consumer.accept(compound);
    }
}
