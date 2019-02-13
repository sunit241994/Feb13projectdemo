package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pomDemo {

	WebDriver driver;
	
	By userid = By.id("email");
	
	By pass = By.id("password");
	
	By submit = By.id("submit-button");
	
	
	
	public pomDemo(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	public void username(String uname)
	{
		
		WebElement e1 = driver.findElement(userid); 
		
		e1.sendKeys(uname);
	}
	
	public void pwd(String pwd)
	{
		
		WebElement e2 = driver.findElement(pass); 
		
		e2.sendKeys(pwd);
		
		
	}
	
	
	public void submit()
	{
		
		driver.findElement(submit);
	}
	
}
