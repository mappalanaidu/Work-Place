package Way2SMSModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LanguageSMSTest extends LoginPageTesting 
{
	@Test(dependsOnMethods= {"login"},priority=2)
	  @Parameters({"mobileno","msgbody","criteria2"})
	  public void languageSelectMessage(String x,String y,String c) throws Exception 
	  {
		driver.findElement(By.xpath("//span [text()='Language SMS']")).click();
		driver.findElement(By.xpath("//input[@name='toMobile']")).sendKeys(x);
		 WebElement e=driver.findElement(By.xpath("//select [@class='ip-select-sm']"));
		  Select s=new Select(e);
		  s.selectByVisibleText("Telugu");
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
