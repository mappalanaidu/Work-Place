package module1package;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MonsterRegForm {

	public static void main(String[] args)
	{
		// Yahoo Reg 
				System.setProperty("webdriver.chrome.driver","F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
				ChromeDriver driver=new ChromeDriver();
				driver.get("http://my.monsterindia.com/create_account.html");
				WebDriverWait w=new WebDriverWait(driver,100);
				//driver.switchTo().frame("_yuiResizeMonitor");
				w.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
				driver.manage().window().maximize();
				driver.findElement(By.name("firstName")).sendKeys("Appala Naidu");
				
				driver.findElement(By.name("lastName")).sendKeys("Marisarla");
				
				driver.findElement(By.name("email")).sendKeys("mbhavjeet@gmail.com");
				
				driver.findElement(By.name("passwd")).sendKeys("bhagya530");
				WebElement e1=driver.findElement(By.xpath("//*[@id='select2-chosen-1']"));
				Actions a=new Actions(driver);
				a.click(e1).build().perform();
				List<WebElement> l=driver.findElements(By.xpath("//*[@id='select2-drop']/ul/li"));
				a.click(l.get(5)).build().perform();
				a.release().build().perform();
				driver.findElement(By.name("mobile")).sendKeys("9948838954");
				WebElement e2=driver.findElement(By.xpath("//*[@id='expYrMonth']"));
				//Actions a1=new Actions(driver);
				a.click(e2).build().perform();
				List<WebElement> l1=driver.findElements(By.xpath("//*[@class='select_popup_inner']/div[4]/label"));
				a.click(l1.get(4)).build().perform();
				//a.release().build().perform();
				List<WebElement> l2=driver.findElements(By.xpath("//*[@class='select_popup_inner']/div[5]/label"));
				a.click(l2.get(9)).build().perform();
				a.release().build().perform();
				driver.findElement(By.xpath("//*[@class='right clip_image closedropdown']")).click();
				
				driver.findElement(By.name("keySkills")).sendKeys("MCA");
				//WebElement e3=driver.findElement(By.xpath("//div[text()='Industry']"));
				driver.executeScript("document.getElementById('ind').click();");
				//a.click(e3).build().perform();
				List<WebElement> l3=driver.findElements(By.xpath("//*[contains(@class,'select_action jq2')]"));
				a.click(l3.get(5)).build().perform();
				driver.findElement(By.xpath("//*[@class='right clip_image closedropdown']")).click();
				
				driver.executeScript("document.getElementById('cat').click();");
				//a.click(e3).build().perform();
				List<WebElement> l4=driver.findElements(By.xpath("(//*[contains(@class,'select_item jq3')])[2]/following-sibling::div"));
				a.click(l4.get(5)).build().perform();
				driver.findElement(By.xpath("//*[@class='right clip_image closedropdown']")).click();
				
				
				
				
				
				
	}

}
