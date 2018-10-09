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

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Test27 {

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
				//driver.findElement(By.xpath("//*[@text='LOG IN']")).click();
				driver.pressKeyCode(AndroidKeyCode.HOME);
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='BookMyShow']")));
				MobileElement e=(MobileElement)driver.findElement(By.xpath("//*[@text='BookMyShow']"));
				TouchAction ta=new TouchAction(driver);
				Duration d=Duration.of(10,ChronoUnit.SECONDS);
				ta.longPress(e).waitAction(d).release().perform();
				
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.view.View'][@index=2]")));
				WebElement e1=driver.findElement(By.xpath("//*[@class='android.view.View'][@index=2]"));
				
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Remove']")));
				WebElement e2=driver.findElement(By.xpath("//*[@text='Remove']"));
				ta.press(e1).moveTo(e2).release().perform();
				
				}
				catch(Exception ex)
			{
				System.out.println(ex.getMessage());
				
			}
				//close app
				driver.launchApp();
				driver.closeApp();
					
			//stop appium server
				Runtime.getRuntime().exec("taskkill /F /IM node.exe");
				Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");

	}

}
