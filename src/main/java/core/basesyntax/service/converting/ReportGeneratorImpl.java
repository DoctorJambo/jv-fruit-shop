package core.basesyntax.service.converting;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private Storage storage;

    public ReportGeneratorImpl(Storage storage) {
        if (storage == null) {
            throw new RuntimeException("storage can not be null");
        }
        this.storage = storage;
    }

    @Override
    public void getReport(String reportFileName) {
        StringBuilder result = new StringBuilder("fruit,quantity" + "\n");

        for (Map.Entry<String, FruitTransaction> elements : storage.getAll().entrySet()) {
            result.append(elements.getKey())
                    .append(",")
                    .append(elements.getValue().getQuantity())
                    .append("\n");
        }

        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(reportFileName))) {
            fileWriter.write(result.toString());
        } catch (IOException e) {
            throw new RuntimeException("can not write data to file --> " + reportFileName);
        }
    }
}
