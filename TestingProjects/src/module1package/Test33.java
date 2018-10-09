package module1package;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test33 {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ui dropdown'][1]")));
		driver.manage().window().maximize();
		//get all elements for div tag drop  down 
		List<WebElement> l=driver.findElements(By.xpath("//*[@class='ui dropdown'][1]/div[2]/div"));
		System.out.println(l.size());
		for(int i=0;i<l.size();i++)
		{
			driver.executeScript("var x=arguments[0].textContent; window.alert(x);", l.get(i));
			String y=driver.switchTo().alert().getText();
			System.out.println(y);
			Thread.sleep(5000);
			driver.switchTo().alert().dismiss();	
			
		}

		driver.close();
	}

}
