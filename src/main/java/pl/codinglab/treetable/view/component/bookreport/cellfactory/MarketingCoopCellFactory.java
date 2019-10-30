package pl.codinglab.treetable.view.component.bookreport.cellfactory;

import pl.codinglab.treetable.view.component.bookreport.TreeTableRow;
import javafx.scene.control.TreeTableColumn;

import java.math.BigDecimal;

public class MarketingCoopCellFactory extends TreeTableCellFactory {

    private BigDecimal entireMarketingCoopCosts;

    public MarketingCoopCellFactory(TreeTableColumn<TreeTableRow, String> treeTableColumn) {
        super(treeTableColumn);
        if (entireData != null) {
            entireMarketingCoopCosts = convertStringToBDUsingNumberFormat(entireData.getEntireMarketingCoop());
        }
    }

    @Override
    protected void setCellStyleAccordingToReportValue(BigDecimal marketingCoopCosts) {
        if (entireMarketingCoopCosts != null && !validator.isEntireMarketingCoopCostValid(entireMarketingCoopCosts)
                && entireMarketingCoopCosts.equals(marketingCoopCosts)) {
            setStyle(CELL_TEXT_FILL);
        }
        if (!validator.isMarketingCoopCostValid(marketingCoopCosts) && (!marketingCoopCosts.equals(entireMarketingCoopCosts))) {
            setStyle(CELL_TEXT_FILL);
        }
    }
}
