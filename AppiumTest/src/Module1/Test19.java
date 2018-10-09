package Module1;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.Connection;

public class Test19 {

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
					String p=driver.getCurrentPackage();
					String a=driver.currentActivity();
					System.out.println("package and activity names are"+p+"  "+a);
					String dt=driver.getDeviceTime();
					System.out.println("device date and time "+dt);
					//SimpleDateFormat s=new SimpleDateFormat("dd/MM/yy");
					//String d=s.format(dt);
					//System.out.println("date "+d);
					
				Duration d=Duration.of(10,ChronoUnit.SECONDS);
					driver.runAppInBackground(d);
					
					String x=driver.getRemoteAddress().getPath();
					System.out.println("path "+x);
					String y=driver.getRemoteAddress().getProtocol();
					System.out.println("protocal "+y);
					String z=driver.getRemoteAddress().getHost();
					System.out.println("host "+z);
					int port=driver.getRemoteAddress().getPort();
					System.out.println("port "+port);
					String f=driver.getPlatformName();
					System.out.println("host "+f);
					long l=driver.getDisplayDensity();
					System.out.println("port "+l);
					//driver.openNotifications();
					///Thread.sleep(5000);
					///driver.pressKeyCode(AndroidKeyCode.HOME);
					Set cs=driver.getContextHandles();
					System.out.println("No of contexts are "+cs.size());
					System.out.println("Contexts are "+cs);
					/*driver.setConnection(Connection.NONE);
					Thread.sleep(5000);
					driver.setConnection(Connection.ALL);
					driver.setConnection(Connection.NONE);
					Thread.sleep(5000);
					driver.setConnection(Connection.WIFI);*/
					driver.setConnection(Connection.ALL);

				//	driver.setConnection(Connection.WIFI);
					//Thread.sleep(10000);
					Connection c=driver.getConnection();
					if(c.compareTo(Connection.WIFI)==1)
					{
					System.out.println("Wifi is ON");
					}
					else
					{
						System.out.println("Wifi is OFF");						
							
					}
					if(c.compareTo(Connection.DATA)==1)
					{
					System.out.println("DATA is ON");
					}
					else
					{
						System.out.println("DATA is OFF");						
							
					}
					if(c.compareTo(Connection.AIRPLANE)==1)
					{
					System.out.println("AIRPLANE is ON");
					}
					else
					{
						System.out.println("AIRPLANE is OFF");						
							
					}
					Connection c1=driver.getConnection();
					driver.setConnection(Connection.NONE);
					
					Thread.sleep(10000);
					if(c1.compareTo(Connection.WIFI)==1)
					{
					System.out.println("Wifi is ON");
					}
					else
					{
						System.out.println("Wifi is OFF");						
							
					}
					if(c1.compareTo(Connection.DATA)==1)
					{
					System.out.println("DATA is ON");
					}
					else
					{
						System.out.println("DATA is OFF");						
							
					}
					if(c1.compareTo(Connection.AIRPLANE)==1)
					{
					System.out.println("AIRPLANE is ON");
					}
					else
					{
						System.out.println("AIRPLANE is OFF");						
							
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
