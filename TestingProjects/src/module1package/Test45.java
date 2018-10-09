package module1package;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Button;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

public class Test45 {

	public static void main(String[] args) throws Exception
	{
		System.setProperty("webdriver.chrome.driver","F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.youtube.com/");
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("search_query")));
		driver.manage().window().maximize();
		driver.findElement(By.name("search_query")).sendKeys("abdul kalam speeches");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@aria-label='Search'])[3]/child::*[1]")));
		driver.findElement(By.xpath("(//*[@aria-label='Search'])[3]/child::*[1]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@aria-label, 'Dr. A P J Abdul Kalam in European Parliament')]")));
		driver.findElement(By.xpath("//*[contains(@aria-label, 'Dr. A P J Abdul Kalam in European Parliament')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(), 'Dr. A P J Abdul Kalam in European Parliament')])[3]")));
		//automate video elements(sikulix)
		Screen s=new Screen();
		Thread.sleep(5000);
		if(s.exists("skipadd.PNG")!=null)
		{
			s.click("skipadd.PNG");
		}
		//pause
		Thread.sleep(5000);
		Location l=new Location(300,300);
		s.wheel(l, Button.LEFT, 0);
		s.click("pause.PNG");
		Thread.sleep(5000);
		//move mouse pointer to video body
		s.wheel(l, Button.LEFT, 0);
		s.click("play.PNG");
		Thread.sleep(5000);
		s.wheel(l, Button.LEFT, 0);
		s.mouseMove("mute.PNG");
	//aotomate sloider frome left to right
		Match e=s.find("buble.PNG");
		int x=e.getX();
		int y=e.getY();
		Location el1=new Location(x-20,y);
		s.dragDrop(e,el1);
		Thread.sleep(5000);
		//aotomate sloider frome right to left
				Location el2=new Location(x+40,y);
				s.dragDrop(e,el2);
				Thread.sleep(5000);
				//close site
				driver.close();
			
	}

}
