package module1package;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.gmail.com");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[text()=\"Sign In\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("identifier")).sendKeys("mbhavjeet@gmail.com");
		driver.findElement(By.name("signIn")).click();
		driver.findElement(By.xpath("//*[@id=\"Passwd\"]")).sendKeys("9948838954");
		driver.findElement(By.xpath("//*[@id=\"signIn\"]")).click();
		Thread.sleep(5000);
		driver.close();

	}

}

