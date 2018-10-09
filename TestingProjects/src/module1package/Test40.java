package module1package;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test40 {

	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter gmail id");
		String uname=sc.nextLine();
		System.out.println("Enter gmail password");
		String upasw=sc.nextLine();
		System.out.println("Enter Sender email id");
		String smail=sc.nextLine();
				
		System.setProperty("webdriver.chrome.driver","F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.gmail.com");
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		driver.manage().window().maximize();
		driver.findElement(By.name("identifier")).sendKeys(uname);
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		driver.findElement(By.name("password")).sendKeys(upasw);
		driver.findElement(By.xpath("//*[text()='Next']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='COMPOSE']")));
		driver.findElement(By.xpath("//*[text()='COMPOSE']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@aria-label='To']")));
		driver.findElement(By.xpath("//*[@aria-label='To']")).sendKeys(smail);
		driver.findElement(By.xpath("//*[@name='subjectbox']")).sendKeys("Wishes");
		driver.findElement(By.xpath("(//*[@aria-label='Message Body'])[2]")).sendKeys("Hi Bhavi,\nHow are you?\nBye");
		driver.findElement(By.xpath("//*[@aria-label='Attach files']")).click();
		//using java Robot to upload file
		Thread.sleep(5000);
		StringSelection s=new StringSelection("C:\\Users\\Naidu\\Desktop\\Naidu Documents for Software\\Naidu_MSBI_Resume.docx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		Robot r=new Robot();
		System.out.println(System.getProperty("os.name"));
		if(System.getProperty("os.name").contains("Win"))
		{
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		}
		else if(System.getProperty("os.name").contains("Mac"))
		{
			r.keyPress(KeyEvent.VK_META);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_META);
		}
		else if(System.getProperty("os.name").contains("Linux"))
		{
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
		}
		else
		{
			System.out.println("Wrong Platform");
			driver.close();
			System.exit(0);//0 means forcble
		}
		
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
