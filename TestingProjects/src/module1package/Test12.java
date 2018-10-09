package module1package;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test12 {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.gmail.com");
		//Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.name("identifier")).sendKeys("naiduverseskusuma@gmail.com");
		driver.findElement(By.xpath("//*[contains(@id,'identifierNext')]")).click();
		driver.findElement(By.name("password")).sendKeys("9948838954");
		driver.findElement(By.xpath("//*[contains(@id,'passwordNext')]")).click();
		List<WebElement> l1=driver.findElements(By.xpath("(//table)[6]/tbody/tr"));
		System.out.println("Number of mails in inbox : "+l1.size());
		Thread.sleep(5000);
		List<WebElement> l2=driver.findElements(By.xpath("(//table)[6]/tbody/tr[3]/td"));
		System.out.println("Number of coloms in inbox : "+l2.size());
		Thread.sleep(5000);
		
		for(int i=0;i<l2.size();i++)
		{
				String x=l2.get(i).getText();
				System.out.println(x);
			
		}
		//driver.findElement(By.xpath("//*[contains(@class,'ar9 T-I-J3 J-J5-Ji')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(@title,'Google Account')]")).click();
		driver.findElement(By.linkText("Sign out")).click();
						
		Thread.sleep(5000);
		driver.close();

	}

}

