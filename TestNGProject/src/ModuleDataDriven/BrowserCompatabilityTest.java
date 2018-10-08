package ModuleDataDriven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BrowserCompatabilityTest 
{
	public WebDriver driver;
	public WebDriverWait wait;
	String x="firefox";
  @Test(priority=0)
  public void launch()
  {
	//open our intrusted browser
	  if(x.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
			 driver=new ChromeDriver();//obj defined			
		}
		else if(x.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "F:\\Naidu\\TestingSoftwares\\geckodriver.exe");
			 driver=new FirefoxDriver();//obj defined			
	
		}
		else if(x.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "F:\\Naidu\\TestingSoftwares\\iedriverserver.exe");
			 driver=new InternetExplorerDriver();//obj defined			
	
		}
		else if(x.equalsIgnoreCase("opera"))
		{
			OperaOptions o=new OperaOptions();
			o.setBinary("C:\\Program Files\\Opera\\55.0.2994.56\\opera.exe");
			System.setProperty("webdriver.opera.driver", "F:\\Naidu\\TestingSoftwares\\operadriver_win64\\operadriver_win64\\operadriver.exe");
			 driver=new OperaDriver(o);//obj defined			
	
		}
		else
		{
		System.out.println("Invalid Browser");	
		System.exit(0);//0 means forcble stop execution
		}
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.google.co.in/");
		wait=new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='q']")));
		driver.manage().window().maximize();
		//return ("Done");
		}
  
  
  @Test(priority=1)
  public void fill()
  		{
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='q']")));
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("kalam",Keys.ENTER);
		}

  @Test(priority=2)
  public void close() throws Exception
  		{

		Thread.sleep(5000);
		driver.close();
		}

 }
