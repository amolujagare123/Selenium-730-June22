package AssertionDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddCustomer {

    @Test (enabled = false)
    public void addCustomerTest() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();

        driver.get("https://stock.amolujagare.com/");

        WebElement txtUserName = driver.findElement(By.cssSelector("input#login-username"));
        txtUserName.sendKeys("admin");

        WebElement txtPass = driver.findElement(By.cssSelector("input[type=password]"));
        txtPass.sendKeys("admin");

        WebElement btnLogin = driver.findElement(By.cssSelector("input[value='LOG IN']"));
        btnLogin.click();

        WebElement lnkAddCustomer = driver.findElement(By.xpath("//a[normalize-space()='Add Customer']"));
        lnkAddCustomer.click();

        String customerName =  "Deepthi";

        driver.findElement(By.name("name")).sendKeys(customerName);
        driver.findElement(By.name("address")).sendKeys("xyz , pqr india");
        driver.findElement(By.name("contact1")).sendKeys("78787878");
        driver.findElement(By.name("contact2")).sendKeys("18787878");

        driver.findElement(By.name("Submit")).click();


        String expected = "[ "+customerName+" ] Customer Details Added !";
        String actual = "";
        try {
             actual = driver.findElement(By.cssSelector(".confirmation-box")).getText();
        }
        catch (Exception e)
        {

        }

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);


        Assert.assertEquals(actual,expected,"incorrect  message or success msg is absent");




    }

    @Test
    public void addCustomerTest2() {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();

        driver.get("https://stock.amolujagare.com/");

        WebElement txtUserName = driver.findElement(By.cssSelector("input#login-username"));
        txtUserName.sendKeys("admin");

        WebElement txtPass = driver.findElement(By.cssSelector("input[type=password]"));
        txtPass.sendKeys("admin");

        WebElement btnLogin = driver.findElement(By.cssSelector("input[value='LOG IN']"));
        btnLogin.click();

        WebElement lnkAddCustomer = driver.findElement(By.xpath("//a[normalize-space()='Add Customer']"));
        lnkAddCustomer.click();

        String customerName =  "Yogesh";

        driver.findElement(By.name("name")).sendKeys(customerName);
        driver.findElement(By.name("address")).sendKeys("xyz , pqr india");
        driver.findElement(By.name("contact1")).sendKeys("78787878");
        driver.findElement(By.name("contact2")).sendKeys("18787878");

        driver.findElement(By.name("Submit")).click();


        String expected = "Customer Details Added";
        String actual = "";
        try {
            actual = driver.findElement(By.cssSelector(".confirmation-box")).getText();
        }
        catch (Exception e)
        {

        }

        boolean result = actual.contains(expected);


        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertTrue(result,"incorrect message or message absent");





    }
}
