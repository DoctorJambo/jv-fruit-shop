package core.basesyntax.service.operation.impl;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationType;

public class SupplyOperationImpl implements OperationType {
    private final FruitTransactionDao dao;

    public SupplyOperationImpl(FruitTransactionDao dao) {
        this.dao = dao;
    }

    @Override
    public void handle(String line) {
        String[] splitLine = line.split(",");

        String fruitName = splitLine[1];
        String supplyQuantity = splitLine[2];

        if (dao.checkExisting(fruitName)) {
            FruitTransaction fruitTransaction = dao.get(fruitName);

            int fruitTransactionQuantity = fruitTransaction.getQuantity();
            int totalQuantity = Integer.parseInt(supplyQuantity) + fruitTransactionQuantity;
            fruitTransaction.setQuantity(totalQuantity);
        }
    }
}
