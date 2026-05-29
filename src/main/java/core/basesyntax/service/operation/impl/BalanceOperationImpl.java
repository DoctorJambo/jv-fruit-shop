package core.basesyntax.service.operation.impl;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationType;

public class BalanceOperationImpl implements OperationType {
    private final FruitTransactionDao dao;

    public BalanceOperationImpl(FruitTransactionDao dao) {
        this.dao = dao;
    }

    @Override
    public void handle(String line) {
        String[] splitLine = line.split(",");

        String fruitName = splitLine[1];
        String fruitQuantity = splitLine[2];

        if (dao.checkExisting(fruitName)) {
            throw new RuntimeException("fruit already exist");
        }

        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setFruit(fruitName);
        fruitTransaction.setQuantity(Integer.parseInt(fruitQuantity));

        dao.add(fruitName, fruitTransaction);
    }
}
