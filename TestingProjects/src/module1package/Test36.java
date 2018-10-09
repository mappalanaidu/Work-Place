package module1package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Test36 {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		//explicit wait
		FluentWait f=new FluentWait(driver);
		f.withTimeout(100,TimeUnit.SECONDS);
		f.pollingEvery(2,TimeUnit.SECONDS);
		f.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='calendarContainer']")));
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[text()='11']")).click();
		//explicit wait
		f.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='raDiv']")));
		driver.close();
		
	
	}

}
