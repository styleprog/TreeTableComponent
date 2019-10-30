package pl.codinglab.treetable.view.component.bookreport.cellfactory;

import pl.codinglab.treetable.view.component.bookreport.TreeTableRow;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.paint.Color;

import java.math.BigDecimal;

public class WritingCellFactory extends TreeTableCellFactory {

    private BigDecimal entireWritingCosts;

    public WritingCellFactory(TreeTableColumn<TreeTableRow, String> treeTableColumn) {
        super(treeTableColumn);
        if (entireData != null) {
            entireWritingCosts = convertStringToBDUsingNumberFormat(entireData.getEntireWriting());
        }
    }

    @Override
    protected void setCellStyleAccordingToReportValue(BigDecimal writingCosts) {
        if (entireWritingCosts != null && !validator.isEntireWritingCostValid(entireWritingCosts) && entireWritingCosts.equals(writingCosts)) {
            setStyle(CELL_BCG);
            setTextFill(Color.WHITE);
        }
        if (!validator.isWritingCostValid(writingCosts) && (!writingCosts.equals(entireWritingCosts))) {
            setStyle(CELL_BCG);
            setTextFill(Color.WHITE);
        }
    }
}
