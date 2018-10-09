package module1package;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AirIndiaAutomationTest
{
	public static void main(String[] args) 
	{
		// Yahoo Reg 
		System.setProperty("webdriver.chrome.driver","F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.airindia.in/");
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Manage Your Trip")));
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Manage Your Trip")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Book a Flight")));
		driver.findElement(By.linkText("Book a Flight")).click();
		ArrayList<String>  x=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(x.get(1));
		//System.out.println(a.size());
		//ArrayList<String> al=((ArrayList<String>)s);
		//driver.switchTo().window((String)a.get(0));
		//System.out.println(a.size());
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("wdforigin1")));
		WebElement e1=driver.findElement(By.id("wdforigin1"));
		Select s1=new Select(e1);
		s1.selectByIndex(2);
		
		WebElement e2=driver.findElement(By.id("wdfdest1"));
		Select s2=new Select(e2);
		s2.selectByIndex(4);
		
		WebElement e3=driver.findElement(By.id("wdfdow1"));
		Select s3=new Select(e3);
		s3.selectByIndex(3);
		
		//driver.findElement(By.xpath("//*[contains(@aria-label, 'Click Yes if you would like to book')]")).click();
		
		//WebElement e7=driver.findElement(By.id("wdfdate1"));
		driver.executeScript("document.getElementById('wdfdate1').value ='25/10/2018'");
		//driver.executeScript("arguments[0].setAttribute('value','25/10/2018');", e7);
		
		WebElement e4=driver.findElement(By.id("paxadult0"));
		Select s4=new Select(e4);
		s4.selectByIndex(3);
		
		WebElement e5=driver.findElement(By.id("paxchild0"));
		Select s5=new Select(e5);
		s5.selectByIndex(3);
		
		WebElement e6=driver.findElement(By.id("paxinfant0"));
		Select s6=new Select(e6);
		s6.selectByIndex(3);
		
		//		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("couponRefInput")));
		driver.findElement(By.id("couponRefInput")).sendKeys("535557");
		
	}
}