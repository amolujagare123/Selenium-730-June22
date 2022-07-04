package AssertionDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Guru99LoginDemo {

    @Test
    public void loginTest1()
    {
        //WebDriverManager.chromedriver().setup();

        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://demo.guru99.com/v4/");

        WebElement txtUserName = driver.findElement(By.cssSelector("input[name='uid']"));
        txtUserName.sendKeys("mngr401011");

        WebElement txtPass = driver.findElement(By.cssSelector("input[name='password']"));
        txtPass.sendKeys("EbasygY");

        WebElement btnLogin = driver.findElement(By.cssSelector("input[value='LOGIN']"));
        btnLogin.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

        driver.navigate().refresh();
        String expected = "https://demo.guru99.com/v4/manager/Managerhomepage.php";
        String actual = driver.getCurrentUrl();

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expected,"this is not a dashboard");
    }
}
