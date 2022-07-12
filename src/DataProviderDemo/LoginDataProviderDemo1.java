package DataProviderDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LoginDataProviderDemo1 {

    @Test (dataProvider = "getData")
    public void loginTest1(String username,String password)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://stock.amolujagare.com/");

        WebElement txtUserName = driver.findElement(By.cssSelector("input#login-username"));
        txtUserName.sendKeys(username);

        WebElement txtPass = driver.findElement(By.cssSelector("input[type=password]"));
        txtPass.sendKeys(password);

        WebElement btnLogin = driver.findElement(By.cssSelector("input[value='LOG IN']"));
        btnLogin.click();
    }

    @DataProvider
    public Object[][] getData()
    {
        Object[][] data = new Object[6][2];

        data[0][0] ="admin";
        data[0][1] ="admin";

        data[1][0] ="user-1";
        data[1][1] ="pass-1";

        data[2][0] ="user-2";
        data[2][1] ="pass-2";

        data[3][0] ="user-3";
        data[3][1] ="pass-3";

        data[4][0] ="user-4";
        data[4][1] ="pass-4";

        data[5][0] ="user-5";
        data[5][1] ="pass-5";

        return data;
    }
}
