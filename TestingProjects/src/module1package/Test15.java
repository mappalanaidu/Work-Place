package module1package;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test15 {

	public static void main(String[] args) throws InterruptedException, IOException
	{
		System.setProperty("webdriver.chrome.driver","F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.gmail.com");
		//Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//driver.findElement(By.xpath("//*[text()=\"Sign In\"]")).click();
		//Thread.sleep(5000);
		driver.findElement(By.name("identifier")).sendKeys("naiduverseskusuma@gmail.com");
		driver.findElement(By.xpath("//*[contains(@id,'identifierNext')]")).click();
		driver.findElement(By.name("password")).sendKeys("9948838954");
		driver.findElement(By.xpath("//*[contains(@id,'passwordNext')]")).click();
		Thread.sleep(5000);
		
		File sre=driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("F:\\Naidu\\Testing Softwares\\ss.png");
		FileUtils f=new FileUtils();
		f.copyFile(sre,dest);
		
		driver.findElement(By.xpath("//*[contains(@title,'Google Account')]")).click();
		driver.findElement(By.linkText("Sign out")).click();
		System.out.println("Screen shot has successfully taken");			
		Thread.sleep(5000);
		driver.close();

	}

}
