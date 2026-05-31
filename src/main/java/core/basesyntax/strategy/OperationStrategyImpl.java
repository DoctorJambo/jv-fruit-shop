package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationType;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<String, OperationType> operationHandlersMap;

    public OperationStrategyImpl(
            Map<String, OperationType> operationHandlersMap) {
        this.operationHandlersMap = operationHandlersMap;
    }

    @Override
    public OperationType operationHandler(String operationKey) {
        return operationHandlersMap.get(operationKey);
    }
}
