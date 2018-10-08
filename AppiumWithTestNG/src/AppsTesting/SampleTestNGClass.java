package AppsTesting;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class SampleTestNGClass {
  
	@Test
	  public void f2()
	  {
		  System.out.println("--------------Main Test Method Started from Sample1 class-------------------");
		  for(int i=0;i<10;i++)
		  {
			  System.out.println("This is Main Test Method from Sample1 class");
		  }
		  System.out.println("--------------Main Test Method Ended from Sample1 class-------------------");
	  }
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
  
  @BeforeMethod
  public void beforeMethod()
  {
	  System.out.println("--------------@BeforeMethod Started-------------------");
	  for(int i=0;i<10;i++)
	  {
		  System.out.println("This is @BeforeMethod");
	  }
	  System.out.println("--------------@BeforeMethod Ended-------------------");
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
  @BeforeTest
  public void beforeTest() throws InterruptedException 
  {
  
	  System.out.println("--------------@BeforeTest Started-------------------");
	  Thread.sleep(5000);
	  for(int i=0;i<10;i++)
	  {
		  System.out.println("This is @BeforeTest");
	  }
	  System.out.println("--------------@BeforeTest Ended-------------------");
  }
  @BeforeSuite
  public void beforeSuite() 
  {
	  System.out.println("--------------@BeforeSuite Started-------------------");
	  for(int i=0;i<10;i++)
	  {
		  System.out.println("This is @BeforeSuite");
	  }
	  System.out.println("--------------@BeforeSuite Ended-------------------");
  }

}
