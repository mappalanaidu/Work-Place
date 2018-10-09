package module1package;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test10 {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.gmail.com");
		//Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//driver.findElement(By.xpath("//*[text()=\"Sign In\"]")).click();
		//Thread.sleep(5000);
		driver.findElement(By.name("identifier")).sendKeys("naiduverseskusuma@gmail.com");
		driver.findElement(By.xpath("//*[contains(@id,'identifierNext')]")).click();
		driver.findElement(By.name("password")).sendKeys("9948838954");
		driver.findElement(By.xpath("//*[contains(@id,'passwordNext')]")).click();
		List<WebElement> l=driver.findElements(By.xpath("(//table)[6]/tbody/tr"));
		System.out.println("Number of mails in inbox : "+l.size());
		Thread.sleep(5000);
		
		/**List<WebElement> l1=driver.findElements(By.xpath("(//*[contains(@class,'J-N-Jz')])[1]"));
		
		for(int i=0;i<l.size();i++)
		{
			if(i<=4)
			{
				l1.get(i).click();
			}
				
		}
		driver.findElement(By.xpath("//*[contains(@class,'ar9 T-I-J3 J-J5-Ji')]")).click();
		Thread.sleep(5000);*/
		driver.findElement(By.xpath("//*[contains(@title,'Google Account')]")).click();
		driver.findElement(By.linkText("Sign out")).click();
						
		Thread.sleep(5000);
		driver.close();

	}

}
