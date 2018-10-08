package TestNGWithPOM;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TestNGWithPOMTest
{
  @Test
  public void mainMethod() throws Exception 
  {
	//open excel file in read mode using jxl
		File f=new File("Book1.xls");
		Workbook rwb=Workbook.getWorkbook(f);
		Sheet rsh=rwb.getSheet(0);//0 means sheet1
		int nour=rsh.getRows();
		//open html for results using extent reports
		ExtentReports er=new ExtentReports("pomgmailresults.html",false);
		ExtentTest et=er.startTest("Gmail Login Test");	
		try
		{
		//Automation with DDT in POM
		for(int i=1; i<nour;i++)
		{
			//get data fro sheet
			String bname=rsh.getCell(0,i).getContents();
			String u=rsh.getCell(1,i).getContents();
			String uc=rsh.getCell(2,i).getContents();
			String p=rsh.getCell(3,i).getContents();
			String pc=rsh.getCell(4,i).getContents();
			
			WebDriver driver=null;//obj declared
			
			//open our intrusted browser
			if(bname.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
				 driver=new ChromeDriver();//obj defined			
			}
			else if(bname.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.chrome.driver", "F:\\Naidu\\Testing Softwares\\geckodriver.exe");
				 driver=new FirefoxDriver();//obj defined			
		
			}
			else if(bname.equalsIgnoreCase("ie"))
			{
				System.setProperty("webdriver.chrome.driver", "F:\\Naidu\\Testing Softwares\\iedriverserver.exe");
				 driver=new InternetExplorerDriver();//obj defined			
		
			}
			else if(bname.equalsIgnoreCase("opera"))
			{
				OperaOptions o=new OperaOptions();
				o.setBinary("C:\\Program Files (x86)\\Opera\\53.0.2907.99\\opera.exe");
				System.setProperty("webdriver.chrome.driver", "F:\\Naidu\\Testing Softwares\\operadriver.exe");
				 driver=new OperaDriver(o);//obj defined			
		
			}
			else
			{
				et.log(LogStatus.SKIP, "Unknown Browser");
			System.out.println("Invalid Browser");	
			//Save and close excel file
			rwb.close();
			//Save and close extents reports 
			er.endTest(et);
			er.flush();
			//System.exit(0);//0 means forcble stop execution
			}
			
			
		//create objects to Page classes
		HomePage hp=new HomePage(driver);
		PasswordPage pp=new PasswordPage(driver);
		ComposePage cp=new ComposePage(driver);
		MessagePage mp=new MessagePage(driver);
		
		//Open site and perfrome operations
		driver.get("https://www.gmail.com");
		//create WebDriverWait object
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOf(hp.uid));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		//Do login
		hp.filluid(u);
		hp.uidnext();
		Thread.sleep(10000);
		
		//uid testing
		try
		{
			if(u.length()==0 && driver.findElement(By.xpath("//*[contains(text(),'Enter an email')]")).isDisplayed())
			{
				et.log(LogStatus.PASS, "Blank uid test passed");
			}
			else if(uc.equals("invalid")&& driver.findElement(By.xpath("(//*[contains(text(), 'find your Google Account')])[2]")).isDisplayed())
			{
				et.log(LogStatus.PASS, "Invalid uid test passed");

			}
			else if(uc.equals("valid")&& pp.pwd.isDisplayed())
			{
				et.log(LogStatus.PASS, "Valid uid test passed");
				//password testing 
				pp.fillpwd(p);
				pp.pwdnext();
				Thread.sleep(10000);
				try
				{
					if(p.length()==0 && driver.findElement(By.xpath("//*[text()='Enter a password']")).isDisplayed())
					{
						et.log(LogStatus.PASS, "Blank pwd test passed");
					}
					else if(pc.equals("invalid")&& driver.findElement(By.xpath("//*[contains(text(),'Wrong password')]")).isDisplayed())
					{
						et.log(LogStatus.PASS, "Invalid pwd test passed");

					}
					else if(pc.equals("valid")&& cp.compose.isDisplayed())
					{
						et.log(LogStatus.PASS, "Valid pwd test passed");
						
						w.until(ExpectedConditions.visibilityOf(cp.profile));
						cp.clickProfile();
						w.until(ExpectedConditions.visibilityOf(cp.signout));
						cp.clickSignOut();
						//w.until(ExpectedConditions.visibilityOf(pp.pwd));
											
						//close site
						//driver.close();
					}
					else
					{
						File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
						File dest=new File("gmailss1"+i+".png");
						FileUtils.copyFile(src, dest);
						et.log(LogStatus.FAIL, "Password test failed"+et.addScreenCapture("gmailss1"+i+".png"));
					}
											
					
				}catch(Exception ex2)
				{
					File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					File dest=new File("gmailss2"+i+".png");
					FileUtils.copyFile(src, dest);
					et.log(LogStatus.FAIL, "Password test Interupted"+et.addScreenCapture("gmailss2"+i+".png"));
			
				}
			}
			else
			{
				File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File dest=new File("gmailss3"+i+".png");
				FileUtils.copyFile(src, dest);
				et.log(LogStatus.FAIL, "Password test failed"+et.addScreenCapture("gmailss3"+i+".png"));

			}
						
		}
		catch(Exception ex1)
		{
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest=new File("gmailss4"+i+".png");
			FileUtils.copyFile(src, dest);
			et.log(LogStatus.FAIL, "User id test Interupted"+et.addScreenCapture("gmailss4"+i+".png"));

		}
		//close site
		driver.close();
		}//loop closing
}//try closing
catch(Exception ex)
{
et.log(LogStatus.ERROR,ex.getMessage());
}
		//Save and close excel file
		rwb.close();
		//Save and close extents reports 
		er.endTest(et);
		er.flush();
}

  
}
