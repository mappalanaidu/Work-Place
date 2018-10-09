package module1package;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test31 {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);//it will work entire program, if required
		//way-1 to send data
		//driver.findElement(By.name("q")).sendKeys("kalam");
		//way-2 to send data
		/*WebElement e=driver.findElement(By.name("q"));
		e.sendKeys("kalam");
		//way-3 to send data
		WebElement e=driver.findElement(By.name("q"));
		Actions a=new Actions(driver);
		a.sendKeys(e, "kalam").build().perform();
		//way-4 to send data
		driver.executeScript("document.getElementsByName('q')[0].value='kalam';");
		//way-5 to send data
		WebElement e=driver.findElement(By.name("q"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='kalam';", e);
		//way-6 to send data
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementsByName('q')[0].value='kalam';");*/
		//way-7 to send data
		WebElement e=driver.findElement(By.name("q"));
		driver.executeScript("arguments[0].value='kalam';", e);
		Thread.sleep(5000);
		//close site
		driver.close();
				
	}

}
