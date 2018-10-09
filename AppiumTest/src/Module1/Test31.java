package Module1;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Test31 {

	public static void main(String[] args) throws Exception
	{
		// enter platform name computer or mobile
		Scanner sc=new Scanner(System.in);
		System.out.println("enter platform name");
		String p=sc.nextLine();
		
		//driver object declearation
		WebDriver driver;

		if(p.equalsIgnoreCase("computer"))
		{
			System.setProperty("webdriver.chrome.driver","F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
			 driver=new ChromeDriver();
			
		}
		else
		{
			//Provide details of device(ARD) and app
			DesiredCapabilities dc=new DesiredCapabilities();
			dc.setCapability(CapabilityType.BROWSER_NAME, "chrome");
			dc.setCapability("deviceName", "HNB0ZC4E");
			dc.setCapability("platformName", "android");
			dc.setCapability("platformVersion", "6.0");
			
			//Start appium server
			Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
			URL u=new URL("http://0.0.0.0:4723/wd/hub");
			
			//create object for AndroidDriver to launch app
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
		}
		//automation common code 
		try
		{
			driver.get("https://www.gmail.com");
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			WebDriverWait w=new WebDriverWait(driver, 100);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
			driver.findElement(By.name("identifier")).sendKeys("naiduverseskusuma@gmail.com");
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id,'identifierNext')]")));
			driver.findElement(By.xpath("//*[contains(@id,'identifierNext')]")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
			driver.findElement(By.name("password")).sendKeys("9948838954");
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@id,'passwordNext')]")));
			driver.findElement(By.xpath("//*[contains(@id,'passwordNext')]")).click();
			
			List<WebElement> l=driver.findElements(By.xpath("(//table)[6]/tbody/tr"));
			System.out.println("Number of mails in inbox : "+l.size());
			
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@title,'Google Account')]")));
			
			driver.findElement(By.xpath("//*[contains(@title,'Google Account')]")).click();
			
			w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign out")));
			
			driver.findElement(By.linkText("Sign out")).click();
							
			driver.close();

			if(p.equalsIgnoreCase("mobile"))
			{
			//stop appium server
			Runtime.getRuntime().exec("taskkill /F /IM node.exe");
			Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
			}

		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			
		}
		
	}

}
