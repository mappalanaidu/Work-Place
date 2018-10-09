package module1package;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test48 {

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//driver.manage().window().maximize();
		
		//driver.get("https://www.gmail.com");
		//System.out.println(driver.getSessionId());
		driver.navigate().to("https://facebook.com");
		System.out.println(driver.getSessionId());
		driver.get("https://www.gmail.com");
		driver.navigate().to("https://facebook.com");
		
		driver.navigate().to("https://www.gmail.com");
		
		driver.navigate().to("https://www.google.co.in/");
		System.out.println(driver.getSessionId());
		
		Thread.sleep(5000);
		driver.quit();
	
		
	}

}
