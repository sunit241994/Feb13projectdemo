package worksheetDemo;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;

public class ExcelWorkbookDemo {
	
	  WebDriver driver; 
	  
	  String url = "http://uitestpractice.com/"; 
		
	  @BeforeClass
	  public void initialize()
	  {
		  
		  /*System.setProperty("webdriver.chrome.driver", "C:\\Sunit\\Drivers\\chromedriver.exe");
		  
		  driver = new ChromeDriver();
		  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
		  driver.manage().window().maximize()*/;
		  
		  TestLogin.initailizemethod();
	  }
	  
	  
		
	  @Test
	  public void workBook() throws Exception {
		  
		  // To get Excel File Location 
		  
		  String Location = "C:\\Users\\Training_H1B.06.15\\Desktop\\DemoExcel.xlsx"; 
		 
		  FileInputStream fis = new FileInputStream(Location); 
		  
		  XSSFWorkbook wb = new XSSFWorkbook(fis);
		  
		  
		  // To get the Sheet 
		  
		  XSSFSheet sheet = wb.getSheetAt(0); 
		  
		  
		  // To Get Row 
		  
		  String data1 = sheet.getRow(0).getCell(0).getStringCellValue(); 
		  
		 System.out.println("Cell 1  Value" +  data1);

		 
		 String data2 = sheet.getRow(1).getCell(1).getStringCellValue();
		 
		 System.out.println(" Cell 2 value" + data2);
	  
		  int rowno = sheet.getLastRowNum();
		 
		  rowno = rowno+1; 
		  
		 System.out.println("Number of Rows"+ rowno);
		 

		
		 
		 
		 for(int i = 0; i<rowno; i++)
			 
		 {
			 
			 String uid = sheet.getRow(i).getCell(0).getStringCellValue(); 
			 
			 String pwd = sheet.getRow(i).getCell(1).getStringCellValue();
			 
			 System.out.println(i + " Row User id" + uid);
			 
			 System.out.println(i + " Row pwd id" + pwd);
			 
			 
			TestLogin.TestLoginMethod(uid, pwd);
		 }
		 
		 wb.close();
		 
		 
		 
	  }
	  
	  
	  @AfterClass
	  public void CleanUp() throws InterruptedException
	  
	  {
	
		  TestLogin.close();
		  
		  
	  }
}



/*		 for(int rowIndex = 0; rowIndex<3; rowIndex++)
		 
	 {
		 
		 for (int columnIndex = 0; columnIndex<3; columnIndex++)
		 {
			 
			 XSSFCell cell= sheet.getRow(rowIndex).getCell(columnIndex);
			 
			 System.out.println("All Rows and Columns " + cell);
		 }
	 }
	 */
	 
	 /*		 	
	 List l = new ArrayList(); 
	 
	 String uid;

	 for(int i = 0; i<rowno; i++)
	 {
		 
		 uid = sheet.getRow(i).getCell(0).getStringCellValue();
		 
		 System.out.println(uid);
	 
		 l.add(uid);
	 }
	*/ 