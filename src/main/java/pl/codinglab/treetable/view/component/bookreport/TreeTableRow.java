package pl.codinglab.treetable.view.component.bookreport;

import pl.codinglab.treetable.model.EntireData;
import pl.codinglab.treetable.model.ReportData;

public class TreeTableRow {

    private String provider;
    private ReportData reportData;
    private EntireData entireData;


    public TreeTableRow(String provider) {
        this.provider = provider;
    }

    public TreeTableRow(String provider, ReportData reportData) {
        this.provider = provider;
        this.reportData = reportData;
    }

    public TreeTableRow(String provider, EntireData entireData) {
        this.provider = provider;
        this.entireData = entireData;
    }

    public String getProvider() {
        return provider;
    }

    public ReportData getReportData() {
        return reportData;
    }

    public EntireData getEntireData() {
        return entireData;
    }
}
