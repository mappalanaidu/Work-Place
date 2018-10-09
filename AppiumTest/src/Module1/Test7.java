package Module1;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Test7 {

	public static void main(String[] args) throws Exception
	{
		// Take phone number from keyboard
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter name in lower case");
				String x=sc.nextLine();
				System.out.println("Enter the  position in selection list");
				int y=sc.nextInt();
				
				
				//Provide details of device and app
				DesiredCapabilities dc=new DesiredCapabilities();
				dc.setCapability(CapabilityType.BROWSER_NAME, "");
				dc.setCapability("deviceName", "HNB0ZC4E");
				dc.setCapability("platformName", "android");
				dc.setCapability("platformVersion", "6.0");
				dc.setCapability("appPackage", "com.android.dialer");
				dc.setCapability("appActivity", "com.android.dialer.DialtactsActivity");
				
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
					//	System.out.println(ex.getMessage());
						
				 	}
				}
				//Automation
				try
				{
					WebDriverWait w=new WebDriverWait(driver, 100);
					//Thread.sleep(10000);
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='Contacts']")));
					driver.findElement(By.xpath("//*[@content-desc='Contacts']")).click();
					
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Enter a name or phone number']")));
					driver.findElement(By.xpath("//*[@text='Enter a name or phone number']")).click();
					
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.widget.EditText']")));
					driver.findElement(By.xpath("//*[@class='android.widget.EditText']")).sendKeys(x);
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.view.ViewGroup[5]'][@text='Mobile' or @text='Other']")));
					//System.out.println(l.size());
					if(driver.findElements(By.xpath("//*[@class='android.view.ViewGroup'][5]")) != null)
					{
						driver.findElement(By.xpath("//*[@class='android.view.ViewGroup'][5]")).click();
					}
					else
					{
						System.out.println("No contact to call ");
						
					}
					Thread.sleep(10000);
					//	driver.findElement(By.xpath("//*[@content-desc='dial']")).click();
						
					//	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='00:49']")));
						
					driver.findElement(By.xpath("//*[@content-desc='End']")).click();
					///w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@resource-id,'message')]")));
					
					//String s=driver.findElement(By.xpath("//*[contains(@resource-id,'message')]")).getText();
					//System.out.println(s);
					
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
