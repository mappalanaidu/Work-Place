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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Test32 {

	public static void main(String[] args) throws Exception 
	
	{
		// enter platform name computer or mobile
				Scanner sc=new Scanner(System.in);
				System.out.println("enter platform name");
				String p=sc.nextLine();
				
				//driver object declearation
				WebDriver driver=null;

				if(p.equalsIgnoreCase("computer"))
				{
					System.setProperty("webdriver.chrome.driver","F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
					 driver=new ChromeDriver();
					
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
				else 
				{
					System.out.println("Please enter either Mobile or Computer as Platform Name");
				}
				
				//automation common code 
				try
				{
					driver.get("http://www.newtours.demoaut.com/");
					//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
					//driver.manage().window().maximize();
					WebDriverWait w=new WebDriverWait(driver, 100);
					w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("REGISTER")));
					driver.findElement(By.linkText("REGISTER")).click();
					w.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
					driver.findElement(By.name("firstName")).sendKeys("Appala Naidu");
					driver.findElement(By.name("lastName")).sendKeys("Marisarla");
					driver.findElement(By.name("phone")).sendKeys("9948838954");
					driver.findElement(By.name("userName")).sendKeys("mbhavjeet@gmail.com");
					
					driver.findElement(By.name("address1")).sendKeys("Ampavalli,Balijipeta");
					driver.findElement(By.name("city")).sendKeys("Vizianagaram");
					driver.findElement(By.name("state")).sendKeys("AP");
					driver.findElement(By.name("postalCode")).sendKeys("535 557");
					WebElement e=driver.findElement(By.name("country"));
					Select s=new Select(e);
					s.selectByVisibleText("INDIA");
					driver.findElement(By.name("email")).sendKeys("mbhavjeet@gmail.com");
					driver.findElement(By.name("password")).sendKeys("9948838954");
					driver.findElement(By.name("confirmPassword")).sendKeys("9948838954");
					
					//WebElement e1=driver.findElement(By.name("register"));
				
					driver.findElement(By.name("register")).submit();
					
					/*if(p.equalsIgnoreCase("mobile"))
						driver.findElement(By.xpath("//input[@type='image']")).click();
					driver.findElement(By.name("register")).click();*/
					
					w.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("sign-in")));
					
					if(driver.findElement(By.partialLinkText("sign-in")).isDisplayed())
					{
						System.out.println("Your Registration is Successfull");
						driver.findElement(By.partialLinkText("sign-in")).click();
						w.until(ExpectedConditions.visibilityOfElementLocated(By.name("userName")));
						driver.findElement(By.name("userName")).sendKeys("mbhavjeet@gmail.com");
						driver.findElement(By.name("password")).sendKeys("9948838954");
						//if(p.equalsIgnoreCase("mobile"))
						//	driver.findElement(By.name("Login")).click();
						driver.findElement(By.name("login")).submit();
												
						}else
					{
						System.out.println("Your Registration is Not Successfull");
						
					}
															
					//Close driver object									
					//driver.close();

					if(p.equalsIgnoreCase("mobile"))
					{
					//stop appium server
					Runtime.getRuntime().exec("taskkill /F /IM node.exe");
					Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
					} 

				}
				catch(Exception ex)
				{
					System.out.println("Exception for Reasion :"+ex.getMessage());
					
				}
				

	}

}
