package pl.codinglab.treetable.view.component.bookreport.cellfactory;

import pl.codinglab.treetable.view.component.bookreport.TreeTableRow;
import javafx.scene.control.TreeTableColumn;

import java.math.BigDecimal;

public class PrintNoCoopCellFactory extends TreeTableCellFactory {

    private BigDecimal entirePrintNoCoopCosts;

    public PrintNoCoopCellFactory(TreeTableColumn<TreeTableRow, String> treeTableColumn) {
        super(treeTableColumn);
        if (entireData != null) {
            entirePrintNoCoopCosts = convertStringToBDUsingNumberFormat(entireData.getEntirePrintNoCoop());
        }
    }

    @Override
    protected void setCellStyleAccordingToReportValue(BigDecimal printNoCoopCosts) {
        if (entirePrintNoCoopCosts != null && !validator.isEntirePrintNoCoopCostValid(entirePrintNoCoopCosts) && entirePrintNoCoopCosts.equals(printNoCoopCosts)) {
            setStyle(CELL_TEXT_FILL);
        }
        if (!validator.isPrintNoCoopCostValid(printNoCoopCosts) && (!printNoCoopCosts.equals(entirePrintNoCoopCosts))) {
            setStyle(CELL_TEXT_FILL);
        }
    }
}
