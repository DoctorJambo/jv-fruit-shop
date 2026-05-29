package core.basesyntax.service.operation.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationType;

public class SupplyOperationImpl implements OperationType {
    private Storage storage;

    public SupplyOperationImpl(Storage storage) {
        if (storage == null) {
            throw new RuntimeException("storage can not be null");
        }
        this.storage = storage;
    }

    @Override
    public void handle(String line) {
        String[] splitLine = line.split(",");

        String fruitName = splitLine[1];
        String supplyQuantity = splitLine[2];

        if (storage.containsValue(fruitName)) {
            FruitTransaction fruitTransaction = storage.get(fruitName);
            int fruitTransactionQuantity = fruitTransaction.getQuantity();
            int totalQuantity = Integer.parseInt(supplyQuantity) + fruitTransactionQuantity;
            fruitTransaction.setQuantity(totalQuantity);
        } else {
            throw new RuntimeException("there is no value for this key");
        }
    }
}
