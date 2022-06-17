import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginDemoGuru99 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/v4/");

        WebElement txtUsername = driver.findElement(By.name("uid"));
        txtUsername.sendKeys("mngr401011");

        WebElement txtPassword = driver.findElement(By.name("password"));
        txtPassword.sendKeys("EbasygY");

        WebElement btnLogin = driver.findElement(By.name("btnLogin"));
        btnLogin.click();

    /*    driver.findElement(By.linkText("New Customer")).click();

        driver.navigate().refresh();

        driver.findElement(By.linkText("New Customer")).click();*/

    }
}
