package module1package;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Test6 {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		WebDriver r=new ChromeDriver();
		/**System.setProperty("webdriver.ie.driver","F:\\Naidu\\Testing Softwares\\IEDriverServer.exe");
		InternetExplorerDriver r=new InternetExplorerDriver();*/
        r.get("http://www.way2sms.com");
        r.findElement(By.name("username")).sendKeys("9948838954");
        r.findElement(By.id("password")).sendKeys("bhagya530");
        Thread.sleep(5000);
        r.findElement(By.id("loginBTN")).click();
        Thread.sleep(5000);
        r.findElement(By.xpath("//*[contains(text(), 'Send SMS')]")).click();
        //r.findElement(By.xpath("//*[@value='Send Free SMS']")).click();
        Thread.sleep(5000);
            r.findElement(By.xpath("//*[@id='sendSMS']/child::*")).click();
            r.switchTo().frame("frame");
        r.findElement(By.name("mobile")).sendKeys("9553035470");
        r.findElement(By.id("message")).sendKeys("hi Chitti, h r u");
        Thread.sleep(5000);
        r.findElement(By.id("Send")).click();
        Thread.sleep(50000);
		r.close();
					
	}

}
