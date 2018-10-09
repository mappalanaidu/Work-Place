package module1package;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class BrowserCompatabilityTest 
{

	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enten a browser name ");
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
			System.setProperty("webdriver.gecko.driver", "F:\\Naidu\\TestingSoftwares\\geckodriver.exe");
			 driver=new FirefoxDriver();//obj defined			
	
		}
		else if(x.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "F:\\Naidu\\TestingSoftwares\\iedriverserver.exe");
			 driver=new InternetExplorerDriver();//obj defined			
	
		}
		else if(x.equalsIgnoreCase("opera"))
		{
			OperaOptions o=new OperaOptions();
			o.setBinary("C:\\Program Files\\Opera\\55.0.2994.56\\opera.exe");
			System.setProperty("webdriver.opera.driver", "F:\\Naidu\\TestingSoftwares\\operadriver_win64\\operadriver_win64\\operadriver.exe");
			 driver=new OperaDriver(o);//obj defined			
	
		}
		else
		{
		System.out.println("Invalid Browser");	
		System.exit(0);//0 means forcble stop execution
		}
	//launch site
		try
		{
			driver.get("https://google.co.in");
	
		driver.manage().window().maximize();
		WebElement e=driver.findElement(By.name("q"));
		e.sendKeys("kalam");
		
		SimpleDateFormat sf=new SimpleDateFormat("dd-MM-yy-hh-mm-ss");
		Date dt=new Date();
		String ssname=sf.format(dt);
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		int width=e.getSize().getWidth();
		int height=e.getSize().getHeight();
		int xcoordinate=e.getLocation().getX();
		int ycoordinate=e.getLocation().getY();
		BufferedImage bi=ImageIO.read(src);
		BufferedImage subsrc=bi.getSubimage(xcoordinate, ycoordinate, width, height);
		ImageIO.write(subsrc, "png", src);
		//File dest1=new File(subsrc);
		//int width=driver.manage().window().getSize().getWidth();
		//int height=driver.manage().window().getSize().getHeight();
		//int X=driver.manage().window().getPosition().getX();
		
		File dest=new File(ssname+".png");
		FileUtils.copyFile(src, dest);
		//return (ssname);
		
		
		
		Thread.sleep(5000);
		driver.quit();
		}catch(Exception e)
		{
			
		}
	}

}
