package Module1;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Test5 {

	public static void main(String[] args) throws Exception 
	{
		// Take phone number from keyboard
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter phone no.");
				String x=sc.nextLine();
				
				//Provide details of device and app
				DesiredCapabilities dc=new DesiredCapabilities();
				dc.setCapability(CapabilityType.BROWSER_NAME, "");
				dc.setCapability("deviceName", "1e56e4ec7d34");
				dc.setCapability("platformName", "android");
				dc.setCapability("platformVersion", "7.1.2");
				dc.setCapability("appPackage", "com.android.contacts");
				dc.setCapability("appActivity", "com.android.contacts.activities.TwelveKeyDialer");
				
				//Start appium server
				//Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium\"");
				
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
						//System.out.println(ex.getMessage());
						
				 	}
				}
				/*//Automation
				try
				{
					WebDriverWait w=new WebDriverWait(driver, 100);
					//Thread.sleep(10000);
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='six']")));
					//driver.findElement(By.xpath("//*[@content-desc='dial pad']")).click();
					//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='9']")));
					
					//enter phone no.
					
					for(int i=0;i<x.length();i++)
					{
						char d=x.charAt(i);
						String y="";
						switch(d)
						{
						case '0':
							y="zero";
							break;
						case '1':
							y="one";
							break;
						case '2':
							y="two";
							break;
						case '3':
							y="three";
							break;
						case '4':
							y="four";
							break;
						case '5':
							y="five";
							break;
						case '6':
							y="six";
							break;
						case '7':
							y="seven";
							break;
						case '8':
							y="eight";
							break;
						case '9':
							y="nine";
							break;
						
						}
						driver.findElement(By.xpath("//*[@content-desc='"+y+"']")).click();
						}
						driver.findElement(By.xpath("//*[@text='1409190534']")).click();
						
						w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='00:49']")));
						
					driver.findElement(By.xpath("//*[@content-desc='End']")).click();
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@resource-id,'message')]")));
					
					String s=driver.findElement(By.xpath("//*[contains(@resource-id,'message')]")).getText();
					System.out.println(s);
					
					//close app
					driver.closeApp();
				
					}
					catch(Exception ex)
					{
					System.out.println(ex.getMessage());
					
					}*/
						
				//stop appium server
					Runtime.getRuntime().exec("taskkill /F /IM node.exe");
					Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");

	}

}
