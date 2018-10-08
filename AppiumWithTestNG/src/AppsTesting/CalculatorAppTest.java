package AppsTesting;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class CalculatorAppTest
{
	AndroidDriver driver;
	 WebDriverWait w;
	
  @Test()
  @Parameters({"input1","input2"})
  //@Test(dependsOnMethods= {"launch"},priority=1)
	//@Parameters({"username","password","criteria"})

  public void claculatorTest(String x,String y) throws Exception
  {
	  try
		{
		 // w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='9']")));
	//enter input 1
	for(int i=0;i<x.length();i++)
	{
		char d=x.charAt(i);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='9']")));
			driver.findElement(By.xpath("//*[@text='"+d+"']")).click();
	}
	//Click +
	driver.findElement(By.xpath("//*[@content-desc='plus']")).click();
	//enter input 2
	for(int i=0;i<y.length();i++)
	{
		char d=y.charAt(i);
		driver.findElement(By.xpath("//*[@text='"+d+"']")).click();
	}
	//Click =
	driver.findElement(By.xpath("//*[@content-desc='equals']")).click();
	
	//get output and validate
	
	String z=driver.findElement(By.xpath("//*[@class='android.widget.TextView']")).getAttribute("text");
	System.out.println("Result :"+z);
	
	if(Integer.parseInt(z)==Integer.parseInt(x)+Integer.parseInt(y))
	{
			
		this.takeScreenshot();
		  Assert.assertTrue(true, "Test Passed");
		
	}
	else
	{
				this.takeScreenshot();
		  Assert.assertTrue(false, "Test Failed");
	}
	//close app
	driver.closeApp();
  }
	catch(Exception ex)
   {	
	System.out.println(ex.getMessage());
		this.takeScreenshot();
	  Assert.assertTrue(false, "Test Interrupted");
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
	 		dc.setCapability("appPackage", "com.google.android.calculator");
	 		dc.setCapability("appActivity", "com.android.calculator2.Calculator");
	 		
	 		//Start appium server
	 				Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
	 				URL u=new URL("http://0.0.0.0:4723/wd/hub");
	 				
	 				//AndroidDriver driver;
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
