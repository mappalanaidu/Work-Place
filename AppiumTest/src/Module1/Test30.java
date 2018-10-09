package Module1;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Test30 {

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
					int width=driver.manage().window().getSize().getWidth();
					int height=driver.manage().window().getSize().getHeight();
					int x1=(int)(width/2);
					int y1=(int)(height*0.9);
					int x2=x1;
					int y2=(int)(height*0.6);
					while(2>1)
						{
						try
						
						{
							driver.findElement(By.xpath("//*[@text='Photo View']")).click();
								break;
						
						}catch(Exception exc)
							{
						TouchAction ta=new TouchAction(driver);
						ta.press(x1, y1).waitAction(Duration.ofMillis(2000)).moveTo(x2,y2).release().perform();
							}
						}
					
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Photo Screen']")));
					
					WebElement e=driver.findElement(By.xpath("//*[@class='android.widget.ImageView']"));
						//int x=e.getLocation().getX();
						//int y=e.getLocation().getY();
						/*int x=e.getSize().getWidth();
						int y=e.getSize().getHeight();
						
						
						int tx=(int)(x/2);
						int ty=(int)(y/2);
						
						int e1x1=(int)(tx*0.9);
						int e1y1=(int)(ty/2);
						int e1x2=(int)(tx*0.6);
						int e1y2=e1y1;
						
						int e2x1=(int)(tx*0.6);
						int e2y1=(int)(ty/2);
						int e2x2=(int)(tx*0.9);
						int e2y2=e2y1;*/
						
						TouchAction ta1=new TouchAction(driver);
						Duration d=Duration.of(10,ChronoUnit.SECONDS);
						ta1.press(272, 707).waitAction(d).moveTo(172, 707).release();
						//ta1.press(e1x1, e1y1).waitAction(d).moveTo(e1x2, e1y2).release();
						
						TouchAction ta2=new TouchAction(driver);
						//ta2.press(e2x1, e2y1).waitAction(d).moveTo(e2x2, e2y2).release();
						ta2.press(448, 707).waitAction(d).moveTo(640, 707).release();
						
						MultiTouchAction ma=new MultiTouchAction(driver);
						ma.add(ta1).add(ta2).perform();
						
						
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
