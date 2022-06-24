package xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginWithXpath {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://stock.amolujagare.com/");

        WebElement txtUserName = driver.findElement(By.xpath("//input[@id='login-username']"));
        txtUserName.sendKeys("admin");

        WebElement txtPass = driver.findElement(By.xpath("//input[@type='password']"));
        txtPass.sendKeys("admin");

        WebElement btnLogin = driver.findElement(By.xpath("//input[@type='submit']"));
        btnLogin.click();

        //driver.findElement(By.xpath("//a[@href='add_customer.php']")).click();
        driver.findElement(By.xpath("//a[text()='Add Customer']")).click();

       driver.findElement(By.xpath("//input[@name='name']")).sendKeys("shalini");
        driver.findElement(By.xpath("//textarea")).sendKeys("xyz , pqr india");
        driver.findElement(By.xpath("//input[@name='contact1']")).sendKeys("78787878");
        driver.findElement(By.xpath("//input[@name='contact2']")).sendKeys("18787878");

        driver.findElement(By.xpath("//input[@value='Add']")).click();

    }
}
