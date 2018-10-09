
package Module1;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Test29 {

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
			
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='LOG IN']")));
			driver.findElement(By.xpath("//*[@text='LOG IN']")).click();
			
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Double Tap']")));
			driver.findElement(By.xpath("//*[@text='Double Tap']")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Double Tap Me']")));
				WebElement e=driver.findElement(By.xpath("//*[@text='Double Tap Me']"));
				//double tap
				
				TouchAction ta1=new TouchAction(driver);
				ta1.tap(e);

				TouchAction ta2=new TouchAction(driver);
				
				//Duration d=Duration.of(10,ChronoUnit.SECONDS);
				ta2.waitAction(Duration.ofMillis(100)).tap(e);
				
				MultiTouchAction ma=new MultiTouchAction(driver);
				ma.add(ta1).add(ta2).perform();
				try
				{
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Double tap successful!']")));
					driver.findElement(By.xpath("//*[@text='OK']")).click();					
					System.out.println("Operation was finished");
				}catch(Exception exc)
				{
					System.out.println(exc.getMessage());
					System.out.println("Operation was not finished");
					
				}
				
				//close app
				driver.closeApp();
						
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
