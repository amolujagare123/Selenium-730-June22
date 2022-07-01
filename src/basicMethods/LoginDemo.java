package basicMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginDemo {


    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://stock.amolujagare.com/");

        WebElement txtUserName = driver.findElement(By.id("login-username"));
        txtUserName.sendKeys("admin");

        WebElement txtPass = driver.findElement(By.id("login-password"));
        txtPass.sendKeys("admin");

        WebElement btnLogin = driver.findElement(By.name("submit"));
        btnLogin.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

        WebElement lnkAddCustomer = driver.findElement(By.xpath("//a[normalize-space()='Add Customer']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",lnkAddCustomer);

        driver.findElement(By.name("name")).sendKeys("shalini");
        driver.findElement(By.name("address")).sendKeys("xyz , pqr india");
        driver.findElement(By.name("contact1")).sendKeys("78787878");
        driver.findElement(By.name("contact2")).sendKeys("18787878");

        driver.findElement(By.name("Submit")).click();

    }
}
