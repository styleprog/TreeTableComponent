package pl.codinglab.treetable.view.component.bookreport;

import pl.codinglab.treetable.view.component.bookreport.cellfactory.CellValueStrategyBlankStyle;
import pl.codinglab.treetable.view.component.bookreport.cellfactory.EditingCellFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TreeTableColumn;

public class ExpandedPropertyChangeListener implements ChangeListener<Boolean> {

    private TreeTableColumn<TreeTableRow, String> editingCosts;

    public ExpandedPropertyChangeListener(TreeTableColumn<TreeTableRow, String> editingCosts) {
        this.editingCosts = editingCosts;
    }

    @Override
    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
        if (!observable.getValue()) {
            unregisterCellFactories();
        } else {
            editingCosts.setCellFactory(EditingCellFactory::new);
        }
    }

    private void unregisterCellFactories() {
        editingCosts.setCellFactory(CellValueStrategyBlankStyle::new);
    }
}
