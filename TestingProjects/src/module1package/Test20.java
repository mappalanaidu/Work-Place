package module1package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test20 {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		///Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);//it will work entire program, if required
		//double click 
		WebElement e=driver.findElement(By.xpath("//*[@class='_2AkmmA _29YdH8']"));
		WebElement e1=driver.findElement(By.xpath("//*[text()='Women']"));
		Actions a=new Actions(driver);
		a.click(e).build().perform();
		a.moveToElement(e1).build().perform();
		//a.contextClick().build().perform();
	}

}
