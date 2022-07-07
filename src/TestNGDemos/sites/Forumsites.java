package TestNGDemos.sites;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Forumsites {

    WebDriver driver;
    @BeforeClass  // method written below this annotation will run before first test method of the class
    public void openBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @AfterClass  // method written below this annotation will run after last test method of the class
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(4000);
        driver.close();
    }

    @Test
    public void stackoverflow()
    {
        driver.get("https://stackoverflow.com/");
    }

    @Test
    public void sqaforums()
    {
        driver.get("http://www.sqaforums.com/");
        Assert.assertEquals(true,false,"sqaforums test is failed");
    }

    @Test
    public void w3schools()
    {
        driver.get("https://w3schools.com/");
    }

    @Test
    public void groupsGoogle()
    {
        driver.get("https://groups.google.com/");
    }
}
