package Module;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Mymethods
{
	public WebDriver driver;
	public WebDriverWait wait;

	public String launch(String e, String d, String c) throws Exception
	{	
		//open our intrusted browser
		  if(e.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
				 driver=new ChromeDriver();//obj defined			
			}
			else if(e.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "F:\\Naidu\\TestingSoftwares\\geckodriver.exe");
				 driver=new FirefoxDriver();//obj defined			
		
			}
			else if(e.equalsIgnoreCase("ie"))
			{
				System.setProperty("webdriver.ie.driver", "F:\\Naidu\\TestingSoftwares\\iedriverserver.exe");
				 driver=new InternetExplorerDriver();//obj defined			
		
			}
			else if(e.equalsIgnoreCase("opera"))
			{
				OperaOptions o=new OperaOptions();
				o.setBinary("C:\\Program Files\\Opera\\55.0.2994.56\\opera.exe");
				System.setProperty("webdriver.opera.driver", "F:\\Naidu\\TestingSoftwares\\operadriver_win64\\operadriver_win64\\operadriver.exe");
				 driver=new OperaDriver(o);//obj defined			
		
			}
			else
			{
			return("Unknown Browser");
			}
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(d);
		wait=new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
		driver.manage().window().maximize();
		return ("Done");
		}
	public String fillDOB(String e, String d, String c) throws Exception
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(e)));
		driver.findElement(By.xpath(e)).sendKeys(d,Keys.ENTER);
		return ("Done");
	}


	public String fill(String e, String d, String c) throws Exception
	{
			
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(e)));
		WebElement e1=driver.findElement(By.xpath(e));
		e1.clear();
		e1.sendKeys(d);
		return ("Done");
	}


	public String click(String e, String d, String c) throws Exception
	{
		//Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(e)));
		driver.findElement(By.xpath(e)).click();
		return ("Done");
	}
	public String countSentSMS(String e, String d, String c) throws Exception
	{
		//Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(e)));
		
		List<WebElement> l=driver.findElements(By.xpath(e));
		String count=String.valueOf(l.size());
		System.out.println(count);
		//String mcount=count;
		//driver.findElement(By.xpath(e)).click();
		return (count);
	}
	public String elementVisible(String e, String d, String c) throws Exception
	{
		//Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(e)));
		//driver.findElement(By.xpath(e)).click();
		return ("Done");
	}


	public String validateLogin(String e, String d, String c) throws Exception
	{
		try
		{
			if(c.equalsIgnoreCase("all_valid") && driver.findElement(By.xpath("//*[text()='Remaining Characters ']")).isDisplayed())
			{
				return("Passed");
			}
			else if(c.equals("mbno_blank") && driver.findElement(By.xpath("//b[text()='Enter your mobile number']")).isDisplayed())
			{
				//Thread.sleep(5000);
				return("Passed");
			}
			else if(c.equals("mbno_invalid") && driver.findElement(By.xpath("//b[contains(text(),'Your mobile number is not register ')]")).isDisplayed())
			{
				//Thread.sleep(5000);
				return("Passed");
			}
			else if(c.equals("pwd_blank") && driver.findElement(By.xpath("(//*[text()='Enter password'])[2]")).isDisplayed())
			{
				//Thread.sleep(5000);
				return("Passed");
			}
			else if(c.equals("pwd_invalid") && driver.findElement(By.xpath("//b[contains(text(),'Try Again.')]")).isDisplayed())
			{
				//Thread.sleep(5000);
				return("Passed");
			}
			else if(c.equals("msg_sent") && driver.findElement(By.xpath("(//*[text()='Forgot password'])[1]")).isDisplayed())
			{
				//Thread.sleep(5000);
				return("Passed");
			}
			else if(c.equals("sent_sms") && driver.findElement(By.xpath("//*[contains(text(),'Message Sent Successfully.')]")).isDisplayed())
			{
				//Thread.sleep(5000);
				return("Passed");
			}
			else if(c.equals("schedule_sms") && driver.findElement(By.xpath("//*[contains(text(),'Message Scheduled Successfully')]")).isDisplayed())
			{
				//Thread.sleep(5000);
				return("Passed");
			}
			else if(c.equals("added_sms") && driver.findElement(By.xpath("//*[contains(text(), 'Contact has been added') or contains(text(), 'number is already exists')]")).isDisplayed())
			{
				//Thread.sleep(5000);
				return("Passed");
			}
			else 
			{
				//Thread.sleep(5000);
				String temp=this.screenshot();
				return("Test Failed & go to "+temp+".png");
			}
				
		}
		catch(Exception ex1)
		{
			//Thread.sleep(5000);
			String temp=this.screenshot();
			return("Test Interrupted & go to "+temp+".png");

		}
		
	//return("Done");	
	}
	public String selectByVisibleText(String e, String d, String c) throws Exception
	{
		//Thread.sleep(5000);
		WebElement e1=driver.findElement(By.xpath(e));
		Select s=new Select(e1);
		s.selectByVisibleText(d);
		return ("Done");
	}

	public String closeSite(String e, String d, String c) throws Exception
	{
		//Thread.sleep(5000);
		driver.close();
		return ("Done");
	}

	public String capcha(String e, String d, String c) throws Exception
	{
		Thread.sleep(30000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(e)));
		//driver.findElement(By.xpath(e)).click();
		return ("Done");
	}


	public String screenshot() throws Exception
	{
		SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
		Date dt=new Date();
		String ssname=sf.format(dt);
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File(ssname+".png");
		FileUtils.copyFile(src, dest);
		return (ssname);
		
	}
}
