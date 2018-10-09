package TestClasses;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridRunnerClass {

	public static void main(String[] args) throws Exception 
	{
	System.setProperty("webdriver.chrome.driver", "F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
	URL u1=new URL("http://192.168.43.197:4444/wd/hub");
	DesiredCapabilities dc1=DesiredCapabilities.chrome();
	dc1.setBrowserName("chrome"); 
	dc1.setPlatform(Platform.WINDOWS);
	//dc1.setCapability("path", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
	//capability.setVersion("58.0");  //uncomment this line will throws another exception
	//capability.setCapability(,);
	WebDriver driver1=new RemoteWebDriver(u1,dc1);
	driver1.navigate().to("http://www.google.co.in");
	Thread.sleep(5000);
	driver1.quit();
	System.setProperty("webdriver.gecko.driver", "F:\\Naidu\\TestingSoftwares\\geckodriver.exe");
	
	URL u2=new URL("http://192.168.43.197:4444/wd/hub");
	DesiredCapabilities dc2=DesiredCapabilities.firefox();
	dc1.setBrowserName("firefox"); 
	dc1.setPlatform(Platform.WINDOWS);  
	WebDriver driver2=new RemoteWebDriver(u2,dc2);
	driver2.navigate().to("http://www.google.co.in");
	Thread.sleep(5000);
	driver2.quit();
	
	}

}
