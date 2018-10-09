package TestClasses;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TesterClass {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver", "F:\\Naidu\\TestingSoftwares\\geckodriver.exe");
		
		//System.setProperty("webdriver.gecko.driver", "/home/eason/JavaTest/geckodriver.exe"); //geckodriver-v0.21.0-linux64.tar.gz
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		capability.setBrowserName("firefox"); 
		capability.setPlatform(Platform.WIN8_1);  
		//capability.setVersion("58.0");  //uncomment this line will throws another exception
		//capability.setCapability(,);
		WebDriver vmDriver = null;
		try {
			vmDriver = new RemoteWebDriver(new URL("http://192.168.43.197:4444/wd/hub"), capability);
		} catch (Exception e) {
			System.out.print("Exception: ");
			e.printStackTrace();
		}
		System.out.println(vmDriver.getTitle());
		vmDriver.get("https://hk.yahoo.com/");
	}

}
