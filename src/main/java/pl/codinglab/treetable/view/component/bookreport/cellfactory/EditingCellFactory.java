package pl.codinglab.treetable.view.component.bookreport.cellfactory;

import pl.codinglab.treetable.view.component.bookreport.TreeTableRow;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.paint.Color;

import java.math.BigDecimal;

public class EditingCellFactory extends TreeTableCellFactory {

    private BigDecimal entireEditingCosts;

    public EditingCellFactory(TreeTableColumn<TreeTableRow, String> treeTableColumn) {
        super(treeTableColumn);
        if (entireData != null) {
            entireEditingCosts = convertStringToBDUsingNumberFormat(entireData.getEntireEditing());
        }

    }

    @Override
    protected void setCellStyleAccordingToReportValue(BigDecimal editingCosts) {
        if (entireEditingCosts != null && !validator.isEntireEditingCostValid(entireEditingCosts) && entireEditingCosts.equals(editingCosts)) {
            setStyle(CELL_BCG);
            setTextFill(Color.WHITE);
        }
        if (!validator.isEditingCostValid(editingCosts) && (!editingCosts.equals(entireEditingCosts))) {
            setStyle(CELL_BCG);
            setTextFill(Color.WHITE);
        }
    }
}
