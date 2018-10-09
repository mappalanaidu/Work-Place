package Module1;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Test12 {

	public static void main(String[] args) throws Exception 
	{
		//Provide details of device(ARD) and app
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, "");
		dc.setCapability("deviceName", "HNB0ZC4E");
		dc.setCapability("platformName", "android");
		dc.setCapability("platformVersion", "6.0");
		dc.setCapability("appPackage", "cris.org.in.prs.ima");
		dc.setCapability("appActivity", "cris.org.in.ima.activities.IRCTCConnectActivity");
		
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
			//Thread.sleep(5000);
			for(int i=1; i<3;i++)
			{
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Allow']")));
			driver.findElement(By.xpath("//*[@text='Allow']")).click();
			
			}
			
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@resource-id,'book_ticket')]")));
			driver.findElement(By.xpath("//*[contains(@resource-id,'book_ticket')]")).click();
			
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@resource-id,'et_username')]")));
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
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@resource-id,'tv_station_name')]")));
			WebElement e=driver.findElement(By.xpath("//*[contains(@resource-id,'tv_station_name')]"));
			TouchAction ta=new TouchAction(driver);
			ta.press(e).release().perform();			
				
			//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='To']")));
			//driver.findElement(By.xpath("//*[@text='To']")).click();
						
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Search Station ...']")));
			driver.findElement(By.xpath("//*[@text='Search Station ...']")).sendKeys("VIZIANAGRAM JN");
			
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@resource-id,'tv_station_name')]")));
			WebElement e1=driver.findElement(By.xpath("//*[contains(@resource-id,'tv_station_name')]"));
			ta.press(e1).release().perform();			
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Tomorrow']")));
			driver.findElement(By.xpath("//*[@text='Tomorrow']")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Search Train']")));
			driver.findElement(By.xpath("//*[@text='Search Train']")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Tatkal']")));
			driver.findElement(By.xpath("//*[@text='Tatkal']")).click();
			//perform swipe for req elements
			int width=driver.manage().window().getSize().getWidth();
			int height=driver.manage().window().getSize().getHeight();
			//TouchAction ta=new TouchAction(driver);
			int x1=(int)(width/2);
			int y1=(int)(height*0.9);
			int x2=(int)(width/2);
			int y2=(int)(height*0.5);
			
			while(2>1)
			{
				try
				{
					driver.findElement(By.xpath("//*[@text='(17016)']")).click();
					break;
				}
				catch(Exception ec)
				{
					Duration d=Duration.of(2,ChronoUnit.SECONDS);
					ta.press(x1,y1).waitAction(d).moveTo(x2,y2).release().perform();
				}
			}
			/*w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='VISAKHA EXP']")));
			WebElement e2=driver.findElement(By.xpath("//*[@text='VISAKHA EXP']"));
			ta.press(e2).release().perform();	*/	
			while(2>1)
			{
				try
				{
					driver.findElement(By.xpath("//*[@text='SL']")).click();
					break;
				}
				catch(Exception ec)
				{
					Duration d=Duration.of(2,ChronoUnit.SECONDS);
					ta.press(x1,y1).waitAction(d).moveTo(x2,y2).release().perform();
				}
			}
			
			/*while(2>1)
			{
				try
				{
					driver.findElement(By.xpath("//*[@text='Book Now']")).click();
					break;
				}
				catch(Exception ec)
				{
					Duration d=Duration.of(2,ChronoUnit.SECONDS);
					ta.press(x1,y1).waitAction(d).moveTo(x2,y2).release().perform();
				}
			}*/
			
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Book Now']")));
			driver.findElement(By.xpath("//*[@text='Book Now']")).click();
			
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='ok']")));
		driver.findElement(By.xpath("//*[@text='ok']")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Add Passenger']")));
		driver.findElement(By.xpath("//*[@text='Add Passenger']")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Name']")));
		driver.findElement(By.xpath("//*[@text='Name']")).sendKeys("AppalaNaidu M");
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Age between 05 to 125']")));
		driver.findElement(By.xpath("//*[@text='Age between 05 to 125']")).sendKeys("30");
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Male']")));
		driver.findElement(By.xpath("//*[@text='Male']")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Select Berth Preference']")));
		driver.findElement(By.xpath("//*[@text='Select Berth Preference']")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='LOWER']")));
		driver.findElement(By.xpath("//*[@text='LOWER']")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Done']")));
		driver.findElement(By.xpath("//*[@text='Done']")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Book Ticket']")));
		driver.findElement(By.xpath("//*[@text='Book Ticket']")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@resource-id,'captcha')]")));
		String cpt=driver.findElement(By.xpath("//*[contains(@resource-id,'captcha')]")).toString();
		String cpt1=driver.findElement(By.xpath("//*[contains(@resource-id,'captcha')]")).getAttribute("text");
		String cpt2=driver.findElement(By.xpath("//*[contains(@resource-id,'captcha')]")).getText();
		
		System.out.println("captcha Value from toString method :"+cpt);
		System.out.println("captcha Value from getAttribute method :"+cpt1);
		System.out.println("captcha Value from getText method :"+cpt2);
		
		driver.findElement(By.xpath("//*[@text='Enter the captcha']")).sendKeys(cpt);
		
		//WebElement e1=driver.findElement(By.xpath("//*[contains(@resource-id,'tv_station_name')]"));
		
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Book Ticket']")));
		//driver.findElement(By.xpath("//*[@text='Book Ticket']")).click();
		
		
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
