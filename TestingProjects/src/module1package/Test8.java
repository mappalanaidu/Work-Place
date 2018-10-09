package module1package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test8 {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.way2sms.com/content/index.html?");
		///Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);//it will work entire program, if required
		int w=driver.manage().window().getSize().getWidth();
		int h=driver.manage().window().getSize().getHeight();
		System.out.println("Width: "+w+"  "+"Height: "+h);
		Thread.sleep(5000);
		
		Dimension d=new Dimension(600,600);
		driver.manage().window().setSize(d);
		int w1=driver.manage().window().getSize().getWidth();
		int h1=driver.manage().window().getSize().getHeight();
		System.out.println("Width: "+w1+"  "+"Height: "+h1);
		Thread.sleep(5000);
		
		int x=driver.manage().window().getPosition().getX();
		int y=driver.manage().window().getPosition().getY();
		System.out.println("X axses: "+x+"  "+"Y axese "+y);
		Thread.sleep(5000);
				
		Point p=new Point(500,400);
		driver.manage().window().setPosition(p);
		int x1=driver.manage().window().getPosition().getX();
		int y1=driver.manage().window().getPosition().getY();
		System.out.println("X axses: "+x1+"  "+"Y axese "+y1);
		
		Thread.sleep(5000);
		int c=driver.manage().getCookies().size();
		System.out.println("Number of Cookies loaded : "+c);
		driver.manage().deleteAllCookies();
		int c1=driver.manage().getCookies().size();
		System.out.println("Number of Cookies loaded : "+c1);
		if(c!=0)
		{
			System.out.println("Cookies were loaded");
					
		}
		else {
		
			System.out.println("Cookies were not loaded");
		    }
		Thread.sleep(5000);
		driver.close();
		
	}

}
