package pl.codinglab.treetable.view.component.bookreport.cellfactory;

import pl.codinglab.treetable.view.component.bookreport.TreeTableRow;
import javafx.scene.control.TreeTableColumn;

import java.math.BigDecimal;

public class SalesCoopCellFactory extends TreeTableCellFactory {

    private BigDecimal entireSalesCoopCosts;

    public SalesCoopCellFactory(TreeTableColumn<TreeTableRow, String> treeTableColumn) {
        super(treeTableColumn);
        if (entireData != null) {
            entireSalesCoopCosts = convertStringToBDUsingNumberFormat(entireData.getEntireSalesCoop());
        }
    }

    @Override
    protected void setCellStyleAccordingToReportValue(BigDecimal salesCoopCosts) {
        if (entireSalesCoopCosts != null && !validator.isEntireSalesCoopCostValid(entireSalesCoopCosts)
                && entireSalesCoopCosts.equals(salesCoopCosts)) {
            setStyle(CELL_TEXT_FILL);
        }
        if (!validator.isSalesCoopCostValid(salesCoopCosts) && (!salesCoopCosts.equals(entireSalesCoopCosts))) {
            setStyle(CELL_TEXT_FILL);
        }
    }
}
