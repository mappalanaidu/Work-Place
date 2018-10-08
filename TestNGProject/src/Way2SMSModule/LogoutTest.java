package Way2SMSModule;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LogoutTest extends LoginPageTesting

{
	  @Test(dependsOnMethods= {"login"},priority=2)
	  public void logout() throws Exception 
	  {
		  
		 driver.findElement(By.xpath("//a[@class='logout']/i")).click();  
			try
			{
				if(driver.findElement(By.xpath("(//*[text()='Forgot password'])[1]")).isDisplayed())
				{
					Assert.assertTrue(true, "Logout test Passed");
				}
				else 
				{
						this.takeScreenshot();
					  Assert.assertTrue(false, "Way2SMS Logout Test was Failed");	
				}
					
			}
			catch(Exception ex1)
			{
					this.takeScreenshot();
				  Assert.assertTrue(false, "Way2SMS Logout Test was Interrupted");
			}

		}
}
