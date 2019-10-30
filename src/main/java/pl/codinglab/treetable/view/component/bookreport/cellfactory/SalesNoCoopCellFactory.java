package pl.codinglab.treetable.view.component.bookreport.cellfactory;

import pl.codinglab.treetable.view.component.bookreport.TreeTableRow;
import javafx.scene.control.TreeTableColumn;

import java.math.BigDecimal;

public class SalesNoCoopCellFactory extends TreeTableCellFactory {

    private BigDecimal entireSalesNoCoopCosts;

    public SalesNoCoopCellFactory(TreeTableColumn<TreeTableRow, String> treeTableColumn) {
        super(treeTableColumn);
        if (entireData != null) {
            entireSalesNoCoopCosts = convertStringToBDUsingNumberFormat(entireData.getEntireSalesNoCoop());
        }
    }

    @Override
    protected void setCellStyleAccordingToReportValue(BigDecimal salesNoCoopCosts) {
        if (entireSalesNoCoopCosts != null && !validator.isEntireSalesNoCoopCostValid(entireSalesNoCoopCosts)
                && entireSalesNoCoopCosts.equals(salesNoCoopCosts)) {
            setStyle(CELL_TEXT_FILL);
        }
        if (!validator.isSalesNoCoopCostValid(salesNoCoopCosts) && (!salesNoCoopCosts.equals(entireSalesNoCoopCosts))) {
            setStyle(CELL_TEXT_FILL);
        }
    }
}
