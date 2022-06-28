package xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ViewCustomers2 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://localhost/ip");

        WebElement txtUserName = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        txtUserName.sendKeys("amolujagare@gmail.com");

        WebElement txtPass = driver.findElement(By.xpath("//input[@id='password']"));
        txtPass.sendKeys("admin123");

        WebElement btnLogin = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        btnLogin.click();

        driver.findElement(By.xpath("//span[normalize-space()='Clients']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='View Clients']")).click();


        String name="Ajay Singh";
        driver.findElement(By.xpath("//tr[td/a[text()='"+name+"'] ]//div")).click();

        //tr[td/a[text()='Ajay Singh']]//li[2]

        //tr[td/a[text()='Ajay Singh'] ]//a[contains(@href,'form')]

        //tr[td/a[text()='Ajay Singh'] ]//i[contains(@class,'edit')]

        driver.findElement(By.xpath("//tr[td/a[text()='"+name+"'] ]//a[contains(@href,'form')]")).click();




    }
}
