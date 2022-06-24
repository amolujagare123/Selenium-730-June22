package basicMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasicMethods {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
      //  driver.manage().window().fullscreen();

        driver.get("http://facebook.com");

        driver.navigate().to("http://gmail.com");

        //Thread.sleep(4000);

        driver.navigate().back();
       // Thread.sleep(4000);

        driver.navigate().forward();

       // Thread.sleep(4000);
        driver.navigate().refresh();

    }
}
