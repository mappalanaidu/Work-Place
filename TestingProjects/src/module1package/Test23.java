package module1package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test23 {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://jqueryui.com/slider/");
		///Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//it will work entire program, if required
		//double click 
		driver.switchTo().frame(0);
		WebElement e1=driver.findElement(By.xpath("//*[contains(@class,'ui-slider-handle')]"));
		//WebElement e2=driver.findElement(By.xpath("//*[text()='Women']"));
		Actions a=new Actions(driver);
		a.dragAndDropBy(e1, 500, 0).build().perform();
		Thread.sleep(5000);
		a.dragAndDropBy(e1, -300, 0).build().perform();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		/*for(int i=0;i<3;i++)
			{
			try
        		{
			driver.findElement(By.linkText("Vertical slider")).click();
			driver.navigate().refresh();
			driver.switchTo().frame(0);
			WebElement y=driver.findElement(By.xpath("//*[contains(@class,'ui-slider-handle')]"));
			a.dragAndDropBy(y, 0, 150).build().perform();
			Thread.sleep(5000);
			a.dragAndDropBy(y, 0, -90).build().perform();
			Thread.sleep(5000);
				break;
			    }
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
			}*/
		
		driver.findElement(By.linkText("Vertical slider")).click();
		driver.navigate().refresh();
		driver.switchTo().frame(0);
		WebElement y=driver.findElement(By.xpath("//*[contains(@class,'ui-slider-handle')]"));
		//int p=y.getLocation().getY();
		//System.out.println("present y axis value is: "+p);
		a.dragAndDropBy(y, 0, 100).build().perform();
		Thread.sleep(5000);
		a.dragAndDropBy(y, 0, -50).build().perform();
		Thread.sleep(5000);

		driver.close();
		
	}

}
