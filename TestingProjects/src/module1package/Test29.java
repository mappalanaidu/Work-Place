package module1package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test29 {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.goindigo.in/");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);//it will work entire program, if required
		//way-1 to click radio button
		/*driver.findElement(By.xpath("(//*[@class='ios-ui-select-ex'])[8]")).click();
		//way-2 to click radio button
		WebElement e=driver.findElement(By.xpath("(//*[@class='ios-ui-select-ex'])[9]"));
		e.click();
		//way-3 to click radio button
		WebElement e=driver.findElement(By.xpath("(//*[@class='ios-ui-select-ex'])[6]"));
		Actions a=new Actions(driver);
		a.click(e).build().perform();
		//way-4 to click radio button
		WebElement e=driver.findElement(By.xpath("(//*[@class='ios-ui-select-ex'])[7]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", e);*/
		//way-5 to click radio button
		WebElement e=driver.findElement(By.xpath("(//*[@class='ios-ui-select-ex'])[10]"));
		driver.executeScript("arguments[0].click();", e);
								
		
	}
}