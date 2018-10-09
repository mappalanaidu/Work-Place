package Module1;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Test24 {

	public static void main(String[] args) throws Exception
	{
		//Provide details of device and app
				DesiredCapabilities dc=new DesiredCapabilities();
				dc.setCapability(CapabilityType.BROWSER_NAME, "");
				dc.setCapability("deviceName", "HNB0ZC4E");
				dc.setCapability("platformName", "android");
				dc.setCapability("platformVersion", "6.0");
				dc.setCapability("appPackage", "com.android.dialer");
				dc.setCapability("appActivity", "com.android.dialer.DialtactsActivity");
				
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
			//Thread.sleep(10000);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='Contacts']")));
			driver.findElement(By.xpath("//*[@content-desc='Contacts']")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='Create new contact']")));
			
				
		//perform swipe for req elements
		int width=driver.manage().window().getSize().getWidth();
		int height=driver.manage().window().getSize().getHeight();
		TouchAction ta=new TouchAction(driver);
		int x1=(int)(width/2);
		int y1=(int)(height*0.9);
		int x2=(int)(width/2);
		int y2=(int)(height*0.4);
		
		while(2>1)
		{
			try
			{
				driver.findElement(By.xpath("//*[@text='Sister']")).click();
				break;
			}catch(Exception e)
			{
				Duration d=Duration.of(2,ChronoUnit.SECONDS);
				ta.press(x1,y1).waitAction(d).moveTo(x2,y2).release().perform();
									
			}
		}
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@content-desc,'Call Other')]")));
		driver.findElement(By.xpath("//*[contains(@content-desc,'Call Other')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Jio 4G 02']")));
		driver.findElement(By.xpath("//*[@text='Jio 4G 02']")).click();
	    Thread.sleep(20000);
		driver.findElement(By.xpath("//*[@content-desc='End Call']")).click();
		/*y1=(int)(height*0.3);
		y2=(int)(height*0.7);
		while(2>1)
		{
			try
			{
				driver.findElement(By.xpath("//*[@text=' Python']")).click();
				break;
			}catch(Exception e)
			{
				Duration d=Duration.of(2,ChronoUnit.SECONDS);
				ta.press(x1,y1).waitAction(d).moveTo(x2,y2).release().perform();
									
			}
		}*/
		
		
		//close app
		//driver.closeApp();
		
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
