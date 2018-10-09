package module1package;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Test27 {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);//it will work entire program, if required
		//Open multi select dropdown list
		WebElement e=driver.findElement(By.xpath("(//*[contains(@class, 'ui fluid dropdown')])[1]"));
		Actions a=new Actions(driver);
		a.click(e).build().perform();
		
	//get all items from the drop down list
		List<WebElement> l=driver.findElements(By.xpath("//*[@class= 'menu transition visible']/div"));
		//Select s=new Select(e);
		System.out.println(l.size());
		for(int i=0;i<l.size();i++)
		{
			System.out.println(l.get(i).getText());
		}
		//select 3rd & 4th element in that list
		driver.findElement(By.xpath("//*[@class= 'menu transition visible']/div[1]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class= 'menu transition visible']/div[4]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class= 'menu transition visible']/div[12]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class= 'menu transition visible']/div[14]")).click();
		Thread.sleep(5000);
		System.out.println("3rd  4th item was selected form list");
		//delete specipic item from selected list
		driver.findElement(By.xpath("//*[contains(@class, 'multiple upward')]/a[1]/i")).click();
		driver.findElement(By.xpath("//*[contains(@class, 'multiple upward')]/a[1]/i")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(@class, 'multiple upward')]/a[2]/i")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(@class, 'multiple upward')]/a[1]/i")).click();
		
		//close site
		driver.close();
		
	}

}
