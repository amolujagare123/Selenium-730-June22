package TestNGDemos.sites;

import TestNGDemos.sites.util.InitDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Forumsites extends InitDriver {



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
