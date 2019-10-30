package pl.codinglab.treetable.view.component.bookreport.cellfactory;

import pl.codinglab.treetable.view.component.bookreport.TreeTableRow;
import javafx.scene.control.TreeTableColumn;

import java.math.BigDecimal;

public class MarketingNoCoopCellFactory extends TreeTableCellFactory {

    private BigDecimal entireMarketingNoCoopCosts;

    public MarketingNoCoopCellFactory(TreeTableColumn<TreeTableRow, String> treeTableColumn) {
        super(treeTableColumn);
        if (entireData != null) {
            entireMarketingNoCoopCosts = convertStringToBDUsingNumberFormat(entireData.getEntireMarketingNoCoop());
        }
    }

    @Override
    protected void setCellStyleAccordingToReportValue(BigDecimal marketingNoCoopCosts) {
        if (entireMarketingNoCoopCosts != null && !validator.isEntireMarketingNoCoopCostValid(entireMarketingNoCoopCosts)
                && entireMarketingNoCoopCosts.equals(marketingNoCoopCosts)) {
            setStyle(CELL_TEXT_FILL);
        }
        if (!validator.isMarketingNoCoopCostValid(marketingNoCoopCosts) && (!marketingNoCoopCosts.equals(entireMarketingNoCoopCosts))) {
            setStyle(CELL_TEXT_FILL);
        }
    }
}
