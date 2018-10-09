package module1package;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class Test49 {

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enten a word");
		String x=sc.nextLine();
		WebDriver driver=null;//obj declared
		//open our intrusted browser
		if(x.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
			 driver=new ChromeDriver();//obj defined			
		}
		else if(x.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.chrome.driver", "F:\\Naidu\\Testing Softwares\\geckodriver.exe");
			 driver=new FirefoxDriver();//obj defined			
	
		}
		else if(x.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.chrome.driver", "F:\\Naidu\\Testing Softwares\\iedriverserver.exe");
			 driver=new InternetExplorerDriver();//obj defined			
	
		}
		else if(x.equalsIgnoreCase("opera"))
		{
			OperaOptions o=new OperaOptions();
			o.setBinary("C:\\Program Files (x86)\\Opera\\53.0.2907.99\\opera.exe");
			System.setProperty("webdriver.chrome.driver", "F:\\Naidu\\Testing Softwares\\operadriver.exe");
			 driver=new OperaDriver(o);//obj defined			
	
		}
		else
		{
			
		System.out.println("Invalid Browser");	
		System.exit(0);//0 means forcble stop execution
		}
	//launch site
		driver.get("https://google.co.in");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("kalam");

	}

}
