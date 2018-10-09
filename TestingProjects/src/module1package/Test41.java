package module1package;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test41 {

	public static void main(String[] args) throws Exception
	
	{
		System.setProperty("webdriver.chrome.driver","F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.seleniumhq.org/");
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download")));
		driver.manage().window().maximize();
		//driver.findElement(By.linkText("Download")).click();		
		Actions a=new Actions(driver);
		WebElement e=driver.findElement(By.linkText("Download"));
		a.contextClick(e).build().perform();
		Thread.sleep(5000);
		//automate win-menu using java Robot
			Robot r=new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		driver.switchTo().defaultContent();	
		w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download")));
		WebElement e1=driver.findElement(By.linkText("Download"));
		a.contextClick(e1).build().perform();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		driver.switchTo().defaultContent();	
		w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download")));
		WebElement e2=driver.findElement(By.linkText("Download"));
		a.contextClick(e2).build().perform();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(5000);
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(10000);
		
		driver.close();
		Thread.sleep(20000);
		driver.quit();
		
	}

}
