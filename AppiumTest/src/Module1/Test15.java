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

public class Test15 {

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
					///Thread.sleep(10000);
					
					WebDriverWait w=new WebDriverWait(driver, 100);
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='9']")));
					String x=driver.getOrientation().name();
					if(x.equalsIgnoreCase("portrait"))
					{
						driver.rotate(ScreenOrientation.LANDSCAPE);
						Thread.sleep(10000);
						driver.rotate(ScreenOrientation.PORTRAIT);
					}
					Thread.sleep(5000);
					System.out.println("*********1");
					
					driver.lockDevice();
					Thread.sleep(5000);
					
					System.out.println("*********2");
					
					System.out.println(driver.isLocked());
					System.out.println("***********3");
					
					if(driver.isLocked())
					{
						System.out.println("Locked");
						driver.unlockDevice();
					}
					Thread.sleep(10000);					
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
