package worksheetDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLogin {

	static WebDriver  driver;
	
	public static void initailizemethod()
	
	{
		
		 System.setProperty("webdriver.chrome.driver", "C:\\Sunit\\Drivers\\chromedriver.exe");
		  
		  driver = new ChromeDriver(); 
		  
		  driver.get("https://stackoverflow.com/users/login?ssrc=head");

		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  
		  driver.manage().window().maximize();
		  
	}
	
	public static void TestLoginMethod(String luid, String lpwd) throws Exception
	{
		
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
	
	public static void close() throws InterruptedException
	
	{
		
		  Thread.sleep(4000);
		  
		  driver.close();
	}
	
	
	
}
