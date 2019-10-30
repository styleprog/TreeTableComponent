package pl.codinglab.treetable.view.component.bookreport.cellfactory;

import pl.codinglab.treetable.view.component.bookreport.TreeTableRow;
import javafx.scene.control.TreeTableColumn;

import java.math.BigDecimal;

public class FormatNoCoopCellFactory extends TreeTableCellFactory {

    private BigDecimal entireFormatNoCoopCosts;

    public FormatNoCoopCellFactory(TreeTableColumn<TreeTableRow, String> treeTableColumn) {
        super(treeTableColumn);
        if (entireData != null) {
            entireFormatNoCoopCosts = convertStringToBDUsingNumberFormat(entireData.getEntireFormatNoCoop());
        }
    }

    @Override
    protected void setCellStyleAccordingToReportValue(BigDecimal formatNoCoopCosts) {
        if (entireFormatNoCoopCosts != null && !validator.isEntireFormatNoCoopCostValid(entireFormatNoCoopCosts)
                && (formatNoCoopCosts.equals(entireFormatNoCoopCosts))) {
            setStyle(CELL_TEXT_FILL);
        }
        if (!formatNoCoopCosts.equals(entireFormatNoCoopCosts) && !validator.isFormatNoCoopCostValid(formatNoCoopCosts)) {
            setStyle(CELL_TEXT_FILL);
        }
    }
}