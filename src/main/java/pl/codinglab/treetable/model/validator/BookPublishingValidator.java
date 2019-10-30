package pl.codinglab.treetable.model.validator;


import java.math.BigDecimal;

public class BookPublishingValidator {

    private static final BigDecimal MAX_ENTIRE_WRITING = BigDecimal.valueOf(1200);
    private static final BigDecimal MAX_ENTIRE_EDITING = BigDecimal.valueOf(1400);
    private static final BigDecimal MAX_ENTIRE_FORMAT_COOP = BigDecimal.valueOf(1200);
    private static final BigDecimal MAX_ENTIRE_FORMAT_NO_COOP = BigDecimal.valueOf(1400);
    private static final BigDecimal MAX_ENTIRE_PRINT_COOP = BigDecimal.valueOf(4000);
    private static final BigDecimal MAX_ENTIRE_PRINT_NO_COOP = BigDecimal.valueOf(4000);
    private static final BigDecimal MAX_ENTIRE_MARKETING_COOP = BigDecimal.valueOf(2500);
    private static final BigDecimal MAX_ENTIRE_MARKETING_NO_COOP = BigDecimal.valueOf(3000);
    private static final BigDecimal MAX_ENTIRE_SALES_COOP = BigDecimal.valueOf(2000);
    private static final BigDecimal MAX_ENTIRE_SALES_NO_COOP = BigDecimal.valueOf(2500);


    private static final BigDecimal MAX_WRITING = BigDecimal.valueOf(650);
    private static final BigDecimal MAX_EDITING = BigDecimal.valueOf(150);
    private static final BigDecimal MAX_FORMAT_COOP = BigDecimal.valueOf(140);
    private static final BigDecimal MAX_FORMAT_NO_COOP = BigDecimal.valueOf(500);
    private static final BigDecimal MAX_PRINT_COOP = BigDecimal.valueOf(24);
    private static final BigDecimal MAX_PRINT_NO_COOP = BigDecimal.valueOf(20);
    private static final BigDecimal MAX_MARKETING_COOP = BigDecimal.valueOf(65);
    private static final BigDecimal MAX_MARKETING_NO_COOP = BigDecimal.valueOf(60);
    private static final BigDecimal MAX_SALES_COOP = BigDecimal.valueOf(40);
    private static final BigDecimal MAX_SALES_NO_COOP = BigDecimal.valueOf(60);


    public boolean isEntireWritingCostValid(BigDecimal entireWriting) {
        return MAX_ENTIRE_WRITING.compareTo(entireWriting) >= 0;
    }

    public boolean isEntireEditingCostValid(BigDecimal entireEditing) {
        return MAX_ENTIRE_EDITING.compareTo(entireEditing) >= 0;
    }

    public boolean isEntireFormatCoopCostValid(BigDecimal entireFormatCoop) {
        return MAX_ENTIRE_FORMAT_COOP.compareTo(entireFormatCoop) >= 0;
    }

    public boolean isEntireFormatNoCoopCostValid(BigDecimal entireFormatNoCoop) {
        return MAX_ENTIRE_FORMAT_NO_COOP.compareTo(entireFormatNoCoop) >= 0;
    }

    public boolean isEntirePrintCoopCostValid(BigDecimal entirePrintCoop) {
        return MAX_ENTIRE_PRINT_COOP.compareTo(entirePrintCoop) >= 0;
    }

    public boolean isEntirePrintNoCoopCostValid(BigDecimal entirePrintNoCoop) {
        return MAX_ENTIRE_PRINT_NO_COOP.compareTo(entirePrintNoCoop) >= 0;
    }

    public boolean isEntireMarketingCoopCostValid(BigDecimal entireMarketingCoop) {
        return MAX_ENTIRE_MARKETING_COOP.compareTo(entireMarketingCoop) >= 0;
    }

    public boolean isEntireMarketingNoCoopCostValid(BigDecimal entireMarketingNoCoop) {
        return MAX_ENTIRE_MARKETING_NO_COOP.compareTo(entireMarketingNoCoop) >= 0;
    }

    public boolean isEntireSalesCoopCostValid(BigDecimal entireSalesCoop) {
        return MAX_ENTIRE_SALES_COOP.compareTo(entireSalesCoop) >= 0;
    }

    public boolean isEntireSalesNoCoopCostValid(BigDecimal entireSalesNoCoop) {
        return MAX_ENTIRE_SALES_NO_COOP.compareTo(entireSalesNoCoop) >= 0;
    }

    public boolean isWritingCostValid(BigDecimal writingCost) {
        return MAX_WRITING.compareTo(writingCost) >= 0;
    }

    public boolean isEditingCostValid(BigDecimal editingCost) {
        return MAX_EDITING.compareTo(editingCost) >= 0;
    }

    public boolean isFormatCoopCostValid(BigDecimal formatCoopCost) {
        return MAX_FORMAT_COOP.compareTo(formatCoopCost) >= 0;
    }

    public boolean isFormatNoCoopCostValid(BigDecimal formatNoCoopCost) {
        return MAX_FORMAT_NO_COOP.compareTo(formatNoCoopCost) >= 0;
    }

    public boolean isPrintCoopCostValid(BigDecimal printCoopCost) {
        return MAX_PRINT_COOP.compareTo(printCoopCost) >= 0;
    }

    public boolean isPrintNoCoopCostValid(BigDecimal printNoCoopCost) {
        return MAX_PRINT_NO_COOP.compareTo(printNoCoopCost) >= 0;
    }

    public boolean isMarketingCoopCostValid(BigDecimal marketingCoopCost) {
        return MAX_MARKETING_COOP.compareTo(marketingCoopCost) >= 0;
    }

    public boolean isMarketingNoCoopCostValid(BigDecimal marketingNoCoopCost) {
        return MAX_MARKETING_NO_COOP.compareTo(marketingNoCoopCost) >= 0;
    }

    public boolean isSalesCoopCostValid(BigDecimal salesCoopCost) {
        return MAX_SALES_COOP.compareTo(salesCoopCost) >= 0;
    }

    public boolean isSalesNoCoopCostValid(BigDecimal salesNoCoopCost) {
        return MAX_SALES_NO_COOP.compareTo(salesNoCoopCost) >= 0;
    }
}
