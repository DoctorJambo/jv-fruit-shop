package core.basesyntax.service.operation.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationType;

public class BalanceOperationImpl implements OperationType {
    private Storage storage;

    public BalanceOperationImpl(Storage storage) {
        if (storage == null) {
            throw new RuntimeException("storage can not be null");
        }
        this.storage = storage;
    }

    @Override
    public void handle(String line) {
        String[] splitLine = line.split(",");

        String fruitName = splitLine[1];
        String fruitQuantity = splitLine[2];

        if (storage.containsValue(fruitName)) {
            throw new RuntimeException("fruit already exist");
        }

        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setFruit(fruitName);
        fruitTransaction.setQuantity(Integer.parseInt(fruitQuantity));

        storage.add(fruitName, fruitTransaction);
    }
}
