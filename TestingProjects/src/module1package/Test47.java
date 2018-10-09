package module1package;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.SessionStorage;

public class Test47 {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//SessionStorage s=driver.getSessionStorage();
		
		driver.navigate().to("https://www.google.co.in/");
		/*//System.out.println(s.toString());
		System.out.println(driver.getSessionId());
		
		driver.navigate().to("https://www.gmail.com");
		//System.out.println(s.toString());
		System.out.println(driver.getSessionId());
		
		driver.navigate().to("https://facebook.com");
		System.out.println(driver.getSessionId());
		
		//Thread.sleep(5000);*/
		driver.navigate().to("https://www.gmail.com");
		driver.navigate().back();
		//driver.navigate().back();
		driver.navigate().forward();
		//System.out.println(s.toString());
		
		driver.navigate().refresh();
		driver.navigate().forward();
		Thread.sleep(5000);
		driver.quit();
	
	}

}
