package module1package;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test39 {

	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.chrome.driver","F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.gmail.com");
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		driver.manage().window().maximize();
		driver.findElement(By.name("identifier")).sendKeys("naiduverseskusuma@gmail.com");
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		driver.findElement(By.name("password")).sendKeys("9948838954");
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='COMPOSE']")));
		driver.findElement(By.xpath("//*[text()='COMPOSE']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='To']")));
		driver.findElement(By.xpath("//*[@aria-label='To']")).sendKeys("mbhavjeet@gmail.com");
		driver.findElement(By.xpath("//*[@name='subjectbox']")).sendKeys("Wishes");
		driver.findElement(By.xpath("(//*[@aria-label='Message Body'])[2]")).sendKeys("Hi Bhavi,\nHow are you?\nBye");
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
		driver.findElement(By.xpath("//*[contains(@aria-label,'Send')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Your message has been sent.')]")));
		driver.findElement(By.xpath("//*[contains(@title,'Google Account')]/span")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Sign out']")));
		driver.findElement(By.xpath("//*[text()='Sign out']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		driver.close();

	}

}
