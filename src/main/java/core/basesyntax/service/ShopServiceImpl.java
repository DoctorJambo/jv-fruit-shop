package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.service.converting.DataConverter;
import core.basesyntax.service.converting.DataConverterImpl;
import core.basesyntax.service.converting.ReportGenerator;
import core.basesyntax.service.converting.ReportGeneratorImpl;
import core.basesyntax.service.operation.OperationType;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy strategy;
    private String inputDataFileName;
    private String reportFileName;
    private DataConverter converter;
    private ReportGenerator reportGenerator;

    public ShopServiceImpl(Map<String, OperationType> map,
                           String inputDataFileName, Storage storage) {
        this.strategy = new OperationStrategyImpl(map);
        this.inputDataFileName = inputDataFileName;
        this.converter = new DataConverterImpl();
        this.reportGenerator = new ReportGeneratorImpl(storage);
        this.reportFileName = "src/main/resources/report.csv";
    }

    @Override
    public void createReport() {
        List<String> linesOfData = converter.getInfoFromFile(inputDataFileName);

        for (int i = 1; i < linesOfData.size(); i++) {
            String[] splitLine = linesOfData.get(i).split(",");

            OperationType operationType =
                    strategy.operationHandler(splitLine[0]);
            operationType.handle(linesOfData.get(i));
        }

        reportGenerator.getReport(reportFileName);
    }
}
