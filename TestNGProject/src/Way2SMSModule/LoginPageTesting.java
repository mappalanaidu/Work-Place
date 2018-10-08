package Way2SMSModule;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class LoginPageTesting 
{
  public WebDriver driver;
  public WebDriverWait w;

  @Test(priority=0)
  @Parameters({"browser"})
public void launch(String x) throws Exception 
{
	//open our intrusted browser
	  if(x.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
			 driver=new ChromeDriver();//obj defined			
		}
		else if(x.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "F:\\Naidu\\TestingSoftwares\\geckodriver.exe");
			 driver=new FirefoxDriver();//obj defined			
	
		}
		else if(x.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "F:\\Naidu\\TestingSoftwares\\iedriverserver.exe");
			 driver=new InternetExplorerDriver();//obj defined			
	
		}
		else if(x.equalsIgnoreCase("opera"))
		{
			OperaOptions o=new OperaOptions();
			o.setBinary("C:\\Program Files\\Opera\\55.0.2994.56\\opera.exe");
			System.setProperty("webdriver.opera.driver", "F:\\Naidu\\TestingSoftwares\\operadriver_win64\\operadriver_win64\\operadriver.exe");
			 driver=new OperaDriver(o);//obj defined			
	
		}
		else
		{
			Assert.assertTrue(false, "Unknown Browser");
		}
	  driver.get("http://www.way2sms.com/");
	  driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	  w=new WebDriverWait(driver,30);
	  w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='mobileNo'])[1]")));
	 /// Thread.sleep(2000);
	  driver.manage().window().maximize();
	 }
	
	@Test(dependsOnMethods= {"launch"},priority=1)
	@Parameters({"username","password","criteria"})
	public void login(String x, String y, String c) throws Exception
	{
		 driver.findElement(By.xpath("(//input[@id='mobileNo'])[1]")).sendKeys(x);
		driver.findElement(By.xpath("(//input[@id='password'])[1]")).sendKeys(y);
		driver.findElement(By.xpath("(//button[contains(text(),'Login')])[1] ")).click();
		 
		try
		{
			if(c.equalsIgnoreCase("all_valid") && driver.findElement(By.xpath("//span[text()='Send SMS']")).isDisplayed())
			{
				Assert.assertTrue(true, "all_valid login test Passed");
			}
			else if(c.equals("mbno_blank") && driver.findElement(By.xpath("//b[text()='Enter your mobile number']")).isDisplayed())
			{
				Assert.assertTrue(true, "mbno_blank login test Passed");
			}
			else if(c.equals("mbno_invalid") && driver.findElement(By.xpath("//b[contains(text(),'Your mobile number is not register ')]")).isDisplayed())
			{
				Assert.assertTrue(true, "mbno_invalid login test Passed");
			}
			else if(c.equals("pwd_blank") && driver.findElement(By.xpath("(//*[text()='Enter password'])[2]")).isDisplayed())
			{
				Assert.assertTrue(true, "pwd_blank login test Passed");
			}
			else if(c.equals("pwd_invalid") && driver.findElement(By.xpath("//b[contains(text(),'Try Again.')]")).isDisplayed())
			{
				Assert.assertTrue(true, "pwd_invalid login test Passed");
			}
			else if(c.equals("msg_sent") && driver.findElement(By.xpath("(//*[text()='Forgot password'])[1]")).isDisplayed())
			{
				Assert.assertTrue(true, "msg_sent login test Passed");
			}
			else if(c.equals("sent_sms") && driver.findElement(By.xpath("//*[contains(text(),'Message Sent Successfully.')]")).isDisplayed())
			{
				Assert.assertTrue(true, "sent_sms login test Passed");
			}
			else if(c.equals("schedule_sms") && driver.findElement(By.xpath("//*[contains(text(),'Message Scheduled Successfully')]")).isDisplayed())
			{
				Assert.assertTrue(true, "schedule_sms login test Passed");
			}
			else if(c.equals("added_sms") && driver.findElement(By.xpath("//*[contains(text(), 'Contact has been added') or contains(text(), 'number is already exists')]")).isDisplayed())
			{
				Assert.assertTrue(true, "added_sms login test Passed");
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
	@Test(dependsOnMethods= {"login"},priority=3)
	public void close() throws Exception
	{
		driver.quit();;
	}
	
	public void takeScreenshot() throws Exception
	{
		  Date d=new Date();
		  SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-mm-ss");
		  String ssname=sf.format(d);
		  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  File dest=new File(ssname+".png");
		  FileUtils.copyFile(src, dest);
		  String path="<img src=\"file:///C:\\Users\\Naidu\\TestingWorkSpace\\TestNGProject\\"+ssname+".png\" alt=\"\"/>";
		  Reporter.log(path);
	}
	
}
