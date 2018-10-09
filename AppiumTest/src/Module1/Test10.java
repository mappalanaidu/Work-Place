package Module1;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Test10 {

	public static void main(String[] args) throws Exception
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
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='9']")));
			/*String x=driver.getOrientation().name();
			if(x.equalsIgnoreCase("portrait"))
			{
				driver.rotate(ScreenOrientation.LANDSCAPE);
				//Thread.sleep(5000);
				driver.rotate(ScreenOrientation.PORTRAIT);
			}*/
			
			driver.pressKeyCode(AndroidKeyCode.HOME);
			
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='Apps']")));
			driver.findElement(By.xpath("//*[@content-desc='Apps']")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='WhatsApp']")));
			driver.findElement(By.xpath("//*[@text='WhatsApp']")).click();
			String f=driver.getCurrentPackage();
			String g=driver.currentActivity();
			System.out.println("Present Package and Activity Names are :"+f+"  "+g);
		
				
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='Search']")));
			driver.findElement(By.xpath("//*[@content-desc='Search']")).click();
			
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Search…']")));
			driver.findElement(By.xpath("//*[@text='Search…']")).sendKeys("sister");
			
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.widget.RelativeLayout'][3]")));
			driver.findElement(By.xpath("//*[@class='android.widget.RelativeLayout'][3]")).click();
			
			String p=driver.getCurrentPackage();
			String a=driver.currentActivity();
			System.out.println("Present Package and Activity Names are :"+p+"  "+a);
		
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Type a message']")));
			driver.findElement(By.xpath("//*[@text='Type a message']")).sendKeys("Hi Sister, how r you");
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='Send']")));
			driver.findElement(By.xpath("//*[@content-desc='Send']")).click();
			driver.pressKeyCode(AndroidKeyCode.BACK);
			driver.pressKeyCode(AndroidKeyCode.HOME);
			
			driver.launchApp();
			String x=driver.getCurrentPackage();
			String y=driver.currentActivity();
			System.out.println("Present Package and Activity Names are :"+x+"  "+y);
		
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
