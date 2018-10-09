package module1package;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class Test1 {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.facebook.com");
		Thread.sleep(5000);
		driver.findElement(By.name("email")).sendKeys("9948838954");
		driver.findElement(By.name("pass")).sendKeys("bhagya530");
		driver.findElement(By.id("u_0_2")).click();
		Thread.sleep(5000);
		driver.close();
		
		
		/**System.setProperty("webdriver.ie.driver","F:\\Naidu\\Testing Softwares\\IEDriverServer.exe");
		InternetExplorerDriver driver=new InternetExplorerDriver();
		driver.get("http://www.facebook.com");
		Thread.sleep(5000);
		driver.quit();*/
		
		/**System.setProperty("webdriver.gecko.driver","F:\\Naidu\\Testing Softwares\\geckodriver.exe");
		FirefoxDriver driver1=new FirefoxDriver();
		driver1.get("http://www.google.co.in");
		Thread.sleep(5000);
		driver1.close();*/
		
		/**OperaOptions o=new OperaOptions();
		o.setBinary("C:\\Program Files (x86)\\Opera\\53.0.2907.99\\opera.exe");
		
		System.setProperty("webdriver.opera.driver","F:\\Naidu\\Testing Softwares\\operadriver_win64\\operadriver.exe");
		OperaDriver driver2=new OperaDriver(o);
		driver2.get("http://www.facebook.com");
		Thread.sleep(5000);
		driver2.close();*/
		
		
	}

}
