package module1package;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test9 {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.goindigo.in/");
		///Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);//it will work entire program, if required
		List<WebElement> l=driver.findElements(By.tagName("a"));
		int x=l.size();
		System.out.println("Total  Number links avaliable: "+x);
		
		int vl=0;
		int hl=0;
		for(int i=0; i<l.size(); i++)
		{
			if(l.get(i).isDisplayed())
			{
				vl++;
			}
			else
			{
				hl++;
			}
		}
		System.out.println("Number of visible links : "+vl);
		System.out.println("Number of non visible links : "+hl);
		
	}
	
}
	


