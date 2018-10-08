package PageObjectModel;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestClass 
{

	public static void main(String[] args) throws Exception
	{
		// Launch Browser
		System.setProperty("webdriver.chrome.driver","F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//create objects to Page classes
		HomePage hp=new HomePage(driver);
		PasswordPage pp=new PasswordPage(driver);
		ComposePage cp=new ComposePage(driver);
		MessagePage mp=new MessagePage(driver);
		
		//create WebDriverWait object
		WebDriverWait w=new WebDriverWait(driver,100);
		
		
		//Open site and perfrome operations
		driver.get("https://www.gmail.com");
		
		//Perform Home Page Operations
		hp.filluid("vkusuma03");
		hp.uidnext();
		w.until(ExpectedConditions.visibilityOf(pp.pwd));
		pp.fillpwd("9948838954");
		pp.pwdnext();
		
		try
		{		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if(driver.findElement(By.xpath("(//*[@aria-label='Close'])[2]")).isDisplayed())
		{
			driver.findElement(By.xpath("(//*[@aria-label='Close'])[2]")).click();	
		}
		}catch(Exception e)
		{
		System.out.println(e.getMessage());
		}
		w.until(ExpectedConditions.visibilityOf(cp.compose));
		cp.clickCompose();
		
		w.until(ExpectedConditions.visibilityOf(mp.to));
		mp.fillTo("mbhavjeet@gmail.com");
		mp.fillSubject("Wishes");
		mp.fillBody("Hi..\nHow are you\nBy...........");
		
		driver.findElement(By.xpath("//*[@aria-label='Attach files']")).click();
		//using java Robot to upload file
		Thread.sleep(5000);
		StringSelection s=new StringSelection("C:\\Users\\Naidu\\Desktop\\Naidu Documents for Software\\Naidu_MSBI_Resume.docx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@aria-label, 'Press enter to view the attachment and delete to remove it')]")));
				
		mp.clickSend();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Your message has been sent.')]")));
		
		cp.clickProfile();
		w.until(ExpectedConditions.visibilityOf(cp.signout));
		cp.clickSignOut();
		w.until(ExpectedConditions.visibilityOf(pp.pwd));
		
		//close site
		driver.close();
				
	}

}
