package pl.codinglab.treetable.view.component.bookreport.cellfactory;

import pl.codinglab.treetable.view.component.bookreport.TreeTableRow;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.paint.Color;

import java.math.BigDecimal;

public class FormatCoopCellFactory extends TreeTableCellFactory {

    private BigDecimal entireFormatCoopCosts;

    public FormatCoopCellFactory(TreeTableColumn<TreeTableRow, String> treeTableColumn) {
        super(treeTableColumn);
        if (entireData != null) {
            entireFormatCoopCosts = convertStringToBDUsingNumberFormat(entireData.getEntireFormatCoop());
        }
    }

    @Override
    public void setCellStyleAccordingToReportValue(BigDecimal formatCoopCosts) {
        if (entireFormatCoopCosts != null && !validator.isEntireFormatCoopCostValid(entireFormatCoopCosts)
                && (formatCoopCosts.equals(entireFormatCoopCosts))) {
            setTextFill(Color.WHITE);
            setStyle(CELL_BCG);
        }
        if (!formatCoopCosts.equals(entireFormatCoopCosts) && !validator.isFormatCoopCostValid(formatCoopCosts)) {
            setTextFill(Color.WHITE);
            setStyle(CELL_BCG);
        }
    }
}
