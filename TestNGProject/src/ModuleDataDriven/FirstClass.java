package ModuleDataDriven;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FirstClass 
{

public WebDriver driver;
@Test()
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
  driver.get("http://www.google.co.in");
  Thread.sleep(2000);
  driver.manage().window().maximize();
 }

@Test(dependsOnMethods= {"launch"})
@Parameters({"searchword"})
public void search(String x) throws Exception
{
	driver.findElement(By.name("q")).sendKeys(x, Keys.ENTER);
	 Thread.sleep(2000);
	  driver.manage().window().maximize();
	  String t=driver.getTitle();
	  if(t.contains(x))
	  {
		  Assert.assertTrue(true, "Google title test Passed");
	  }
	  else
	  {
		  Date d=new Date();
		  SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-mm-ss");
		  String ssname=sf.format(d);
		  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  File dest=new File(ssname+".png");
		  FileUtils.copyFile(src, dest);
		  String path="<img src=\"file:///C:\\Users\\Naidu\\TestingWorkSpace\\TestNGProject\\"+ssname+".png\" alt=\"\"/>";
		  Reporter.log(path);
		  Assert.assertTrue(false, "Google title test Failed");
		  
	  }
	
}
@Test(dependsOnMethods= {"search"})
public void close() throws Exception
{
	driver.quit();;
}
}
