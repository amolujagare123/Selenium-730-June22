package AssertionDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginDemo2 {

    @Test
    public void loginTest1()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://localhost/ip");

        WebElement txtUserName = driver.findElement(By.cssSelector("#email"));
        txtUserName.sendKeys("amolujagare@gmail.com");

        WebElement txtPass = driver.findElement(By.cssSelector("#password"));
        txtPass.sendKeys("admin123");

        WebElement btnLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        btnLogin.click();

        driver.findElement(By.xpath("//span[normalize-space()='Clients']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Add Client')]")).click();

     /* driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

        driver.navigate().refresh();
        String expected = "https://stock.amolujagare.com/dashboard.php";
        String actual = driver.getCurrentUrl();

        Assert.assertEquals(actual,expected,"this is not a dashboard");*/
    }
}
