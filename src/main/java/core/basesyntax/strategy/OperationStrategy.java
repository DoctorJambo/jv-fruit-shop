package core.basesyntax.strategy;

import core.basesyntax.service.operation.OperationType;

public interface OperationStrategy {
    OperationType operationHandler(String operation);
}
