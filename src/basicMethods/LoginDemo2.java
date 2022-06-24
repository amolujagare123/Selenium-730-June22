package basicMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LoginDemo2 {


    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://stock.amolujagare.com/");

        // driver.findElement(By.tagName("input"));
        // it will return the first element only-username

        List<WebElement> wbList = driver.findElements(By.tagName("input"));
        // it returns the list of web elements
        // represented by the given locator
        System.out.println("size="+wbList.size()); //3

        wbList.get(0).sendKeys("admin"); // username
        wbList.get(1).sendKeys("admin"); // password
        wbList.get(2).click(); // login button





    }
}
