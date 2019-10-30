package pl.codinglab.treetable.view.component.bookreport.cellfactory;

import pl.codinglab.treetable.model.EntireData;
import pl.codinglab.treetable.model.validator.BookPublishingValidator;
import pl.codinglab.treetable.view.component.bookreport.TreeTableRow;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Base class for all cell factories in the tree table view.
 * It handles the custom styling of the cell depending on provided validation rules.
 */
public abstract class TreeTableCellFactory extends TreeTableCell<TreeTableRow, String> {

    private static final Logger LOG = LoggerFactory.getLogger(TreeTableCellFactory.class);

    static final String CELL_TEXT_FILL = "-fx-text-fill: red";
    static final String CELL_BCG = "-fx-background-color: red";
    protected BookPublishingValidator validator;
    protected EntireData entireData;

    TreeTableCellFactory(TreeTableColumn<TreeTableRow, String> treeTableColumn) {
        validator = new BookPublishingValidator();
        // get the first row, which represents the "entire data"
        TreeItem<TreeTableRow> entireDataRow = treeTableColumn.getTreeTableView().getTreeItem(0);
        this.entireData = entireDataRow.getValue().getEntireData();
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        setText(item);
        if (item != null && !item.isEmpty()) {
            setCellStyleAccordingToReportValue(convertStringToBDUsingNumberFormat(item));
        }
    }

    protected BigDecimal convertStringToBDUsingNumberFormat(String item) {
        if(item != null) {
            Number parsedNumber = null;
            NumberFormat euroFormat = getEuroFormat();
            euroFormat.setMaximumFractionDigits(2);
            euroFormat.setRoundingMode(RoundingMode.HALF_UP);
            DecimalFormat decimalFormat = (DecimalFormat) euroFormat;
            decimalFormat.setParseBigDecimal(true);
            try {
                parsedNumber = decimalFormat.parse(item);
            } catch (ParseException e) {
                LOG.error("Error parsing string to number", e);
            }
            if (parsedNumber != null) {
                return BigDecimal.valueOf(parsedNumber.doubleValue());
            }
        }
        return BigDecimal.ZERO;
    }

    private NumberFormat getEuroFormat() {
        return NumberFormat.getInstance(Locale.GERMANY);
    }

    /**
     * It takes the report value and passes it to the validator.
     * According to the result, the appropriate cell should be styled.
     */
    protected abstract void setCellStyleAccordingToReportValue(BigDecimal reportValue);

    protected EntireData getEntireData() {
        return entireData;
    }
}
