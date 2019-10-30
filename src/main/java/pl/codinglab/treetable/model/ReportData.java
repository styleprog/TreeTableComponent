package pl.codinglab.treetable.model;

public class ReportData {

    private String writing;
    private String editing;
    private String formatCoop;
    private String formatNoCoop;
    private String printCoop;
    private String printNoCoop;
    private String marketingCoop;
    private String marketingNoCoop;
    private String salesCoop;
    private String salesNoCoop;

    public ReportData(ReportDataBuilder builder) {
        this.writing = builder.writing;
        this.editing = builder.editing;
        this.formatCoop = builder.formatCoop;
        this.formatNoCoop = builder.formatNoCoop;
        this.printCoop = builder.printCoop;
        this.printNoCoop = builder.printNoCoop;
        this.marketingCoop = builder.marketingCoop;
        this.marketingNoCoop = builder.marketingNoCoop;
        this.salesCoop = builder.salesCoop;
        this.salesNoCoop = builder.salesNoCoop;
    }

    public static class ReportDataBuilder {
        private String writing;
        private String editing;
        private String formatCoop;
        private String formatNoCoop;
        private String printCoop;
        private String printNoCoop;
        private String marketingCoop;
        private String marketingNoCoop;
        private String salesCoop;
        private String salesNoCoop;

        public ReportDataBuilder writing(String writing) {
            this.writing = writing;
            return this;
        }

        public ReportDataBuilder editing(String editing) {
            this.editing = editing;
            return this;
        }

        public ReportDataBuilder formatCoop(String formatCoop) {
            this.formatCoop = formatCoop;
            return this;
        }

        public ReportDataBuilder formatNoCoop(String formatNoCoop) {
            this.formatNoCoop = formatNoCoop;
            return this;
        }

        public ReportDataBuilder printCoop(String printCoop) {
            this.printCoop = printCoop;
            return this;
        }

        public ReportDataBuilder printNoCoop(String printNoCoop) {
            this.printNoCoop = printNoCoop;
            return this;
        }

        public ReportDataBuilder marketingCoop(String marketingCoop) {
            this.marketingCoop = marketingCoop;
            return this;
        }

        public ReportDataBuilder marketingNoCoop(String marketingNoCoop) {
            this.marketingNoCoop = marketingNoCoop;
            return this;
        }

        public ReportDataBuilder salesCoop(String salesCoop) {
            this.salesCoop = salesCoop;
            return this;
        }

        public ReportDataBuilder salesNoCoop(String salesNoCoop) {
            this.salesNoCoop = salesNoCoop;
            return this;
        }

        public ReportData build() {
            return new ReportData(this);
        }
    }

    public String getWriting() {
        return writing;
    }

    public String getEditing() {
        return editing;
    }

    public String getFormatCoop() {
        return formatCoop;
    }

    public String getFormatNoCoop() {
        return formatNoCoop;
    }

    public String getPrintCoop() {
        return printCoop;
    }

    public String getPrintNoCoop() {
        return printNoCoop;
    }

    public String getMarketingCoop() {
        return marketingCoop;
    }

    public String getMarketingNoCoop() {
        return marketingNoCoop;
    }

    public String getSalesCoop() {
        return salesCoop;
    }

    public String getSalesNoCoop() {
        return salesNoCoop;
    }
}
