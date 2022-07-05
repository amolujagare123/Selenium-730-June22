package AssertionDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class LoginDemo {

    @Test (enabled = false)
    public void loginTest1()
    {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();

        driver.get("https://stock.amolujagare.com/");

        WebElement txtUserName = driver.findElement(By.cssSelector("input#login-username"));
        txtUserName.sendKeys("admin");

        WebElement txtPass = driver.findElement(By.cssSelector("input[type=password]"));
        txtPass.sendKeys("admin1");

        WebElement btnLogin = driver.findElement(By.cssSelector("input[value='LOG IN']"));
        btnLogin.click();

       /* String expected = "POSNIC - Dashboard";
        String actual = driver.getTitle();*/


       /* String expected = "https://stock.amolujagare.com/dashboard.php";
        String actual = driver.getCurrentUrl();*/

        String expected = "Dashboard";
        String actual = "";
        try {
             actual = driver.findElement(By.xpath("//a[@class='active-tab dashboard-tab']")).getText();
        }
        catch (Exception e)
        {

        }

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);


        Assert.assertEquals(actual,expected,"this is not a dashboard");


    }

    @Test (enabled = false)
    public void loginTest2() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();

        driver.get("https://stock.amolujagare.com/");

        WebElement txtUserName = driver.findElement(By.cssSelector("input#login-username"));
        txtUserName.sendKeys("admin1");

        WebElement txtPass = driver.findElement(By.cssSelector("input[type=password]"));
        txtPass.sendKeys("admin1");

        WebElement btnLogin = driver.findElement(By.cssSelector("input[value='LOG IN']"));
        btnLogin.click();

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


        Assert.assertEquals(actual,expected,"incorrect error message or error message is absent");


    }


    @Test
    public void loginTest3() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();

        driver.get("https://stock.amolujagare.com/");

        WebElement txtUserName = driver.findElement(By.cssSelector("input#login-username"));
        txtUserName.sendKeys("");

        WebElement txtPass = driver.findElement(By.cssSelector("input[type=password]"));
        txtPass.sendKeys("");

        WebElement btnLogin = driver.findElement(By.cssSelector("input[value='LOG IN']"));
        btnLogin.click();


      /*  ArrayList<String> expected = new ArrayList<>();
        expected.add("Please enter a username");
        expected.add("Please provide a password");*/




        ArrayList<String> expected = new ArrayList<>(){{
            add("PLEASE ENTER A USERNAME");
            add("PLEASE PROVIDE A PASSWORD");
        }};

        List<WebElement> msgList = driver.findElements(By.cssSelector("label.error"));

        ArrayList<String> actual = new ArrayList<>()
        {{
            add(msgList.get(0).getText());
            add(msgList.get(1).getText());
        }};

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expected,"incorrect error message or error message is absent");


    }
}
