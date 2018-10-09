package Module1;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Test17 {

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
			
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Amazon Shopping']")));
			driver.findElement(By.xpath("//*[@text='Amazon Shopping']")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Already a customer? Sign in']")));
			driver.findElement(By.xpath("//*[@text='Already a customer? Sign in']")).click();
		
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@resource-id,'action_bar_burger_icon')]")));
			driver.findElement(By.xpath("//*[contains(@resource-id,'action_bar_burger_icon')]")).click();
			
			/*w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@resource-id,'et_username')]")));
			driver.findElement(By.xpath("//*[contains(@resource-id,'et_username')]")).sendKeys("Naidu03");
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@resource-id,'et_password')]")));
			driver.findElement(By.xpath("//*[contains(@resource-id,'et_password')]")).click();
			
			driver.findElement(By.xpath("//*[contains(@resource-id,'et_password')]")).sendKeys("bhagya");
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@resource-id,'rl_login_layout')]")));
			driver.findElement(By.xpath("//*[contains(@resource-id,'rl_login_layout')]")).click();
			
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@resource-id,'et_pin')]")));
			driver.findElement(By.xpath("//*[contains(@resource-id,'et_pin')]")).click();
			
			driver.findElement(By.xpath("//*[contains(@resource-id,'et_pin')]")).sendKeys("4321");
			
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@resource-id,'et_re_enter_pin')]")));
			driver.findElement(By.xpath("//*[contains(@resource-id,'et_re_enter_pin')]")).click();
			
			driver.findElement(By.xpath("//*[contains(@resource-id,'et_re_enter_pin')]")).sendKeys("4321");
			
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@resource-id,'tv_submit')]")));
			driver.findElement(By.xpath("//*[contains(@resource-id,'tv_submit')]")).click();
			
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@resource-id,'button1')]")));
			driver.findElement(By.xpath("//*[contains(@resource-id,'button1')]")).click();
			
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@resource-id,'got_it')]")));
			driver.findElement(By.xpath("//*[contains(@resource-id,'got_it')]")).click();
						
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='From']")));
			driver.findElement(By.xpath("//*[@text='From']")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Search Station ...']")));
			driver.findElement(By.xpath("//*[@text='Search Station ...']")).sendKeys("SECUNDERABAD JN");
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='To']")));
			driver.findElement(By.xpath("//*[@text='To']")).click();
						
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Search Station ...']")));
			driver.findElement(By.xpath("//*[@text='Search Station ...']")).sendKeys("VIZIANAGRAM JN");
			
			//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@resource-id,'tv_station_name')]")));
			
		//	driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"tv_station_name\")").click();
			
			
		/*w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.widget.TextView']")));
			//driver.findElement(By.xpath("//*[@class='android.widget.TextView']")).sendKeys(Keys.TAB);
			
			//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='VIZIANAGRAM JN']")));
			//driver.findElement(By.xpath("//*[@text='VIZIANAGRAM JN']")).sendKeys(Keys.ENTER);
			
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Tomorrow']")));
			driver.findElement(By.xpath("//*[@text='Tomorrow']")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Search Train']")));
			driver.findElement(By.xpath("//*[@text='Search Train']")).click();*/
			
			
			
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

	