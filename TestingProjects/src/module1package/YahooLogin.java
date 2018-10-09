package module1package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class YahooLogin {

	public static void main(String[] args) throws InterruptedException 
	{
		// Yahoo Reg 
				System.setProperty("webdriver.chrome.driver","F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
				ChromeDriver driver=new ChromeDriver();
				driver.get("https://login.yahoo.com/");
				//Thread.sleep(5000);
				driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				//driver.findElement(By.name("identifier")).sendKeys("mbhavjeet@gmail.com");
				//driver.findElement(By.xpath("//*[@id='createacc']")).click();
				//passing username and password
				driver.findElement(By.xpath("//input[@name='username']")).sendKeys("manaidu1787@yahoo.com");
				driver.findElement(By.xpath("//input[@name='signin']")).click();
				driver.findElement(By.xpath("//input[@name='password']")).sendKeys("9948838954");
				driver.findElement(By.xpath("//*[@name='verifyPassword']")).click();
				//click the mail box icon
				driver.findElement(By.xpath("(//*[text()='Mail'])[2]")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@class='folder-list p_R k_w W_6D6F']/ul/li[8]/div")).click();
				Thread.sleep(5000);
				//select 2nd tick box and delete
				driver.findElement(By.xpath("(//*[@title='Tickbox, not ticked'])[2]")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[3]/div[1]/button[1]/span[1]/span[1]")).click();
				Thread.sleep(5000);
				//retrieve deleated mails to inbox
				driver.findElement(By.xpath("//div[@data-test-id='icon-btn-checkbox-container']//button[@tabindex='-1']//span[@class='D_F ab_C gl_C W_6D6F']")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//span[contains(text(),'Move')]")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//li[@data-test-id='item-move-to-folder-id-1']//button[@tabindex='-1']//span[@class='D_F W_6D6F']//span[@class='em_N P_0 o_h G_e']//span[@aria-live='true']//span[contains(@class,'rtlI_rtlI_dz_sSg')]")).click();
				//signout from login page
				driver.findElement(By.xpath("//*[@class='_yb_vqyl3 _yb_14rbo']/div")).click();
				driver.findElement(By.xpath("(//*[contains(text(),'Sign out')])[1]")).click();
				Thread.sleep(5000);
				driver.close();
	}

}
