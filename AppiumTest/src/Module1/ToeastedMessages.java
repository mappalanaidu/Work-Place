package Module1;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.LoadLibs;

public class ToeastedMessages
{

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
			//driver.findElement(By.xpath("//*[@text='LOG IN']")).click();
			driver.pressKeyCode(AndroidKeyCode.HOME);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='Apps']")));
			driver.findElement(By.xpath("//*[@content-desc='Apps']")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Clean Android']")));
			driver.findElement(By.xpath("//*[@text='Clean Android']")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Phone Boost']")));
			//driver.findElement(By.xpath("//*[@text='Phone Boost']")).click();
			driver.pressKeyCode(AndroidKeyCode.BACK);
			File src=driver.getScreenshotAs(OutputType.FILE);
			File dest=new File("toeastedmessage.png");
			FileUtils.copyFile(src, dest);
			driver.launchApp();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='LOG IN']")));
			//close app
			driver.closeApp();
			//OCR Technic to get text mesg from toeastemessage image
			
			//Load "tessdata" folder, which is having characters
			File fo=LoadLibs.extractTessResources("tessdata");
			//create obj to apply OCR on Image
			Tesseract obj=new Tesseract();
			obj.setDatapath(fo.getAbsolutePath());
			//obj.setLanguage("eng");//eng means alpha numarics
			//take screenshot file, which have  text in context
			File f=new File("toeastedmessage.png");
			String result=obj.doOCR(f);
			Thread.sleep(20000);
			System.out.println(result);

					
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
