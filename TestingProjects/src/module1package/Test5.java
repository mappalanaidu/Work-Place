package module1package;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test5 {

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.way2sms.com/content/index.html?");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(@src, 'android-button')]")).click();
		ArrayList<String>  x=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(x.get(1));
		
		Thread.sleep(5000);
		driver.close();
		driver.switchTo().window(x.get(0));
		Thread.sleep(5000);
		driver.close();
	}

}
