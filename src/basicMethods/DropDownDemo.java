package basicMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("file:///D:/amol.html");

        WebElement drpSelText = driver.findElement(By.id("seltext"));

        Select selElement = new Select(drpSelText);

        Thread.sleep(4000);
       // selElement.selectByVisibleText("text 4");

       // selElement.selectByIndex(2);

        selElement.selectByValue("v13");



    }
}
