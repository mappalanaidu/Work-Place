package Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;

public class Gluecode 
{
	public AndroidDriver driver;
	public WebDriverWait wait;
	
	public Scenario s;
	public Properties p;
	public String a;
	public String b;
	
	@Before
	public void method1(Scenario s) throws Exception
		{
		//use Scenarion obj for current Scenario
		this.s=s;
		//load properties file for current Scenario
		p=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\Naidu\\TestingWorkSpace\\AppTestingWithCucumberAndMaven\\src\\test\\resources\\Resources\\Properties.properites");
		p.load(fis);
		}
	
	@Given("^Launch app$")
	public void method1() throws Exception
	{

		//Provide details of device(ARD) and app
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, p.getProperty("bname"));
		dc.setCapability("deviceName", p.getProperty("deviceName"));
		dc.setCapability("platformName", p.getProperty("platformName"));
		dc.setCapability("platformVersion", p.getProperty("platformVersion"));
		dc.setCapability("appPackage", p.getProperty("appPackage"));
		dc.setCapability("appActivity", p.getProperty("appActivity"));
		
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
		wait=new WebDriverWait(driver,30);
	}
	
	
	@Then("^app contains \"(.*)\"$")
	public void method2(String a)
	   {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='9']")));
		
		String t=driver.findElement(By.xpath("//*[@text='9']")).getText();
		if(t.contains(a))
		{
			s.write("App test Passed");
		}
		else
		{
			
			byte ssbytes[]=this.screenshot();
			s.embed(ssbytes, "App test Failed");
			Assert.fail();
		}
	   }
	
	
	@And("^close app$")
	public void method3()
	{
		driver.closeApp();
	}
	
	@When("^enter first number as \"(.*)\"$")
	public void method4(String x)
	   {
		a=x;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='9']")));
		//enter input 1
		for(int i=0;i<x.length();i++)
		{
			char d=x.charAt(i);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='"+d+"']")));
				driver.findElement(By.xpath("//*[@text='"+d+"']")).click();
		}
	   }
	
	@And("^click plus$")
	public void method5()
	{	
	//Click +
		driver.findElement(By.xpath("//*[@content-desc='plus']")).click();
		
	}
	
	@And("^enter second number as \"(.*)\"$")
	public void method6(String y)
	   {
		b=y;
		//enter input 2
		for(int i=0;i<y.length();i++)
		{
			char d=y.charAt(i);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='"+d+"']")));
			driver.findElement(By.xpath("//*[@text='"+d+"']")).click();
		}
	   }
		@And("^click equels$")
		public void method7()
		{	
		//Click =
		driver.findElement(By.xpath("//*[@content-desc='equals']")).click();
		}
		
		@And("^validate output$")
		public void method8() throws Exception
		{
		//get output and validate
		
		String z=driver.findElement(By.xpath("//*[@class='android.widget.TextView']")).getAttribute("text");
		System.out.println("Result :"+z);
		
		if(Integer.parseInt(z)==Integer.parseInt(a)+Integer.parseInt(b))
		{
			
			s.write(z+"  : Addition test Passed");
			System.out.println("Test Passed");
			/*File src=driver.getScreenshotAs(OutputType.FILE);
			File dest=new File("passss.png");
			FileUtils.copyFile(src, dest);
			*/
			byte ssbytes[]=this.screenshot();
			s.embed(ssbytes, "Addition test Passed");
		}
		else
		{
			s.write(z=a+b+"  : Addition test Failed");
			System.out.println("Test Failed");

			byte ssbytes[]=this.screenshot();
			s.embed(ssbytes, "Addition test Failed");
			Assert.fail();
			
		}
	
	   }
	
	//@And("^stop appium server$")
	@After
	public void stopserver() throws Exception
		{
		//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");

		}
	
	
	public byte[] screenshot()
	{
		byte ssbytes[]=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		return (ssbytes);
		
		/*File src=driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("failss.png");
		FileUtils.copyFile(src, dest);*/
	}
	
}
