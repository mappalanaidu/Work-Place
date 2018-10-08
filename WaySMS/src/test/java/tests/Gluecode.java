package tests;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.HomePage;
import Pages.SendSMSPage;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Gluecode 
{
public WebDriver driver;
public WebDriverWait wait;
public HomePage hp;
public SendSMSPage sp;
public Scenario s;
public Properties p;

@Before
public void method1(Scenario s) throws Exception
	{
	//use Scenarion obj for current Scenario
	this.s=s;
	//load properties file for current Scenario
	p=new Properties();
	FileInputStream fis=new FileInputStream("C:\\Users\\Naidu\\TestingWorkSpace\\WaySMS\\src\\test\\resources\\PropertiesResource\\w2sms.properties");
	p.load(fis);
	}
@Given("^Launch site using \"(.*)\"$")
public void method2(String e)
{
	//open our intrusted browser
	  if(e.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
			 driver=new ChromeDriver();//obj defined			
		}
		else if(e.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "F:\\Naidu\\TestingSoftwares\\geckodriver.exe");
			 driver=new FirefoxDriver();//obj defined			
	
		}
		else if(e.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "F:\\Naidu\\TestingSoftwares\\iedriverserver.exe");
			 driver=new InternetExplorerDriver();//obj defined			
	
		}
		else
		{
			OperaOptions o=new OperaOptions();
			o.setBinary("C:\\Program Files\\Opera\\55.0.2994.56\\opera.exe");
			System.setProperty("webdriver.opera.driver", "F:\\Naidu\\TestingSoftwares\\operadriver_win64\\operadriver_win64\\operadriver.exe");
			 driver=new OperaDriver(o);//obj defined			
		}
		//create objes to page classes
	  hp=new HomePage(driver);
	  sp=new SendSMSPage(driver);
	  //open site
	  	driver.get(p.getProperty("url"));
	  	//define wait obj
	wait=new WebDriverWait(driver,50);
	
	wait.until(ExpectedConditions.visibilityOf(hp.mbno));
	driver.manage().window().maximize();
	}
@Then("^title contains \"(.*)\"$")
public void method3(String a)
   {
	wait.until(ExpectedConditions.visibilityOf(hp.mbno));
	String t=driver.getTitle();
	if(t.contains(a))
	{
		s.write("Title test Passed");
	}
	else
	{
		byte ssbytes[]=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		s.embed(ssbytes, "Title test Failed");
		Assert.fail();
	}
   }
@And("^close site$")
public void method4()
{
	driver.close();
}
@When("enter mobile number as \"(.*)\"$")
public void method5(String u)
   {
	wait.until(ExpectedConditions.visibilityOf(hp.mbno));
	hp.fillmbno(u);
   }
@And("enter password as \"(.*)\"$")
public void method6(String p)
{
	wait.until(ExpectedConditions.visibilityOf(hp.pwd));
	hp.fillpwd(p);
}
@And("^click login$")
public void method7()
	{
	wait.until(ExpectedConditions.visibilityOf(hp.signin));
	hp.clicksignin();
	}
@Then("^validate output for criteria \"(.*)\"$")
public void method8(String c) throws Exception
{
	wait.until(temp->((JavascriptExecutor)driver).executeScript("return document.readyState;").equals("complete"));
		Thread.sleep(5000);
		try
		{
			if(c.equals("all_vlid") && sp.sendsms.isDisplayed())
			{
				s.write("Test Passed for valid data");
			}
			else if(c.equals("all_vlid") && driver.findElement(By.xpath("//a[@href='send-sms'][@class='active']/span")).isDisplayed())
			{
				s.write("Test Passed for valid data");
			}
			else if(c.equals("mbno_invalid") && hp.mbno_invalid_err.isDisplayed())
			{
				s.write("Test Passed for mobile number invalid");
			}
			else if(c.equals("mbno_blank") && hp.mbno_blank_err.isDisplayed())
			{
				s.write("Test Passed for mobile number blank");
			}
			else if(c.equals("pwd_blank") && hp.pwd_blank_err.isDisplayed())
			{
				s.write("Test Passed for password blank");
			}
			else if(c.equals("pwd_invalid") && hp.pwd_invalid_err.isDisplayed())
			{
				s.write("Test Passed for password invalid");
			}
			else
			{
				byte ssbytes[]=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				s.embed(ssbytes, "Login test Failed");
				Assert.fail();
			}
		}
		catch(Exception ex)
		{
			byte ssbytes[]=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			s.embed(ssbytes, ex.getMessage());
		}
    }

@When("^do login with valid data$")
public void method9(DataTable dt)
{
	List<List<String>> l=dt.asLists(String.class);
	hp.fillmbno(l.get(1).get(0));
	hp.fillpwd(l.get(1).get(1));
	hp.clicksignin();
}
@And("^do lougout$")
public void method10() throws Exception
{
	wait.until(temp->((JavascriptExecutor)driver).executeScript("return document.readyState;").equals("complete"));
	
	try
	{
		Thread.sleep(5000);
		if(sp.menu.isDisplayed())
		{
			sp.clickmenu();
			wait.until(ExpectedConditions.visibilityOf(sp.logout));
			sp.logoutclick();
			
		}
	}
	catch(Exception ex)
	{
		driver.findElement(By.xpath("//*[@class='logout']")).click();
	}
  }

@Then("^home page will be reopened$")
public void method11(DataTable dt)
{
	if(hp.mbno.isDisplayed())
	{
		s.write("Logout Successfully");
	}
	else
	{
		byte ssbytes[]=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		s.embed(ssbytes, "Unsuccessful Logout");
		Assert.fail();
	}
  }
}