package ExtentReportDemo.Screenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ForExtentReport {

    public static String screenshotForReport(WebDriver driver) throws IOException {
        // 1. create the object reference of TakesScreenshot say ts
        // assign the current driver to it, cast driver to TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;

        // 2. call the getScreenshotAs() Method, it will give us the
        // screenshot in file format
        File scrFile = ts.getScreenshotAs(OutputType.FILE);

        String timeStamp = new SimpleDateFormat("_yyyyddMM_hhmmss").format(new Date());
        String fileName = "IMG"+timeStamp+".png";

        // 3. copy this file object into a real image file
        FileUtils.copyFile(scrFile,new File("Report\\screenshots\\"+fileName));

        return fileName;
    }

    public static ExtentReports init()
    {
        ExtentSparkReporter reporter = new ExtentSparkReporter("Report\\report.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);

        reporter.config().setReportName("Regression Testing Report");
        reporter.config().setDocumentTitle("Stock Management Project");

        extent.setSystemInfo("Developers Name","Ayushee");
        extent.setSystemInfo("Testers Name","Pallavi");
        extent.setSystemInfo("Project Domain","ERP");
        extent.setSystemInfo("Client Name","tata steel");
        extent.setSystemInfo("Project Dead line","7-8-2022");

        return extent;
    }

}
