package Module1;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Test20 {

	public static void main(String[] args) throws Exception
	{
		// Take two inputs from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter input1");
		String x=sc.nextLine();
		System.out.println("Enter input2");
		String y=sc.nextLine();
		
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
			List<String> pl=driver.getSupportedPerformanceDataTypes();
			for(int i=0;i<pl.size();i++)
			{
				System.out.print(pl.get(i)+"\t");
			}
			
			WebDriverWait w=new WebDriverWait(driver, 100);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='9']")));
			//enter input 1
			for(int i=0;i<x.length();i++)
			{
				char d=x.charAt(i);
				w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='"+d+"']")));
					driver.findElement(By.xpath("//*[@text='"+d+"']")).click();
			}
			//Click +
			driver.findElement(By.xpath("//*[@content-desc='plus']")).click();
			//enter input 2
			for(int i=0;i<y.length();i++)
			{
				char d=y.charAt(i);
				w.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='"+d+"']")));
				
				driver.findElement(By.xpath("//*[@text='"+d+"']")).click();
			}
			//Click =
			driver.findElement(By.xpath("//*[@content-desc='equals']")).click();
			
			//get output and validate
			
			String z=driver.findElement(By.xpath("//*[@class='android.widget.TextView']")).getAttribute("text");
			System.out.println("Result :"+z);
			
			if(Integer.parseInt(z)==Integer.parseInt(x)+Integer.parseInt(y))
			{
				System.out.println("Test Passed");
				File src=driver.getScreenshotAs(OutputType.FILE);
				File dest=new File("passss.png");
				FileUtils.copyFile(src, dest);
				
			}
			else
			{
				System.out.println("Test Failed");
				File src=driver.getScreenshotAs(OutputType.FILE);
				File dest=new File("failss.png");
				FileUtils.copyFile(src, dest);
				
			}
			System.out.println("CPUinfo iformation****************");
			
			List<List<Object>> ci=driver.getPerformanceData("com.google.android.calculator", "cpuinfo", 10000);
			for(int i=0;i<ci.size();i++)
			{
				for(int j=0;j<ci.get(i).size();j++) 
				{
					try
					{
				System.out.print(ci.get(i).get(j).toString()+"\t");
					}
					catch(Exception e)
					{
						System.out.print(0);
					}
				}
				System.out.println();
				
			}
			System.out.println("Memoryinfo iformation****************");
			List<List<Object>> mi=driver.getPerformanceData("com.google.android.calculator", "memoryinfo", 10000);
			for(int i=0;i<mi.size();i++)
			{
				for(int j=0;j<mi.get(i).size();j++) 
				{
					try
					{
				System.out.print(mi.get(i).get(j).toString()+"\t");
					}
					catch(Exception e)
					{
						System.out.print(0);
					}
				}
				System.out.println();
				
			}
			System.out.println("Batteryinfo iformation****************");
			
			List<List<Object>> bi=driver.getPerformanceData("com.google.android.calculator", "batteryinfo", 10000);
			for(int i=0;i<bi.size();i++)
			{
				for(int j=0;j<bi.get(i).size();j++) 
				{
					try
					{
				System.out.print(bi.get(i).get(j).toString()+"\t");
					}
					catch(Exception e)
					{
						System.out.print(0);
					}
				}
				System.out.println();
				
			}
			System.out.println("Networkinfo iformation****************");
			List<List<Object>> ni=driver.getPerformanceData("com.google.android.calculator", "networkinfo", 10000);
			for(int i=0;i<ni.size();i++)
			{
				for(int j=0;j<ni.get(i).size();j++) 
				{
					try
					{
				System.out.print(ni.get(i).get(j).toString()+"\t");
					}
					catch(Exception e)
					{
						System.out.print(0);
					}
				}
				System.out.println();
				
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
