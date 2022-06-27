package xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenClinic {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://openclinic.sourceforge.net/openclinic/admin/staff_list.php");


        String user = "Prakash";

        driver.findElement(By.xpath("//tr[td[text()='"+user+"']]//img[@alt='edit']")).click();


    }
}
