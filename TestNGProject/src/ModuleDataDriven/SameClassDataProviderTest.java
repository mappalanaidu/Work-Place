package ModuleDataDriven;

import org.testng.annotations.Test;

import com.google.common.io.Files;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class SameClassDataProviderTest 
{
	public ChromeDriver driver;
	@DataProvider(name="searchword")
	public Object[][] testdata()
	{
		return new Object[][]
				{
					{"kalam"},
					{"mother"},
					{"appium"},
			
				};
		}
  @Test(dataProvider="searchword")
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
		  File src=driver.getScreenshotAs(OutputType.FILE);
		  File dest=new File(ssname+".png");
		  FileUtils.copyFile(src, dest);
		  String path="<img src=\"file:///C:\\Users\\Naidu\\TestingWorkSpace\\TestNGProject\\"+ssname+".png\" alt=\"\"/>";
		  Reporter.log(path);
		  Assert.assertTrue(false, "Google title test Failed");
		  
	  }
	  
  }
  @BeforeMethod()
  public void launch()throws Exception
  {
	  System.setProperty("webdriver.chrome.driver", "F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		 driver=new ChromeDriver();//obj defined	
  }

  @AfterMethod
  public void close() throws Exception
  {
  driver.close();
  }

}
