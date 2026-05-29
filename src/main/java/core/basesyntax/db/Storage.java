package core.basesyntax.db;

import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Map<String, FruitTransaction> storage = new HashMap<>();

    public void add(String fruitName, FruitTransaction value) {
        storage.put(fruitName, value);
    }

    public FruitTransaction get(String fruitName) {
        return storage.get(fruitName);
    }

    public boolean containsValue(String fruitName) {
        return storage.containsKey(fruitName);
    }

    public Map<String, FruitTransaction> getAll() {
        return storage;
    }
}
