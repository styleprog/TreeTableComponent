package pl.codinglab.treetable.view.component.bookreport;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import pl.codinglab.treetable.model.BookPublishingReport;
import pl.codinglab.treetable.util.TestdataGenerator;
import pl.codinglab.treetable.view.component.bookreport.cellfactory.*;
import pl.codinglab.treetable.view.component.bookreport.valuefactory.CellValueFactory;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class BookPublishingReportView implements FxmlView<BookPublishingReportViewModel> {

    @InjectViewModel
    private BookPublishingReportViewModel viewModel;
    @Inject
    private ResourceBundle resourceBundle;
    @FXML
    private TreeTableView<TreeTableRow> bookPublishing;
    @FXML
    private TreeTableColumn<TreeTableRow, String> blankColumn;
    @FXML
    private TreeTableColumn<TreeTableRow, String> writing;
    @FXML
    private TreeTableColumn<TreeTableRow, String> editing;
    @FXML
    private TreeTableColumn<TreeTableRow, String> formatCoop;
    @FXML
    private TreeTableColumn<TreeTableRow, String> formatNoCoop;
    @FXML
    private TreeTableColumn<TreeTableRow, String> printCoop;
    @FXML
    private TreeTableColumn<TreeTableRow, String> printNoCoop;
    @FXML
    private TreeTableColumn<TreeTableRow, String> marketingCoop;
    @FXML
    private TreeTableColumn<TreeTableRow, String> marketingNoCoop;
    @FXML
    private TreeTableColumn<TreeTableRow, String> salesCoop;
    @FXML
    private TreeTableColumn<TreeTableRow, String> salesNoCoop;


    private TreeItem<TreeTableRow> entireBonus;
    private TreeItem<TreeTableRow> providers;

    private CellValueFactory cellValueFactory;

    public void initialize() {
        createTreeTableView();
        cellValueFactory = new CellValueFactory();
    }

    /**
     * Implementing the tree table view consists of the following steps (given, that tree table view element
     * and its columns have already been declared in fxml):
     * <p>
     * (1) creating tree items
     * (2) creating a root element
     * (3) adding tree items to the root
     * (4) defining cell content
     * (5) optionally defining cell factory
     * (6) setting the tree table root
     * <p>
     * <p>
     * TreeTableView can also be declared and have its root and columns assigned programmatically:
     * <p>
     * TreeTableView<String> treeTableView = new TreeTableView<>(root);
     * treeTableView.getColumns().setAll(column1, column2);
     */
    private void createTreeTableView() {
        List<TreeItem<TreeTableRow>> treeItemsControlBlock = createTreeItemsForControlBlock();
        TreeItem<TreeTableRow> root = createRootElement();
        addTreeItemsToRoot(treeItemsControlBlock);
        defineCellContent();
        defineCellFactory();
        setTreeTableRoot(root);
    }

    private TreeItem<TreeTableRow> createRootElement() {
        return new TreeItem<>(new TreeTableRow("ROOT"));
    }

    private List<TreeItem<TreeTableRow>> createTreeItemsForControlBlock() {
        BookPublishingReport report = TestdataGenerator.createBonusReport();
        entireBonus = new TreeItem<>(new TreeTableRow(resourceBundle.getString("bookpublishreport.entirelabel"), report.getEntireData()));
        providers = new TreeItem<>(new TreeTableRow(resourceBundle.getString("bookpublishreport.provider")));
        List<TreeItem<TreeTableRow>> treeItems = new ArrayList<>();
        report.getReportDataProProvider().forEach((k, v) -> treeItems.add(new TreeItem<>(new TreeTableRow(k.getProviderName(), v))));
        return treeItems;
    }

    private void addTreeItemsToRoot(List<TreeItem<TreeTableRow>> treeItems) {
        providers.getChildren().addAll(treeItems);
        providers.setExpanded(true);
        handleStylesOnCollapse();
    }

    /**
     * If the user collapses the tree table, the styles should be reset.
     */
    private void handleStylesOnCollapse() {
        providers.expandedProperty().addListener(new ExpandedPropertyChangeListener(editing));
    }

    private void defineCellContent() {
        blankColumn.setCellValueFactory(this::createCellValueFactoryForBlankColumn);
        writing.setCellValueFactory(param -> this.createCellValueFactory(BookPublishingReportColumns.WRITING, param));
        editing.setCellValueFactory(param -> this.createCellValueFactory(BookPublishingReportColumns.EDITING, param));
        formatCoop.setCellValueFactory(param -> this.createCellValueFactory(BookPublishingReportColumns.FORMAT_COOP, param));
        formatNoCoop.setCellValueFactory(param -> this.createCellValueFactory(BookPublishingReportColumns.FORMAT_NO_COOP, param));
        printCoop.setCellValueFactory(param -> this.createCellValueFactory(BookPublishingReportColumns.PRINT_COOP, param));
        printNoCoop.setCellValueFactory(param -> this.createCellValueFactory(BookPublishingReportColumns.PRINT_NO_COOP, param));
        marketingCoop.setCellValueFactory(param -> this.createCellValueFactory(BookPublishingReportColumns.MARKETING_COOP, param));
        marketingNoCoop.setCellValueFactory(param -> this.createCellValueFactory(BookPublishingReportColumns.MARKETING_NO_COOP, param));
        salesCoop.setCellValueFactory(param -> this.createCellValueFactory(BookPublishingReportColumns.SALES_COOP, param));
        salesNoCoop.setCellValueFactory(param -> this.createCellValueFactory(BookPublishingReportColumns.SALES_NO_COOP, param));
    }

    private ObservableValue<String> createCellValueFactoryForBlankColumn(TreeTableColumn.CellDataFeatures<TreeTableRow, String> param) {
        return new ReadOnlyStringWrapper(param.getValue().getValue().getProvider());
    }

    private ObservableValue<String> createCellValueFactory(BookPublishingReportColumns column, TreeTableColumn.CellDataFeatures<TreeTableRow, String> param) {
        return cellValueFactory.getCellValueStrategy(column).createValueFactory(param);
    }

    private void defineCellFactory() {
        editing.setCellFactory(EditingCellFactory::new);
        writing.setCellFactory(WritingCellFactory::new);
        formatCoop.setCellFactory(FormatCoopCellFactory::new);
        formatNoCoop.setCellFactory(FormatNoCoopCellFactory::new);
        printCoop.setCellFactory(PrintCoopCellFactory::new);
        printNoCoop.setCellFactory(PrintNoCoopCellFactory::new);
        marketingCoop.setCellFactory(MarketingCoopCellFactory::new);
        marketingNoCoop.setCellFactory(MarketingNoCoopCellFactory::new);
        salesCoop.setCellFactory(SalesCoopCellFactory::new);
        salesNoCoop.setCellFactory(SalesNoCoopCellFactory::new);
    }

    private void setTreeTableRoot(TreeItem<TreeTableRow> root) {
        root.setExpanded(true);
        root.getChildren().addAll(entireBonus, providers);
        bookPublishing.setRoot(root);
        bookPublishing.setShowRoot(false);
    }
}