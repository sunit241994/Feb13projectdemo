package worksheetDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DataProvider {
	
	  FileInputStream fis; 
	  
	  XSSFWorkbook wb;
	  
	  XSSFSheet sh1;
	
	  static  WebDriver driver;
	  
	  @BeforeClass
		public static void initailizemethod()
		
		{
			
			 System.setProperty("webdriver.chrome.driver", "C:\\Sunit\\Drivers\\chromedriver.exe");
			  
			  driver = new ChromeDriver(); 
			  
			  driver.get("https://stackoverflow.com/users/login?ssrc=head");

			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  
			  
			  driver.manage().window().maximize();
			  
		}
		
	  
  @Test(dataProvider = "sampledata")
  public void dataProviderDemo(String luid, String lpwd) throws IOException, InterruptedException {
  

	  WebElement e = driver.findElement(By.id("email"));
	  
	  e.clear();
	  e.sendKeys(luid);
	  
	  Thread.sleep(2000);
	  WebElement pass = driver.findElement(By.id("password")); 
	  
	 
	  pass.sendKeys(lpwd);
	  
	  Thread.sleep(2000);
	  
	  WebElement submit = driver.findElement(By.id("submit-button")); 
	  
	  submit.submit();
	  
	  Thread.sleep(2000);
  
  }
  
  
  
  
  @org.testng.annotations.DataProvider(name = "sampledata")
  public Object[][] TestData() throws Exception
  {
	  
	  
	  String Location = "C:\\Users\\Training_H1B.06.15\\Desktop\\DemoExcel.xlsx"; 
		 
	   fis = new FileInputStream(Location); 
	  
	   wb = new XSSFWorkbook(fis);
	  
	   sh1 = wb.getSheetAt(0);
	  
	  // Getting the Maximum number of rows
	  int rows = sh1.getLastRowNum(); 
	  
	  
	  // Increasing the count: 

	  int totalcnt = rows + 1; 
	  
	  Object[][] data = new Object[totalcnt][2];
	  
	  for(int i=1;i<totalcnt-1;i++)
	  {
		  
		  data[i][0] = sh1.getRow(i).getCell(0).getStringCellValue(); 
	  
		  data[i][1] = sh1.getRow(i).getCell(1).getStringCellValue();
	  }
	  
	  return data;
	 
  }
  
  
  	@AfterClass
	public static void close() throws InterruptedException
	
	{
		
		  Thread.sleep(4000);
		  
		  driver.close();
	}
	
  
}
