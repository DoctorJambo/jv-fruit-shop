package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class FruitTransactionDaoImpl implements FruitTransactionDao {

    @Override
    public boolean checkExisting(String key) {
        return Storage.storage.containsKey(key);
    }

    @Override
    public void add(String key, FruitTransaction value) {
        Storage.storage.put(key, value);
    }

    @Override
    public FruitTransaction get(String key) {
        return Storage.storage.get(key);
    }
}
