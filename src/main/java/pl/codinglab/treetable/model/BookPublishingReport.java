package pl.codinglab.treetable.model;

import java.util.List;
import java.util.Map;

/**
 * Model for "Book Publishing Report".
 */
public class BookPublishingReport {

    private List<Provider> providers;
    private Map<Provider, ReportData> reportDataProProvider;
    private EntireData entireData;

    public BookPublishingReport(BookPublishingReportBuilder builder) {
        this.providers = builder.controlBlocks;
        this.reportDataProProvider = builder.reportDataProControlBlock;
        this.entireData = builder.entireData;
    }

    public static class BookPublishingReportBuilder {
        private List<Provider> controlBlocks;
        private Map<Provider, ReportData> reportDataProControlBlock;
        private EntireData entireData;

        public BookPublishingReportBuilder controlBlocks(List<Provider> controlBlocks) {
            this.controlBlocks = controlBlocks;
            return this;
        }

        public BookPublishingReportBuilder reportDataProControlBlock(Map<Provider, ReportData> reportDataProControlBlock) {
            this.reportDataProControlBlock = reportDataProControlBlock;
            return this;
        }

        public BookPublishingReportBuilder entireData(EntireData entireData) {
            this.entireData = entireData;
            return this;
        }

        public BookPublishingReport build() {
            return new BookPublishingReport(this);
        }
    }

    public List<Provider> getProviders() {
        return providers;
    }

    public Map<Provider, ReportData> getReportDataProProvider() {
        return reportDataProProvider;
    }

    public EntireData getEntireData() {
        return entireData;
    }
}
