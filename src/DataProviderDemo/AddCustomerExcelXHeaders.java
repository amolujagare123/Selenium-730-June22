package DataProviderDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;


public class AddCustomerExcelXHeaders {
    WebDriver driver ;
    @BeforeClass
    public void doLogin()
    {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        driver.manage().window().maximize();

        driver.get("https://stock.amolujagare.com/");

        WebElement txtUserName = driver.findElement(By.cssSelector("input#login-username"));
        txtUserName.sendKeys("admin");

        WebElement txtPass = driver.findElement(By.cssSelector("input[type=password]"));
        txtPass.sendKeys("admin");

        WebElement btnLogin = driver.findElement(By.cssSelector("input[value='LOG IN']"));
        btnLogin.click();
    }

    @Test (dataProvider = "getData")
    public void addCustomerTest(String name,String address,String contact1,String contact2)
    {
        WebElement lnkAddCustomer = driver.findElement(By.xpath("//a[normalize-space()='Add Customer']"));

       /* JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",lnkAddCustomer);*/

        lnkAddCustomer.click();

        driver.findElement(By.name("name")).sendKeys(name);
        driver.findElement(By.name("address")).sendKeys(address);
        driver.findElement(By.name("contact1")).sendKeys(contact1);
        driver.findElement(By.name("contact2")).sendKeys(contact2);

        driver.findElement(By.name("Submit")).click();
    }





    @DataProvider
    public Object[][] getData() throws IOException {

        // 1. read the file
       // FileInputStream fis = new FileInputStream("Data/MyDataX.xlsx");
        FileInputStream fis = new FileInputStream("Data/MyDataXX-2.xlsx");
        // 2. convert this file object into a workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        // 3. pick up the sheet where the data is
        XSSFSheet sheet = workbook.getSheet("Add customer");
        // 4. count the active rows in this sheet
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount-1][colCount];
        for(int i=0;i<rowCount-1;i++)
        {
            XSSFRow row = sheet.getRow(i+1);

            XSSFCell cellName = row.getCell(0);
            if (cellName==null)
                data[i][0]="";
            else
                data[i][0]=cellName.toString();

            XSSFCell cellAddress = row.getCell(1);
            if (cellAddress==null)
                data[i][1]="";
            else
                data[i][1]=cellAddress.toString();

            XSSFCell cellContact1 = row.getCell(2);
            if (cellContact1==null)
                data[i][2]="";
            else
                data[i][2]=cellContact1.toString();

            XSSFCell cellContact2 = row.getCell(3);
            if (cellContact2==null)
                data[i][3]="";
            else
                data[i][3]=cellContact2.toString();


        }
        return data;
    }
}
