package AppsTesting;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Sample4 
{
	@Test
	  public void f4()
	  {
		  System.out.println("--------------Main Test Method Started from Sample4 Class-------------------");
		  for(int i=0;i<5;i++)
		  {
			  System.out.println("This is Main Test Method from Sample4 Class");
		  }
		  System.out.println("--------------Main Test Method Ended from Sample3 Class-------------------");
	  }
	
	@AfterClass
	  public void afterClass()
	  {
		  System.out.println("--------------@AfterClass Started-------------------");
		  for(int i=0;i<5;i++)
		  {
			  System.out.println("This is @AfterClass");
		  }
		  System.out.println("--------------@AfterClass Ended-------------------");
	  }

	  
	  @AfterTest
	  public void afterTest() throws InterruptedException 
	  {
		  System.out.println("--------------@AfterTest Started-------------------");
		 // Thread.sleep(5000);
		  for(int i=0;i<5;i++)
		  {
			  
			  System.out.println("This is @AfterTest");
		  }
		  System.out.println("--------------@AfterTest Ended-------------------");
	  }

	 
	  @AfterSuite
	  public void afterSuite() 
	  {
		  System.out.println("--------------@AfterSuite Started-------------------");
		  for(int i=0;i<5;i++)
		  {
			  System.out.println("This is @AfterSuite");
		  }
		  System.out.println("--------------@AfterSuite Ended-------------------");
	  }
	  @AfterMethod
	  public void afterMethod() 
	  {
		  System.out.println("--------------@AfterMethod  from Sample2 class-------------------");
		  for(int i=0;i<5;i++)
		  {
			  System.out.println("This is @AfterMethod");
		  }
		  System.out.println("--------------@AfterMethod Ended from Sample2 class-------------------");
	  }


}
