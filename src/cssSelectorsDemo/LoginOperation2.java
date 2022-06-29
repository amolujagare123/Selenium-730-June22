package cssSelectorsDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginOperation2 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

       // driver.get("https://stock.amolujagare.com/");

        WebElement txtUserName = driver.findElement(By.cssSelector("input#login-username"));
        txtUserName.sendKeys("admin");

        WebElement txtPass = driver.findElement(By.cssSelector("input[type=password]"));
        txtPass.sendKeys("admin");

        WebElement btnLogin = driver.findElement(By.cssSelector("input[value='LOG IN']"));
        btnLogin.click();


        WebDriverManager.chromedriver().setup();
        WebDriver driver1 = new ChromeDriver();

        driver1.manage().window().maximize();

        driver1.get("https://stock.amolujagare.com/");

        WebElement txtUserName1 = driver1.findElement(By.cssSelector("input#login-username"));
        txtUserName1.sendKeys("rrere");

        WebElement txtPass1 = driver1.findElement(By.cssSelector("input[type=password]"));
        txtPass1.sendKeys("rerere");

        WebElement btnLogin1 = driver1.findElement(By.cssSelector("input[value='LOG IN']"));
        btnLogin1.click();


        WebDriverManager.chromedriver().setup();
        WebDriver driver2 = new ChromeDriver();

        driver2.manage().window().maximize();

        driver2.get("https://stock.amolujagare.com/");

        WebElement txtUserName2 = driver2.findElement(By.cssSelector("input#login-username"));
        txtUserName2.sendKeys("");

        WebElement txtPass2 = driver2.findElement(By.cssSelector("input[type=password]"));
        txtPass2.sendKeys("");

        WebElement btnLogin2 = driver2.findElement(By.cssSelector("input[value='LOG IN']"));
        btnLogin2.click();
    }
}
