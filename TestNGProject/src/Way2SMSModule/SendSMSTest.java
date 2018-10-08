package Way2SMSModule;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SendSMSTest extends LoginPageTesting
{
	
	 
  @Test(dependsOnMethods= {"login"},priority=2)
  @Parameters({"mobileno","msgbody","criteria2"})
  public void sendMessage(String x,String y,String c) throws Exception 
  {
	  
	  driver.findElement(By.xpath("//input[@name='toMobile']")).sendKeys(x);
		driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(y);
		driver.findElement(By.xpath("//button[@id='sendButton']")).click();  
		try
		{
			if(c.equals("msg_sent") && driver.findElement(By.xpath("(//*[text()='Forgot password'])[1]")).isDisplayed())
			{
				Assert.assertTrue(true, "msg_sent test Passed");
			}
			else if(c.equals("sent_sms") && driver.findElement(By.xpath("//*[contains(text(),'Message Sent Successfully.')]")).isDisplayed())
			{
				Assert.assertTrue(true, "sent_sms test Passed");
			}
			else if(c.equals("schedule_sms") && driver.findElement(By.xpath("//*[contains(text(),'Message Scheduled Successfully')]")).isDisplayed())
			{
				Assert.assertTrue(true, "schedule_sms test Passed");
			}
			else if(c.equals("added_sms") && driver.findElement(By.xpath("//*[contains(text(), 'Contact has been added') or contains(text(), 'number is already exists')]")).isDisplayed())
			{
				Assert.assertTrue(true, "added_sms test Passed");
			}
			else 
			{
					this.takeScreenshot();
				  Assert.assertTrue(false, "Way2SMS Login Test was Failed");	
			}
				
		}
		catch(Exception ex1)
		{
				this.takeScreenshot();
			  Assert.assertTrue(false, "Way2SMS Login Test was Interrupted");
		}

	}

  }

