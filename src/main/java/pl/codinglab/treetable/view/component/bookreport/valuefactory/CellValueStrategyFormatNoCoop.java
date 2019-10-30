package pl.codinglab.treetable.view.component.bookreport.valuefactory;

import pl.codinglab.treetable.model.EntireData;
import pl.codinglab.treetable.model.ReportData;
import pl.codinglab.treetable.view.component.bookreport.TreeTableRow;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TreeTableColumn;

import java.util.Optional;

public class CellValueStrategyFormatNoCoop implements CellValueStrategy {

    @Override
    public ObservableValue<String> createValueFactory(TreeTableColumn.CellDataFeatures<TreeTableRow, String> param) {
        Optional<EntireData> entireData = Optional.ofNullable(param.getValue().getValue().getEntireData());
        Optional<ReportData> reportData = Optional.ofNullable(param.getValue().getValue().getReportData());
        if (entireData.isPresent()) {
            return new ReadOnlyStringWrapper(entireData.get().getEntireFormatNoCoop());
        } else if (reportData.isPresent()) {
            return new ReadOnlyStringWrapper(reportData.get().getFormatNoCoop());
        }
        return new ReadOnlyStringWrapper("");
    }
}
