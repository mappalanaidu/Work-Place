package module1package;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test26 {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);//it will work entire program, if required
		/*//Open dropdown list
		WebElement e=driver.findElement(By.xpath("(//*[@class='ui dropdown'])[1]"));
		Actions a=new Actions(driver);
		a.click(e).build().perform();*/
		
	//get all items from the drop down list
		List<WebElement> l=driver.findElements(By.xpath("(//*[@class='menu'])[18]/div"));
		System.out.println(l.size());
		for(int i=0;i<l.size();i++)
		{
			System.out.println(l.get(i).getText());//even though if we use getAttribute("value") method, we are unable to get item details. So, we have to use CSS Values to get item details 
		}
		//select 4th element in that list
		//driver.findElement(By.xpath("//*[@class='menu transition visible']/div[3]")).click();
		//System.out.println("3rd item was selected form list");
		driver.close();


	}

}
