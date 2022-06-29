package xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ViewCustomers {

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


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        driver.findElement(By.xpath("//a[normalize-space()='Add Customer']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='View Customers']")).click();


        String name="shalini";
        driver.findElement(By.xpath("//tr[td[text()='"+name+"']]//input")).click();



    }
}
