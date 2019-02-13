package pageObjectModel;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class MainTest {
	
	WebDriver driver;
	
	pomDemo pm;

	  @BeforeClass
	  public void beforeClass() {
		  

			 System.setProperty("webdriver.chrome.driver", "C:\\Sunit\\Drivers\\chromedriver.exe");
			  
			  driver = new ChromeDriver(); 
			  
			  pm = new pomDemo(driver);
			  
			  driver.get("https://stackoverflow.com/users/login?ssrc=head");

			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  
			  driver.manage().window().maximize();
			  
			  System.out.println("Browser Maximized");
	  }

	
	@Test
  public void f() throws InterruptedException{
		
   Thread.sleep(3000);		

	pm.username("abc");
	
	 Thread.sleep(3000);	
	
	pm.pwd("123");
	
	pm.submit();
	
	}

  @AfterClass
  public void afterClass() throws InterruptedException {
 
	  Thread.sleep(4000);
	  
	  driver.close();

  }

}
