package ModuleDataDriven;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class DataDrivenTestUsingXML 
{
	public WebDriver driver;
	  @Test()
	  @Parameters({"searchword"})
	  public void search(String x) throws Exception
	  {
		  driver.get("http://www.google.co.in");
		  driver.findElement(By.name("q")).sendKeys(x,Keys.ENTER);
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
			  //File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File dest=new File(ssname+".png");
			  FileUtils.copyFile(src, dest);
			  String path="<img src=\"file:///C:\\Users\\Naidu\\TestingWorkSpace\\TestNGProject\\"+ssname+".png\" alt=\"\"/>";
			  Reporter.log(path);
			  Assert.assertTrue(false, "Google title test Failed");
			  
		  }
		  
	  }
	  @BeforeMethod()
	 // @Parameters("browser")
	  public void launch()throws Exception
	  {
		  System.setProperty("webdriver.chrome.driver", "F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
			 driver=new ChromeDriver();//obj defined			
		}

	  @AfterMethod()
	  public void close() throws Exception
	  {
	  driver.close();
	  }
}
