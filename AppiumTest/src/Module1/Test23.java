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

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Test23 {

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
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Vertical swiping']")));
				driver.findElement(By.xpath("//*[@text='Vertical swiping']")).click();
				w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Vertical swiping']")));
				
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
						driver.findElement(By.xpath("//*[@text=' Jest']")).click();
						break;
					}catch(Exception e)
					{
						Duration d=Duration.of(2,ChronoUnit.SECONDS);
						ta.press(x1,y1).waitAction(d).moveTo(x2,y2).release().perform();
											
					}
				}
				
				y1=(int)(height*0.3);
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
