package pl.codinglab.treetable.view.component.bookreport.valuefactory;

import pl.codinglab.treetable.view.component.bookreport.TreeTableRow;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TreeTableColumn;

/**
 * Strategy for creating the cell value factory for various columns.
 * Each new column should implement this interface.
 */
public interface CellValueStrategy {

    ObservableValue<String> createValueFactory(TreeTableColumn.CellDataFeatures<TreeTableRow, String> param);
}
