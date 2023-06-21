package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

    public static ExtentReports getReportObject(){
        ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//reportsHtml//report.html");
        reporter.config().setReportName("Test Report");
        reporter.config().setDocumentTitle("ReportDoc");
        ExtentReports extentReporter = new ExtentReports();
        extentReporter.attachReporter(reporter);
        extentReporter.setSystemInfo("Tester","MarYan");
        return extentReporter;
    }
}
