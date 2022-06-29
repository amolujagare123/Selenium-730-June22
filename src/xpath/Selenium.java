package xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/v4");
		driver.findElement(By.name("uid")).sendKeys("mngr401011");
		driver.findElement(By.name("password")).sendKeys("EbasygY");
		driver.findElement(By.name("btnLogin")).submit();
		
		//Thread.sleep(3000);

	}

}