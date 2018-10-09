package module1package;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class MultithreadingTest extends Thread 
{
	public void run()
	{
		try
		{
			Thread.sleep(30000);
			StringSelection s=new StringSelection("Naidu");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		StringSelection s1=new StringSelection("Naidu");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s1, null);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		}catch(Exception e)
		{
			
		}
				
	}
	
	public static void main(String[] args) throws Exception
	{
		MultithreadingTest mt=new MultithreadingTest();
		mt.start();//to start the executions of run method
		//launch site
		System.setProperty("webdriver.chrome.driver","F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.navigate().to("https://eforms.agility.com");
		
		//driver.get("https://eforms.agility.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.close();
	}

}
