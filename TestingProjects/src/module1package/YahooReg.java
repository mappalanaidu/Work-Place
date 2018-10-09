package module1package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class YahooReg {

	public static void main(String[] args)
	{
		// Yahoo Reg 
		System.setProperty("webdriver.chrome.driver","F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://login.yahoo.com/");
		//Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//driver.findElement(By.name("identifier")).sendKeys("mbhavjeet@gmail.com");
		driver.findElement(By.xpath("//*[@id='createacc']")).click();
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Appala Naidu");
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Marisarla");
		driver.findElement(By.xpath("//input[@name='yid']")).sendKeys("manaidu");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("bhagya530");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9948838954");
		WebElement e=driver.findElement(By.xpath("//input[@name='mm']"));
		Select s=new Select(e);
		s.selectByIndex(7);
		driver.findElement(By.xpath("//input[@name='dd']")).sendKeys();
		
	}

}
