package core.basesyntax;

import core.basesyntax.db.Storage;
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

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage(); // один раз!

        Map<FruitTransaction.Operation, OperationType> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationImpl(storage));
        operationHandlers.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationImpl(storage));
        operationHandlers.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationImpl(storage));
        operationHandlers.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationImpl(storage));

        ShopService service = new ShopServiceImpl(operationHandlers,
                "src/main/resources/inputData.csv", storage);
        service.createReport();
    }
}
