package AppsTesting;

import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class DragAndDropTestInVodqaApp
{
	 
	  AndroidDriver driver;
		 WebDriverWait w;
			
  @Test
  public void dragAndDrop() throws Exception
	{
		
		//Automation
				try
				{
									
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='LOG IN']")));
				driver.findElement(By.xpath("//*[@text='LOG IN']")).click();
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Drag & Drop']")));
				driver.findElement(By.xpath("//*[@text='Drag & Drop']")).click();
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Drag & Drop']")));
				WebElement e1=driver.findElement(By.xpath("//*[@text='Drag me!']"));
				WebElement e2=driver.findElement(By.xpath("//*[@text='Drop here.']"));
				TouchAction ta=new TouchAction(driver);
				Duration d=Duration.of(5, ChronoUnit.SECONDS);
				ta.press(e1).waitAction(d).moveTo(e2).release().perform();
				
				try
				{
				if(driver.findElement(By.xpath("//*[@text='Circle dropped']")).isDisplayed())
					{
					   this.takeScreenshot();
					  Assert.assertTrue(true, "Drag and Drop Test Finished");
					  System.out.println("Operation was finished");
					}
				}
				catch(Exception e)
				{
					  this.takeScreenshot();
					  Assert.assertTrue(false, "Drag and Drop Test was Interrupted");
					System.out.println("Operation was not finished");
					System.out.println(e.getMessage());
					
				}
				
				//close app
				driver.closeApp();
				
				}
				catch(Exception ex)
				{
					  this.takeScreenshot();
					  Assert.assertTrue(false, "Drag and Drop Test was Interrupted");
					  System.out.println(ex.getMessage());
				
				}
  }
	
  @BeforeMethod
  public void beforeMethod() throws Exception 
  {
	 		 //Provide details of device(ARD) and app
			DesiredCapabilities dc=new DesiredCapabilities();
			dc.setCapability(CapabilityType.BROWSER_NAME, "");
			dc.setCapability("deviceName", "HNB0ZC4E");
			dc.setCapability("platformName", "android");
			dc.setCapability("platformVersion", "6.0");
			dc.setCapability("appPackage", "com.vodqareactnative");
			dc.setCapability("appActivity", "com.vodqareactnative.MainActivity");
			
			//Start appium server
			Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
			URL u=new URL("http://0.0.0.0:4723/wd/hub");
			
			//create object for AndroidDriver to launch app
			
			while(2>1)
			{
			try
				{
				driver=new AndroidDriver(u, dc);
				break;
				}
			catch(Exception ex)
			 	{
				
			 	}
			}
			//create object for  WebDriverWait 
			   w=new WebDriverWait(driver, 100);
  }

  @AfterMethod
  public void afterMethod() throws Exception 
  {
	//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
}

public void takeScreenshot() throws Exception
{
	  Date d=new Date();
	  SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-mm-ss");
	  String ssname=sf.format(d);
	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  File dest=new File(ssname+".png");
	  FileUtils.copyFile(src, dest);
	  String path="<img src=\"file:///C:\\Users\\Naidu\\TestingWorkSpace\\AppiumWithTestNG\\"+ssname+".png\" alt=\"\"/>";
	  Reporter.log(path);
}

}
