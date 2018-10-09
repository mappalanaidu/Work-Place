package module1package;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.SessionStorage;

public class Test46 {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//SessionStorage s=driver.getSessionStorage();
		
		driver.get("https://www.gmail.com");
		//System.out.println(s.toString());
		System.out.println(driver.getSessionId());
		
		//Thread.sleep(5000);
		driver.get("https://facebook.com");
		//Thread.sleep(5000);
		System.out.println(driver.getSessionId());
		
		driver.get("https://www.google.co.in/");
		//System.out.println(s.toString());
		
		driver.navigate().back();
		//driver.navigate().back();
		//driver.navigate().forward();*/
		System.out.println(driver.getSessionId());
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.navigate().back();
		Thread.sleep(5000);
		driver.quit();
		
	}

}
