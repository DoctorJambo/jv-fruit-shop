package core.basesyntax;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.FruitTransactionDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.operation.OperationType;
import core.basesyntax.service.operation.impl.BalanceOperationImpl;
import core.basesyntax.service.operation.impl.PurchaseOperationImpl;
import core.basesyntax.service.operation.impl.ReturnOperationImpl;
import core.basesyntax.service.operation.impl.SupplyOperationImpl;
import java.util.HashMap;
import java.util.Map;

public class HelloWorld {
    public static void main(String[] args) {
        FruitTransactionDao fruitTransaction = new FruitTransactionDaoImpl();

        Map<FruitTransaction.Operation, OperationType> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationImpl(fruitTransaction));
        operationHandlers.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationImpl(fruitTransaction));
        operationHandlers.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationImpl(fruitTransaction));
        operationHandlers.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationImpl(fruitTransaction));

        ShopService service = new ShopServiceImpl(operationHandlers,
                "src/main/resources/inputData.csv");
        service.reportMaker();
    }
}
