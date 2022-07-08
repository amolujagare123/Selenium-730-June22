package ExtentReportDemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static ExtentReportDemo.Screenshot.ForExtentReport.screenshotForReport;

public class ExtentReportDemo1 {


    ExtentReports extent;

    @BeforeClass
    public void init()
    {
        ExtentSparkReporter reporter = new ExtentSparkReporter("Report\\report.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);

        reporter.config().setReportName("Regression Testing Report");
        reporter.config().setDocumentTitle("Stock Management Project");

        extent.setSystemInfo("Developers Name","Ayushee");
        extent.setSystemInfo("Testers Name","Pallavi");
        extent.setSystemInfo("Project Domain","ERP");
        extent.setSystemInfo("Client Name","tata steel");
        extent.setSystemInfo("Project Dead line","7-8-2022");
    }

    @AfterClass
    public void writeToReport()
    {
        extent.flush();
    }


    @Test
    public void loginTest1() throws IOException {

        ExtentTest test = extent.createTest("valid login test");

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        test.info("browser is opened");

        driver.manage().window().maximize();

        test.info("browser is maximized");

        driver.get("https://stock.amolujagare.com/");

        test.info("url is opened");

        WebElement txtUserName = driver.findElement(By.cssSelector("input#login-username"));
        txtUserName.sendKeys("admin");

        test.info("username is entered");

        WebElement txtPass = driver.findElement(By.cssSelector("input[type=password]"));
        txtPass.sendKeys("admin1");

        test.info("password is entered");

        WebElement btnLogin = driver.findElement(By.cssSelector("input[value='LOG IN']"));
        btnLogin.click();

        test.info("login button is clicked");

        String expected = "https://stock.amolujagare.com/dashboard.php";
        String actual = driver.getCurrentUrl();

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        try {
            Assert.assertEquals(actual, expected, "incorrect error message or error message is absent");
            test.pass("login test is successfully passed");
        }
        catch (AssertionError e)
        {
            test.fail(e.getMessage());
            test.addScreenCaptureFromPath("./screenshots/"+screenshotForReport(driver));
        }

    }

    @Test
    public void loginTest2() throws IOException {

        ExtentTest test = extent.createTest("invalid login test");

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        test.info("browser is opened");

        driver.manage().window().maximize();

        test.info("browser is maximized");

        driver.get("https://stock.amolujagare.com/");

        test.info("url is opened");

        WebElement txtUserName = driver.findElement(By.cssSelector("input#login-username"));
        txtUserName.sendKeys("rerere");

        test.info("username is entered");

        WebElement txtPass = driver.findElement(By.cssSelector("input[type=password]"));
        txtPass.sendKeys("rererere");

        test.info("password is entered");

        WebElement btnLogin = driver.findElement(By.cssSelector("input[value='LOG IN']"));
        btnLogin.click();

        test.info("login button is clicked");

        String expected = "Wrong Username or Password";
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//div[@class='error-box round']")).getText();
        }
        catch (Exception e)
        {

        }
        System.out.println("expected="+expected);
        System.out.println("actual="+actual);


        try {
            Assert.assertEquals(actual, expected, "incorrect error message or error message is absent");
            test.pass("error message validation is successfully passed");
        }
        catch (AssertionError e)
        {
            test.fail(e.getMessage());
            test.addScreenCaptureFromPath("./screenshots/"+screenshotForReport(driver));
        }

    }
}
