package AppsTesting;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sample2 
{
	@Test
	  public void f()
	  {
		  System.out.println("--------------Main Test Method Started-------------------");
		  for(int i=0;i<10;i++)
		  {
			  System.out.println("This is Main Test Method");
		  }
		  System.out.println("--------------Main Test Method Ended-------------------");
	  }
	 @BeforeClass
	  public void beforeClass() 
	  {
		  System.out.println("--------------@BeforeClass Started-------------------");
		  for(int i=0;i<10;i++)
		  {
			  System.out.println("This is @BeforeClass");
		  }
		  System.out.println("--------------@BeforeClass Ended-------------------");
	  
	  }

	@AfterClass
	  public void afterClass()
	  {
		  System.out.println("--------------@AfterClass Started-------------------");
		  for(int i=0;i<10;i++)
		  {
			  System.out.println("This is @AfterClass");
		  }
		  System.out.println("--------------@AfterClass Ended-------------------");
	  }

	  
	  @AfterTest
	  public void afterTest() throws InterruptedException 
	  {
		  System.out.println("--------------@AfterTest Started-------------------");
		  Thread.sleep(5000);
		  for(int i=0;i<10;i++)
		  {
			  
			  System.out.println("This is @AfterTest");
		  }
		  System.out.println("--------------@AfterTest Ended-------------------");
	  }

	 
	  @AfterSuite
	  public void afterSuite() 
	  {
		  System.out.println("--------------@AfterSuite Started-------------------");
		  for(int i=0;i<10;i++)
		  {
			  System.out.println("This is @AfterSuite");
		  }
		  System.out.println("--------------@AfterSuite Ended-------------------");
	  }
	  @AfterMethod
	  public void afterMethod() 
	  {
		  System.out.println("--------------@AfterMethod  from Sample2 class-------------------");
		  for(int i=0;i<10;i++)
		  {
			  System.out.println("This is @AfterMethod from Sample2 class");
		  }
		  System.out.println("--------------@AfterMethod Ended from Sample2 class-------------------");
	  }

	 
	  @Test
	  public void f2()
	  {
		  System.out.println("--------------Main Test Method Started from Sample2 class-------------------");
		  for(int i=0;i<10;i++)
		  {
			  System.out.println("This is Main Test Method from Sample2 class");
		  }
		  System.out.println("--------------Main Test Method Ended from Sample2 class-------------------");
	  }
}
