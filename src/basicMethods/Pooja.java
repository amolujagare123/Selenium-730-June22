package basicMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Pooja {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.amolujagare.com/");
        WebElement txtUserName = driver.findElement(By.id("login-username"));
        txtUserName.sendKeys("admin");
        WebElement txtPassword = driver.findElement(By.id("login-password"));
        txtPassword.sendKeys("admin");
        WebElement buttonlogin = driver.findElement(By.name("submit"));
        buttonlogin.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.findElement(By.linkText("Add Customer")).click();

        WebElement txtName = driver.findElement(By.id("name"));
        txtName.sendKeys("Pooja Bhojane");
        WebElement txtNum = driver.findElement(By.id("buyingrate"));
    }
}
