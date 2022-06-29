package JunitDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginDemo {

    @Test
    public void loginTest1()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://stock.amolujagare.com/");

        WebElement txtUserName = driver.findElement(By.cssSelector("input#login-username"));
        txtUserName.sendKeys("admin");

        WebElement txtPass = driver.findElement(By.cssSelector("input[type=password]"));
        txtPass.sendKeys("admin");

        WebElement btnLogin = driver.findElement(By.cssSelector("input[value='LOG IN']"));
        btnLogin.click();
    }

    @Test
    public void loginTest2()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

       // driver.get("https://stock.amolujagare.com/");

        WebElement txtUserName = driver.findElement(By.cssSelector("input#login-username"));
        txtUserName.sendKeys("rere");

        WebElement txtPass = driver.findElement(By.cssSelector("input[type=password]"));
        txtPass.sendKeys("3434");

        WebElement btnLogin = driver.findElement(By.cssSelector("input[value='LOG IN']"));
        btnLogin.click();
    }

    @Test
    public void loginTest3()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://stock.amolujagare.com/");

        WebElement txtUserName = driver.findElement(By.cssSelector("input#login-username"));
        txtUserName.sendKeys("");

        WebElement txtPass = driver.findElement(By.cssSelector("input[type=password]"));
        txtPass.sendKeys("");

        WebElement btnLogin = driver.findElement(By.cssSelector("input[value='LOG IN']"));
        btnLogin.click();
    }
}
