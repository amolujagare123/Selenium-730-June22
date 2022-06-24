package basicMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasicMethods3 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://gmail.com");

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());


    }
}
