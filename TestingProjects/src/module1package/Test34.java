package module1package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test34 {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ui dropdown'][1]")));
		driver.manage().window().maximize();
		driver.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(3000);
		driver.executeScript("window.scrollTo(document.body.scrollHeight,0);");
		Thread.sleep(3000);
		//scroll to specific element
		WebElement e=driver.findElement(By.xpath("(//*[text()='Multiple Selection'])[2]"));
		driver.executeScript("arguments[0].scrollIntoView();",e);
		Thread.sleep(3000);
		driver.close();
	
	}	
	}