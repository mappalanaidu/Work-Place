package module1package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test30 {

	public static void main(String[] args) throws InterruptedException 
	
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);//it will work entire program, if required
		//way-1 to click a link
		/*driver.findElement(By.name("btnI")).click();
		//way-2 to click a link
		WebElement e=driver.findElement(By.name("btnI"));
		e.click();
		//way-3 to click a link
		 WebElement e=driver.findElement(By.name("btnI"));
		Actions a=new Actions(driver);
		a.click(e).build().perform();
		//way-4 to click a link
			driver.executeScript("document.getElementsByName('btnI')[0].click();");
		//way-5 to click a link
			WebElement e=driver.findElement(By.name("btnI"));
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", e);
		//way-6 to click a link
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementsByName('btnI')[0].click();");*/
		//way-7 to click a link
		WebElement e=driver.findElement(By.name("btnI"));
		driver.executeScript("arguments[0].click();", e);
		
		Thread.sleep(5000);
		//close site
		driver.close();
		
			
	}

}
