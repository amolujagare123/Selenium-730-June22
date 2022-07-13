package DataProviderDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;


public class LoginExcelXHeaders {

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
    public Object[][] getData() throws IOException {

        // 1. read the file
       // FileInputStream fis = new FileInputStream("Data/MyDataX.xlsx");
        FileInputStream fis = new FileInputStream("Data/MyDataXX-2.xlsx");
        // 2. convert this file object into a workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        // 3. pick up the sheet where the data is
        XSSFSheet sheet = workbook.getSheet("Sheet2");
        // 4. count the active rows in this sheet
        int rowCount = sheet.getPhysicalNumberOfRows();

        Object[][] data = new Object[rowCount-1][2];
        for(int i=0;i<rowCount-1;i++)
        {
            XSSFRow row = sheet.getRow(i+1); //1

            XSSFCell cellUsername = row.getCell(0); // admin
            if (cellUsername==null)
                data[i][0] = ""; // data[1][0]
           else
                data[i][0] = cellUsername.toString();

            XSSFCell cellPassword = row.getCell(1); // admin
            if (cellPassword==null)
                data[i][1] = ""; // data[1][1]
            else
                 data[i][1] = cellPassword.toString();
        }
        return data;
    }
}
