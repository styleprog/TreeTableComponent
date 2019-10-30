package pl.codinglab.treetable.view.component.bookreport.cellfactory;

import pl.codinglab.treetable.view.component.bookreport.TreeTableRow;
import javafx.scene.control.TreeTableColumn;

import java.math.BigDecimal;

public class PrintCoopCellFactory extends TreeTableCellFactory {

    private BigDecimal entirePrintCoopCosts;

    public PrintCoopCellFactory(TreeTableColumn<TreeTableRow, String> treeTableColumn) {
        super(treeTableColumn);
        if (entireData != null) {
            entirePrintCoopCosts = convertStringToBDUsingNumberFormat(entireData.getEntirePrintCoop());
        }
    }

    @Override
    protected void setCellStyleAccordingToReportValue(BigDecimal printCoopCosts) {
        if (entirePrintCoopCosts != null && !validator.isEntirePrintCoopCostValid(entirePrintCoopCosts)
                && entirePrintCoopCosts.equals(printCoopCosts)) {
            setStyle(CELL_TEXT_FILL);
        }
        if (!validator.isPrintCoopCostValid(printCoopCosts) && (!printCoopCosts.equals(entirePrintCoopCosts))) {
            setStyle(CELL_TEXT_FILL);
        }
    }
}
