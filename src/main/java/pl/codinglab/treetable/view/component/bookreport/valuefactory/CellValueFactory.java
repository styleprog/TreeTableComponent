package pl.codinglab.treetable.view.component.bookreport.valuefactory;

import pl.codinglab.treetable.view.component.bookreport.BookPublishingReportColumns;

import java.util.EnumMap;
import java.util.Map;

/**
 * Handles creating of concrete cell value factories.
 * For each new column the cell value strategy should be added to the map.
 */
public class CellValueFactory {

    private static final Map<BookPublishingReportColumns, CellValueStrategy> CELL_VALUE_STRATEGIES = new EnumMap<>(BookPublishingReportColumns.class);

    public CellValueFactory() {
        CELL_VALUE_STRATEGIES.put(BookPublishingReportColumns.WRITING, new CellValueStrategyWriting());
        CELL_VALUE_STRATEGIES.put(BookPublishingReportColumns.EDITING, new CellValueStrategyEditing());
        CELL_VALUE_STRATEGIES.put(BookPublishingReportColumns.FORMAT_COOP, new CellValueStrategyFormatCoop());
        CELL_VALUE_STRATEGIES.put(BookPublishingReportColumns.FORMAT_NO_COOP, new CellValueStrategyFormatNoCoop());
        CELL_VALUE_STRATEGIES.put(BookPublishingReportColumns.PRINT_COOP, new CellValueStrategyPrintCoop());
        CELL_VALUE_STRATEGIES.put(BookPublishingReportColumns.PRINT_NO_COOP, new CellValueStrategyPrintNoCoop());
        CELL_VALUE_STRATEGIES.put(BookPublishingReportColumns.MARKETING_COOP, new CellValueStrategyMarketingCoop());
        CELL_VALUE_STRATEGIES.put(BookPublishingReportColumns.MARKETING_NO_COOP, new CellValueStrategyMarketingNoCoop());
        CELL_VALUE_STRATEGIES.put(BookPublishingReportColumns.SALES_COOP, new CellValueStrategySalesCoop());
        CELL_VALUE_STRATEGIES.put(BookPublishingReportColumns.SALES_NO_COOP, new CellValueStrategySalesNoCoop());
    }

    public CellValueStrategy getCellValueStrategy(BookPublishingReportColumns column) {
        return CELL_VALUE_STRATEGIES.get(column);
    }
}
