package co.sys.concept.env;

import java.util.HashMap;
import java.util.Map;

public class Attributes {

    private Map<String, Object> all;

    public Attributes(Map<String, Object> all) {
        this.all = all;
    }

    public Attributes() {
        this.all = new HashMap<>();
    }

    public Map<String, Object> getAll() {
        return all;
    }

    public void setAll(Map<String, Object> all) {
        this.all = all;
    }

    public Attributes add(Object item) {
        return add(item.getClass().getTypeName(), item);
    }

    public Attributes update(String key, Object item) {
        all.put(key, item);
        return this;
    }

    public Object get(String item) {
        return all.get(item);
    }

    public Attributes add(String key, Object item) {
        if (!all.containsKey(key)) {
            return update(key, item);
        }
        return this;
    }

    public Attributes remove(Object item) {
        all.remove(item.getClass().getTypeName());
        return this;
    }

    public Attributes remove(String key) {
        all.remove(key);
        return this;
    }

}
