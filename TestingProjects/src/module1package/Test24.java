package module1package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test24 {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://jqueryui.com/droppable/");
		///Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);//it will work entire program, if required
		//double click 
		driver.switchTo().frame(0);
		WebElement e1=driver.findElement(By.xpath("//*[contains(@class,'ui-widget-content ui-draggable')]"));
		WebElement e2=driver.findElement(By.xpath("//*[contains(@class,'ui-widget-header ui-droppable')]"));
		//WebElement e1=driver.findElement(By.id("draggable"));
		//WebElement e2=driver.findElement(By.id("droppable"));
		
		Actions a=new Actions(driver);
		a.dragAndDrop(e1, e2).build().perform();
		//a.dragAndDropBy(e1, 500, 0);
		Thread.sleep(5000);
		driver.close();
		
	}

}
