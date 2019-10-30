package pl.codinglab.treetable.model;

public class EntireData {

    private String entireWriting;
    private String entireEditing;
    private String entireFormatCoop;
    private String entireFormatNoCoop;
    private String entirePrintCoop;
    private String entirePrintNoCoop;
    private String entireMarketingCoop;
    private String entireMarketingNoCoop;
    private String entireSalesCoop;
    private String entireSalesNoCoop;

    public EntireData(EntireDataBuilder builder) {
        this.entireWriting = builder.entireWriting;
        this.entireEditing = builder.entireEditing;
        this.entireFormatCoop = builder.entireFormatCoop;
        this.entireFormatNoCoop = builder.entireFormatNoCoop;
        this.entirePrintCoop = builder.entirePrintCoop;
        this.entirePrintNoCoop = builder.entirePrintNoCoop;
        this.entireMarketingCoop = builder.entireMarketingCoop;
        this.entireMarketingNoCoop = builder.entireMarketingNoCoop;
        this.entireSalesCoop = builder.entireSalesCoop;
        this.entireSalesNoCoop = builder.entireSalesNoCoop;
    }

    public static class EntireDataBuilder {
        private String entireWriting;
        private String entireEditing;
        private String entireFormatCoop;
        private String entireFormatNoCoop;
        private String entirePrintCoop;
        private String entirePrintNoCoop;
        private String entireMarketingCoop;
        private String entireMarketingNoCoop;
        private String entireSalesCoop;
        private String entireSalesNoCoop;


        public EntireDataBuilder entireWriting(String entireWriting) {
            this.entireWriting = entireWriting;
            return this;
        }

        public EntireDataBuilder entireEditing(String entireEditing) {
            this.entireEditing = entireEditing;
            return this;
        }

        public EntireDataBuilder entireFormatCoop(String entireFormatCoop) {
            this.entireFormatCoop = entireFormatCoop;
            return this;
        }

        public EntireDataBuilder entireFormatNoCoop(String entireFormatNoCoop) {
            this.entireFormatNoCoop = entireFormatNoCoop;
            return this;
        }

        public EntireDataBuilder entirePrintCoop(String entirePrintCoop) {
            this.entirePrintCoop = entirePrintCoop;
            return this;
        }

        public EntireDataBuilder entirePrintNoCoop(String entirePrintNoCoop) {
            this.entirePrintNoCoop = entirePrintNoCoop;
            return this;
        }

        public EntireDataBuilder entireMarketingCoop(String entireMarketingCoop) {
            this.entireMarketingCoop = entireMarketingCoop;
            return this;
        }

        public EntireDataBuilder entireMarketingNoCoop(String entireMarketingNoCoop) {
            this.entireMarketingNoCoop = entireMarketingNoCoop;
            return this;
        }

        public EntireDataBuilder entireSalesCoop(String entireSalesCoop) {
            this.entireSalesCoop = entireSalesCoop;
            return this;
        }

        public EntireDataBuilder entireSalesNoCoop(String entireSalesNoCoop) {
            this.entireSalesNoCoop = entireSalesNoCoop;
            return this;
        }

        public EntireData build() {
            return new EntireData(this);
        }
    }

    public String getEntireWriting() {
        return entireWriting;
    }

    public String getEntireEditing() {
        return entireEditing;
    }

    public String getEntireFormatCoop() {
        return entireFormatCoop;
    }

    public String getEntireFormatNoCoop() {
        return entireFormatNoCoop;
    }

    public String getEntirePrintCoop() {
        return entirePrintCoop;
    }

    public String getEntirePrintNoCoop() {
        return entirePrintNoCoop;
    }

    public String getEntireMarketingCoop() {
        return entireMarketingCoop;
    }

    public String getEntireMarketingNoCoop() {
        return entireMarketingNoCoop;
    }

    public String getEntireSalesCoop() {
        return entireSalesCoop;
    }

    public String getEntireSalesNoCoop() {
        return entireSalesNoCoop;
    }
}
