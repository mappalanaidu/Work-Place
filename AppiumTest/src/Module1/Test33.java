package Module1;

import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Button;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Test33 
{

	public static void main(String[] args) throws Exception
	{
		// enter platform name computer or mobile
		Scanner sc=new Scanner(System.in);
		System.out.println("enter platform name");
		String p=sc.nextLine();
		
		if(p.equalsIgnoreCase("computer"))
		{
			System.setProperty("webdriver.chrome.driver","F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
			ChromeDriver driver=new ChromeDriver();
			driver.get("https://www.youtube.com/");
			WebDriverWait w=new WebDriverWait(driver,100);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.name("search_query")));
			driver.manage().window().maximize();
			driver.findElement(By.name("search_query")).sendKeys("abdul kalam speeches");
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@aria-label='Search'])[3]/child::*[1]")));
			driver.findElement(By.xpath("(//*[@aria-label='Search'])[3]/child::*[1]")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@aria-label, 'Dr. A P J Abdul Kalam in European Parliament')]")));
			driver.findElement(By.xpath("//*[contains(@aria-label, 'Dr. A P J Abdul Kalam in European Parliament')]")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(), 'Dr. A P J Abdul Kalam in European Parliament')])[3]")));
			//automate video elements(sikulix)
			Screen s=new Screen();
			Thread.sleep(5000);
			if(s.exists("skipadd.PNG")!=null)
			{
				s.click("skipadd.PNG");
			}
			//pause
			Thread.sleep(5000);
			Location l=new Location(300,300);
			s.wheel(l, Button.LEFT, 0);
			s.click("pause.PNG");
			Thread.sleep(5000);
			//move mouse pointer to video body
			s.wheel(l, Button.LEFT, 0);
			s.click("play.PNG");
			Thread.sleep(5000);
			s.wheel(l, Button.LEFT, 0);
			s.mouseMove("mute.PNG");
		//aotomate sloider frome left to right
			Match e=s.find("buble.PNG");
			int x=e.getX();
			int y=e.getY();
			Location el1=new Location(x-20,y);
			s.dragDrop(e,el1);
			Thread.sleep(5000);
			//aotomate sloider frome right to left
					Location el2=new Location(x+40,y);
					s.dragDrop(e,el2);
					Thread.sleep(5000);
					//close site
					driver.close();

		}
		else if(p.equalsIgnoreCase("mobile"))
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
			AndroidDriver driver=null;
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
			//Mobile automation code
			driver.get("https://www.youtube.com/");
			//change the context from WEB_VIEW to NATIVE_APP
			driver.context("NATIVE_APP");
			WebDriverWait w=new WebDriverWait(driver,100);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Search YouTube'][@index='2']")));
			//WebElement e=driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Search YouTube\")");
		WebElement e=driver.findElement(By.xpath("//*[@text='Search YouTube'][@index='2']"));
		TouchAction ta=new TouchAction(driver);
		int x=e.getLocation().getX();
		int y=e.getLocation().getY();
		
		System.out.println("X :"+x +"  "+x/2);
		System.out.println("Y :"+y+"  "+y/2);
		WebElement e1=driver.findElement(By.xpath("//*[@text='Account'][@index='2']"));
		int r=e1.getLocation().getX();
		int q=e1.getLocation().getY();
		
		System.out.println("R :"+r +"  "+r/2);
		System.out.println("Q :"+q+"  "+q/2);	
			ta.longPress(x-10,y-10).release().perform();//tab on search youtube
			
				
			//stop appium server
			Runtime.getRuntime().exec("taskkill /F /IM node.exe");
			Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
					
			
		}
		else 
		{
			System.out.println("Please enter either Mobile or Computer as Platform Name");
		}
		
		}

}
