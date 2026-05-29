package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;

public interface FruitTransactionDao {
    boolean checkExisting(String key);

    void add(String key, FruitTransaction value);

    FruitTransaction get(String key);
}
