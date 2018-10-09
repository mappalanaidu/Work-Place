package module1package;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3 {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.irctc.co.in");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[@class=\"ng-star-inserted\"])[3]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//*[contains(@class, 'form-control')])[2]")).sendKeys("Naidu03");
		//driver.findElement(By.name("signIn")).click();
		driver.findElement(By.xpath("(//*[contains(@class, 'form-control')])[3]")).sendKeys("bhagya");
		Thread.sleep(20000);
		driver.findElement(By.xpath("(//*[contains(@class, 'ui-inputtext')])[1]")).sendKeys("SECUNDERABAD JN - SC");
		driver.findElement(By.xpath("(//*[contains(@class, 'ui-inputtext')])[2]")).sendKeys("BOBBILI - VBL");
		Thread.sleep(30000);
		
		driver.findElement(By.xpath("(//*[contains(@class, 'search_btn')])[1]")).click();
		//driver.close();


	}

}
