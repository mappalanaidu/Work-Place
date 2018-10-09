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

public class Test11 {

	public static void main(String[] args) throws Exception 
	{
		//Provide details of device(ARD) and app
				DesiredCapabilities dc=new DesiredCapabilities();
				dc.setCapability(CapabilityType.BROWSER_NAME, "");
				dc.setCapability("deviceName", "HNB0ZC4E");
				dc.setCapability("platformName", "android");
				dc.setCapability("platformVersion", "6.0");
				dc.setCapability("appPackage", "com.whatsapp");
				dc.setCapability("appActivity", "com.whatsapp.HomeActivity");
				
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
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Agree and continue']")));
					driver.findElement(By.xpath("//*[@text='Agree and continue']")).click();
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='CONTINUE']")));
					driver.findElement(By.xpath("//*[@text='CONTINUE']")).click();
					for(int i=1; i<3;i++)
						{
						w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Allow']")));
						driver.findElement(By.xpath("//*[@text='Allow']")).click();
						
						}
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='phone number']")));
					driver.findElement(By.xpath("//*[@text='phone number']")).sendKeys("9110768916");
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Next']")));
					driver.findElement(By.xpath("//*[@text='Next']")).click();
					
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='OK']")));
					driver.findElement(By.xpath("//*[@text='OK']")).click();
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='CONTINUE']")));
					driver.findElement(By.xpath("//*[@text='CONTINUE']")).click();
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Allow']")));
					driver.findElement(By.xpath("//*[@text='Allow']")).click();
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Restore']")));
					driver.findElement(By.xpath("//*[@text='Restore']")).click();
					for(int i=1; i<3;i++)
					{
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Next']")));
					driver.findElement(By.xpath("//*[@text='Next']")).click();
					}
					
					/*w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='Apps']")));
					driver.findElement(By.xpath("//*[@content-desc='Apps']")).click();
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='WhatsApp']")));
					driver.findElement(By.xpath("//*[@text='WhatsApp']")).click();
						
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='Search']")));
					driver.findElement(By.xpath("//*[@content-desc='Search']")).click();
					
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Search…']")));
					driver.findElement(By.xpath("//*[@text='Search…']")).sendKeys("sister");
					
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.widget.RelativeLayout'][3]")));
					driver.findElement(By.xpath("//*[@class='android.widget.RelativeLayout'][3]")).click();*/
					//Thread.sleep(30000);
					//close app
				//	driver.closeApp();
				
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
