package module1package;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test14 {

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.gmail.com");
		//Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.name("identifier")).sendKeys("mbhavjeet@gmail.com");
		driver.findElement(By.xpath("//*[contains(@id,'identifierNext')]")).click();
		driver.findElement(By.name("password")).sendKeys("9948838954");
		driver.findElement(By.xpath("//*[contains(@id,'passwordNext')]")).click();
		
		driver.findElement(By.xpath("(//table)[6]/tbody/tr[3]/td[2]/div")).click();
		Thread.sleep(10000);
		//driver.findElement(By.xpath("//*[contains(@class,'ar9 T-I-J3 J-J5-Ji')]")).click();
		//driver.findElement(By.xpath("//*[@gh='mtb']/div/div/child::div[2]/child::div[3]")).click();
		driver.findElement(By.xpath("//*[@gh='mtb']/div/div/child::div[2]/child::div[3]/div/div")).click();
		driver.findElement(By.xpath("//*[contains(@title,'Google Account')]")).click();
		driver.findElement(By.linkText("Sign out")).click();
						
		Thread.sleep(5000);
		driver.close();

			}

}
