package pl.codinglab.treetable.util;

import pl.codinglab.treetable.model.BookPublishingReport;
import pl.codinglab.treetable.model.EntireData;
import pl.codinglab.treetable.model.Provider;
import pl.codinglab.treetable.model.ReportData;

import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestdataGenerator {

    private static ResourceBundle rb = ResourceBundle.getBundle("default");

    private TestdataGenerator() {
    }

    public static List<Provider> createProviders() {
        Provider steinwayBrad = createProvider("bookpublishreport.provider1");
        Provider biblos = createProvider("bookpublishreport.provider2");
        Provider blackUnicorn = createProvider("bookpublishreport.provider3");
        Provider bookForYou = createProvider("bookpublishreport.provider4");
        Provider ateneum = createProvider("bookpublishreport.provider5");
        Provider publishMe = createProvider("bookpublishreport.provider6");
        return Arrays.asList(steinwayBrad, biblos, blackUnicorn, bookForYou, ateneum, publishMe);
    }

    public static BookPublishingReport createBonusReport() {
        return new BookPublishingReport.BookPublishingReportBuilder()
                .controlBlocks(createProviders())
                .reportDataProControlBlock(createReportDataProControlBlock())
                .entireData(createEntireData())
                .build();
    }

    private static EntireData createEntireData() {
        return new EntireData.EntireDataBuilder()
                .entireWriting(bdValue(1406))
                .entireEditing(bdValue(532))
                .entireFormatCoop(bdValue(563))
                .entireFormatNoCoop(bdValue(1041.26))
                .entirePrintCoop(bdValue(141.47))
                .entirePrintNoCoop(bdValue(126.78))
                .entireMarketingCoop(bdValue(238.27))
                .entireMarketingNoCoop(bdValue(236.63))
                .entireSalesCoop(bdValue(233.33))
                .entireSalesNoCoop(bdValue(362.98))
                .build();
    }

    private static Map<Provider, ReportData> createReportDataProControlBlock() {
        return Collections.unmodifiableMap(Stream.of(
                new AbstractMap.SimpleEntry<>(createProvider("bookpublishreport.provider1"), createReportDataSteinwayBrad()),
                new AbstractMap.SimpleEntry<>(createProvider("bookpublishreport.provider2"), createReportDataBiblos()),
                new AbstractMap.SimpleEntry<>(createProvider("bookpublishreport.provider3"), createReportDaataBlackUnicorn()),
                new AbstractMap.SimpleEntry<>(createProvider("bookpublishreport.provider4"), createReportDataBookForYou()),
                new AbstractMap.SimpleEntry<>(createProvider("bookpublishreport.provider5"), createReportDataAteneum()),
                new AbstractMap.SimpleEntry<>(createProvider("bookpublishreport.provider6"), createReportDataPublishMe()))
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(ReportData::getWriting).reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new)));
    }

    private static ReportData createReportDataSteinwayBrad() {
        return new ReportData.ReportDataBuilder()
                .writing(bdValue(620))
                .editing(bdValue(186))
                .formatCoop(bdValue(174))
                .formatNoCoop(bdValue(620))
                .printCoop(bdValue(25.68))
                .printNoCoop(bdValue(24.31))
                .marketingCoop(bdValue(62.63))
                .marketingNoCoop(bdValue(61.00))
                .salesCoop(bdValue(64.25))
                .salesNoCoop(bdValue(87.11))
                .build();
    }

    private static ReportData createReportDataBiblos() {
        return new ReportData.ReportDataBuilder()
                .writing(bdValue(563))
                .editing(bdValue(161))
                .formatCoop(bdValue(150))
                .formatNoCoop(bdValue(150))
                .printCoop(bdValue(27.88))
                .printNoCoop(bdValue(22.31))
                .marketingCoop(bdValue(42.63))
                .marketingNoCoop(bdValue(41.23))
                .salesCoop(bdValue(61.15))
                .salesNoCoop(bdValue(77.31))
                .build();
    }

    private static ReportData createReportDaataBlackUnicorn() {
        return new ReportData.ReportDataBuilder()
                .writing(bdValue(122))
                .editing(bdValue(102))
                .formatCoop(bdValue(144))
                .formatNoCoop(bdValue(134))
                .printCoop(bdValue(23.85))
                .printNoCoop(bdValue(21.78))
                .marketingCoop(bdValue(35.32))
                .marketingNoCoop(bdValue(41.42))
                .salesCoop(bdValue(34.21))
                .salesNoCoop(bdValue(67.57))
                .build();
    }

    private static ReportData createReportDataPublishMe() {
        return new ReportData.ReportDataBuilder()
                .writing(bdValue(21))
                .editing(bdValue(20))
                .formatCoop(bdValue(17))
                .formatNoCoop(bdValue(15))
                .printCoop(bdValue(21.36))
                .printNoCoop(bdValue(25.65))
                .marketingCoop(bdValue(21.35))
                .marketingNoCoop(bdValue(35.12))
                .salesCoop(bdValue(21.34))
                .salesNoCoop(bdValue(37.97))
                .build();
    }

    private static ReportData createReportDataAteneum() {
        return new ReportData.ReportDataBuilder()
                .writing(bdValue(25))
                .editing(bdValue(18))
                .formatCoop(bdValue(20))
                .formatNoCoop(bdValue(24.26))
                .printCoop(bdValue(21.45))
                .printNoCoop(bdValue(21.45))
                .marketingCoop(bdValue(45.12))
                .marketingNoCoop(bdValue(12.34))
                .salesCoop(bdValue(27.97))
                .salesNoCoop(bdValue(35.45))
                .build();
    }

    private static ReportData createReportDataBookForYou() {
        return new ReportData.ReportDataBuilder()
                .writing(bdValue(55))
                .editing(bdValue(45))
                .formatCoop(bdValue(58))
                .formatNoCoop(bdValue(98))
                .printCoop(bdValue(21.25))
                .printNoCoop(bdValue(11.28))
                .marketingCoop(bdValue(31.22))
                .marketingNoCoop(bdValue(45.52))
                .salesCoop(bdValue(24.41))
                .salesNoCoop(bdValue(57.57))
                .build();
    }

    private static Provider createProvider(String s) {
        return new Provider(rb.getString(s));
    }

    private static String bdValue(int i) {
        NumberFormat euroFormat = getEuroFormat();
        euroFormat.setMaximumFractionDigits(0);
        return euroFormat.format(i);
    }

    private static String bdValue(double i) {
        NumberFormat euroFormat = getEuroFormat();
        euroFormat.setMaximumFractionDigits(2);
        euroFormat.setRoundingMode(RoundingMode.HALF_UP);
        return euroFormat.format(i);
    }

    private static NumberFormat getEuroFormat() {
        return NumberFormat.getInstance(Locale.GERMANY);
    }
}
