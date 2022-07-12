package ExtentReportDemo.MyLisners;

import TestNGDemos.sites.util.InitDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import static ExtentReportDemo.Screenshot.ForExtentReport.init;
import static ExtentReportDemo.Screenshot.ForExtentReport.screenshotForReport;

public class ExtentReportListener extends InitDriver implements ITestListener {

    ExtentReports extent;
    ExtentTest test;

    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart");
        test = extent.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess");
        test.pass(result.getMethod().getMethodName()+
                ": this test is passed");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure");
        test.fail(result.getThrowable());
        try {
            test.addScreenCaptureFromPath("./screenshots/"+screenshotForReport(driver));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped");
        test.info("this test is skipped");
        test.skip(result.getThrowable());
        try {
            test.addScreenCaptureFromPath("./screenshots/"+screenshotForReport(driver));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void onStart(ITestContext context) {
        System.out.println("onStart");

        if(extent==null)
             extent = init();

    }

    public void onFinish(ITestContext context) {
        System.out.println("onFinish");
        extent.flush();
    }

}
