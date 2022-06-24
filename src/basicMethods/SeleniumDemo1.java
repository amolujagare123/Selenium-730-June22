package basicMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class SeleniumDemo1 {

    public static void main(String[] args) {

      /*  System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();*/

        System.setProperty("webdriver.gecko.driver","Drivers/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();


     //   D:\Study\Selenium-730-June22\Drivers\geckodriver.exe - absolute path

    //    Drivers/geckodriver.exe - relative path

       /* System.setProperty("webdriver.opera.driver","Drivers/operadriver.exe");
        WebDriver driver = new OperaDriver();*/

     /*   System.setProperty("webdriver.edge.driver","Drivers/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();*/


    }
}
