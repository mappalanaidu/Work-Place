package module1package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test21 {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.google.co.in");
		///Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);//it will work entire program, if required
		//double click 
		WebElement e=driver.findElement(By.name("q"));
		//WebElement e1=driver.findElement(By.xpath("//*[text()='Women']"));
		Actions a=new Actions(driver);
		a.sendKeys(e, "kalam").build().perform();
		//a.doubleClick(e).build().perform();
		//a.moveToElement(e1).build().perform();
		a.contextClick().build().perform();
		//a.sendKeys(Keys.PAGE_DOWN).build().perform();
		//Thread.sleep(5000);
		//a.sendKeys(Keys.PAGE_UP).build().perform();
		for(int i=0;i<=10;i++)
		{
			a.sendKeys(Keys.DOWN).build().perform();
			Thread.sleep(5000);
			
		}
		driver.close();
	}

}
