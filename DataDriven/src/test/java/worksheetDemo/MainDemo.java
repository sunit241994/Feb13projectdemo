package worksheetDemo;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class MainDemo {
  @Test
  public void f() {
  }
  @BeforeClass
  public void initialize()
  {
	  
	  DataProvider.initailizemethod();
  }

  
   
  @AfterClass
  public void CleanUp() throws InterruptedException
	  
	  {
	
	  DataProvider.close();
		  
		  
	  }
  }
