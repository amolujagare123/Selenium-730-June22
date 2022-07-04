package AssertionDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ChatLoginDemo {

    @Test
    public void loginTest1()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://chat.cookingwithamol.in/index.php/site_admin/user/login");

        WebElement txtUserName = driver.findElement(By.cssSelector("input[name='Username']"));
        txtUserName.sendKeys("admin");

        WebElement txtPass = driver.findElement(By.cssSelector("input[name='Password']"));
        txtPass.sendKeys("admin123");

        WebElement btnLogin = driver.findElement(By.cssSelector("input[value='Login']"));
        btnLogin.click();

      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

        driver.navigate().refresh();
        String expected = "https://stock.amolujagare.com/dashboard.php";
        String actual = driver.getCurrentUrl();

        Assert.assertEquals(actual,expected,"this is not a dashboard");
    }
}
