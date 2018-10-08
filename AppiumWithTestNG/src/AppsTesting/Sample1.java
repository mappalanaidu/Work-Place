package AppsTesting;

import org.testng.annotations.Test;

public class Sample1
{
	@Test
	  public void f1()
	  {
		  System.out.println("--------------Main Test Method Started from Sample1 Class-------------------");
		  for(int i=0;i<5;i++)
		  {
			  System.out.println("This is Main Test Method from Sample1 Class");
		  }
		  System.out.println("--------------Main Test Method Ended from Sample1 Class-------------------");
	  }
	  
}
