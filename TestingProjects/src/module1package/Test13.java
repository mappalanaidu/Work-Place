package module1package;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test13 {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.gmail.com");
		//Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.name("identifier")).sendKeys("mbhavjeet@gmail.com");
		driver.findElement(By.xpath("//*[contains(@id,'identifierNext')]")).click();
		driver.findElement(By.name("password")).sendKeys("9948838954");
		driver.findElement(By.xpath("//*[contains(@id,'passwordNext')]")).click();
		List<WebElement> l1=driver.findElements(By.xpath("(//table)[6]/tbody/tr"));
		System.out.println("Number of mails in inbox : "+l1.size());
		Thread.sleep(5000);
		SimpleDateFormat f=new SimpleDateFormat("dd/MMM/yyyy");
		Date d=new Date();
		System.out.println(f.format(d));
		String y=f.format(d);
		int c=0;
		for(int i=1;i<l1.size();i++)
		{
			List<WebElement> l2=driver.findElements(By.xpath("(//table)[6]/tbody/tr["+i+"]/td"));
			String x=l2.get(7).getText();
			if(x.contains("Jun"))
			{
			c++;	
			}
			else
			{
				if(y.contains("Jun") && x.toLowerCase().contains("am"))
				{
					c++;
					
				}
				else if(y.contains("Jun") && x.toLowerCase().contains("pm"))
				{
					c++;
				}
			}
								
		}
			
	System.out.println("number of mails received in June :"+c);
	Thread.sleep(5000);
	driver.findElement(By.xpath("//*[contains(@title,'Google Account')]")).click();
	driver.findElement(By.linkText("Sign out")).click();
					
	Thread.sleep(5000);
	driver.close();

	}

}
