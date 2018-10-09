package module1package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Test18 {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/TAGs/tryit.asp?filename=tryhtml_select");
		///Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);//it will work entire program, if required
		driver.switchTo().frame("iframeResult");
		WebElement e=driver.findElement(By.xpath("//*[@contenteditable='false']/select"));
		Select s=new Select(e);
		//List<WebElement> l=s.getOptions();
		//System.out.println(l.size());
		if(s.isMultiple())
		{
			System.out.println(" Multiple Select drop-down box");
		}
		else
		{
			System.out.println("Single Select drop-down box & the selected values are :");
			//Actions a=new Actions(driver);
			System.out.println("select by index value is:");
			s.selectByIndex(2);
			Thread.sleep(5000);
			s.selectByValue("audi");
			Thread.sleep(5000);
			s.selectByVisibleText("Opel");
			Thread.sleep(5000);
			
			}
			
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		System.out.println("Program is Successfully executed ");
		driver.close();

	}

}
