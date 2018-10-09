package module1package;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test50 {

	public static void main(String[] args) throws Exception 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter any word");
		String x=sc.nextLine();
		System.setProperty("webdriver.chrome.driver","F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.google.co.in");
		WebDriverWait w=new WebDriverWait(driver,15);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys(x,Keys.ENTER);
		int count=0;
		while(2>1)
		{
			try
			{
				String title=driver.getTitle();
			
				if(!title.contains(x))
				{
					break;
				}else
				{
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Next']")));
					driver.findElement(By.xpath("//*[text()='Next']")).click();
					count++;
					
				}
			}catch(Exception e)
			{
				break;
			}
			}
		System.out.println("No of Pages  contains title are : "+count);
		//close site				
		driver.close();

	}

}
