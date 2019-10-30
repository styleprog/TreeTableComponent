package pl.codinglab.treetable.view.component.bookreport;

import de.saxsys.mvvmfx.ViewModel;
import pl.codinglab.treetable.view.ReportDataViewModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BookPublishingReportViewModel implements ViewModel {

    private final ObservableList<ReportDataViewModel> reportData = FXCollections.observableArrayList();

    public ObservableList<ReportDataViewModel> getReportData() {
        return reportData;
    }
}