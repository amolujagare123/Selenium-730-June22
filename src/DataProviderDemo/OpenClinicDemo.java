package DataProviderDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static DataProviderDemo.util.GetMyData.gettingData;

public class OpenClinicDemo {
    WebDriver driver;
    @BeforeClass
    public void openbrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test(dataProvider = "getData")
    public void addUser(String TIN,String firstname,String surname1,String surname2,String address,String phone,String login)
    {
        driver.get("http://openclinic.sourceforge.net/openclinic/admin/staff_new_form.php?type=A");

        driver.findElement(By.xpath("//input[@id='nif']")).sendKeys(TIN);
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys(firstname);
        driver.findElement(By.xpath("//input[@id='surname1']")).sendKeys(surname1);
        driver.findElement(By.xpath("//input[@id='surname2']")).sendKeys(surname2);
        driver.findElement(By.xpath("//textarea[@id='address']")).sendKeys(address);
        driver.findElement(By.xpath("//textarea[@id='phone_contact']")).sendKeys(phone);
        driver.findElement(By.xpath("//input[@id='login']")).sendKeys(login);
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        return gettingData("Data/MyDataXX-2.xlsx","Add clinic user");
    }
}
