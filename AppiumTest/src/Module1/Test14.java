package Module1;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Test14 {

	public static void main(String[] args) throws Exception 
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
		AndroidDriver driver;
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
		//Automation
		try
		{
			WebDriverWait w=new WebDriverWait(driver, 100);
			
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='username']")));
			driver.findElement(By.xpath("//*[@content-desc='username']")).click();
			//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='   Search for source city']")));
			//driver.findElement(By.xpath("//*[@text='   Search for source city']")).sendKeys("Bangalore");
		if(driver.isKeyboardShown())
		{
			driver.hideKeyboard();
		}
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='LOG IN']")));
		driver.findElement(By.xpath("//*[@text='LOG IN']")).click();
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@content-desc='slider1']")));
		driver.findElement(By.xpath("//*[@content-desc='slider1']")).click();
				
		}
		catch(Exception ex)
	{
		System.out.println(ex.getMessage());
		
	}
			
	//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");

}

}
