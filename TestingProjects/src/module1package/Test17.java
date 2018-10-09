package module1package;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Test17 {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/TAGs/tryit.asp?filename=tryhtml_select_multiple");
		///Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);//it will work entire program, if required
		driver.switchTo().frame("iframeResult");
		WebElement e=driver.findElement(By.name("cars"));
		Select s=new Select(e);
		//List<WebElement> l=s.getOptions();
		//System.out.println(l.size());
		if(s.isMultiple())
		{
			Actions a=new Actions(driver);
			if(System.getProperty("os.name").contains("Mac"))
			{
				a.keyDown(Keys.META).build().perform();
				a.click(s.getOptions().get(2)).build().perform();
				Thread.sleep(5000);
				a.click(s.getOptions().get(0)).build().perform();
				Thread.sleep(5000);
				a.keyUp(Keys.META).build().perform();
							
			}	
			else//other than Mac OS
			{
				a.keyDown(Keys.CONTROL).build().perform();
				a.click(s.getOptions().get(2)).build().perform();
				Thread.sleep(5000);
				a.click(s.getOptions().get(0)).build().perform();
				Thread.sleep(5000);
				a.keyUp(Keys.CONTROL).build().perform();
				
			}
			
		}
		else
		{
			System.out.println("Single Select drop-down box");
		}
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		System.out.println("Program is Successfully executed ");
		driver.close();
		
	}

}
