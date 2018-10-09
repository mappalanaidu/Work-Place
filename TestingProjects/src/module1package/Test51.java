package module1package;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test51 {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.gmail.com");
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		driver.manage().window().maximize();
		
		driver.findElement(By.name("identifier")).sendKeys("naiduverseskusuma@gmail.com");
		driver.findElement(By.xpath("//*[contains(@id,'identifierNext')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		driver.findElement(By.name("password")).sendKeys("9948838954");
		driver.findElement(By.xpath("//*[contains(@id,'passwordNext')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='gb_9a gbii']")));
		
		List<WebElement> l=driver.findElements(By.xpath("(//table)[4]/tbody/tr"));
		System.out.println("Number of mails in inbox : "+l.size());
		int count=0;
		for(int i=1;i<l.size();i++)
		{
			String t=driver.findElement(By.xpath("(//table)[4]/tbody/tr["+i+"]/td[5]")).getText();
			if(t.contains("BookMyShow"))
			{
			count++;
			}
		}
		driver.findElement(By.xpath("//*[@class='gb_9a gbii']")).click();
		driver.findElement(By.linkText("Sign out")).click();
		System.out.println("No. of Mails from BookMyShow :"+count);				
		driver.close();
		
	}

}
