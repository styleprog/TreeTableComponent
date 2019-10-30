package pl.codinglab.treetable.view.component.bookreport.cellfactory;

import pl.codinglab.treetable.view.component.bookreport.TreeTableRow;
import javafx.scene.control.TreeTableColumn;

import java.math.BigDecimal;

public class CellValueStrategyBlankStyle extends TreeTableCellFactory {

    static final String CELL_BCG = "-fx-background-color: white";

    public CellValueStrategyBlankStyle(TreeTableColumn<TreeTableRow, String> treeTableColumn) {
        super(treeTableColumn);
    }

    @Override
    protected void setCellStyleAccordingToReportValue(BigDecimal reportValue) {
        setStyle(CELL_BCG);
    }
}
