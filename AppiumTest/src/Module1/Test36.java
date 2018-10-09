package Module1;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Test36
{
	public static void main(String[] args) throws Exception
	{
		// Taks  color name
				Scanner sc=new Scanner(System.in);
				System.out.println("enter red/green/black/blue");
				String cname=sc.nextLine();
				int count=0;
				int percentage;
				Color ec=null;
				switch(cname)
				{
				case "black":
					ec=Color.BLACK;
					break;
				case "green":
					ec=new Color(0,128,0);
					break;
				case "blue":
					ec=Color.BLUE;
					break;
				case "red":
					ec=Color.RED;
					break;
				default:
					System.out.println("wrong color");
					System.exit(0);
				}
				
				//Provide details of device(ARD) and app
				DesiredCapabilities dc=new DesiredCapabilities();
				dc.setCapability(CapabilityType.BROWSER_NAME, "");
				dc.setCapability("deviceName", "HNB0ZC4E");
				dc.setCapability("platformName", "android");
				dc.setCapability("platformVersion", "6.0");
				dc.setCapability("appPackage", "com.vodqareactnative");
				dc.setCapability("appActivity", "com.vodqareactnative.MainActivity");
				
				//Start appium server
				Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
				URL u=new URL("http://0.0.0.0:4723/wd/hub");
				
				//create object for AndroidDriver to launch app
				AndroidDriver driver;
				while(2>1)
				{
				try
					{
					driver=new AndroidDriver(u, dc);
					break;
					}
				catch(Exception ex)
				 	{
					
				 	}
				}
				//Automation
				try
				{
					WebDriverWait w=new WebDriverWait(driver, 100);
					
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='LOG IN']")));
					driver.findElement(By.xpath("//*[@text='LOG IN']")).click();
					
					//swipe for wheel picker option
					while(2>1)
					{
						try
						{
							driver.findElement(By.xpath("//*[@text='Wheel Picker']")).click();
							break;
						}catch(Exception e)
						{
							int width=driver.manage().window().getSize().getWidth();
							int height=driver.manage().window().getSize().getHeight();
							TouchAction ta=new TouchAction(driver);
							int x1=(int)(width/2);
							int y1=(int)(height*0.9);
							int x2=(int)(width/2);
							int y2=(int)(height*0.4);
							Duration d=Duration.of(5,ChronoUnit.SECONDS);
							ta.press(x1,y1).waitAction(d).moveTo(x2,y2).release().perform();
												
						}
					}
					
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.widget.Spinner']")));
					driver.findElement(By.xpath("//*[@class='android.widget.Spinner']")).click();
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.widget.ListView']")));
					driver.findElement(By.xpath("//*[@text='"+cname+"']")).click();
					WebElement e=driver.findElement(By.xpath("//*[@bounds='[0,160][720,260]']"));
					
					//get location of the element app screen 
					int x=e.getLocation().getX();
					int y=e.getLocation().getY();
					//get width and height of element
					int elewidth=e.getSize().getWidth();
					int eleheight=e.getSize().getHeight();
					//get entire page screenshot
					File screenshor=driver.getScreenshotAs(OutputType.FILE);
					BufferedImage fullimg=ImageIO.read(screenshor);
					//crop the full screenshot to get element screenshot
					BufferedImage elescreeshot=fullimg.getSubimage(x,y,elewidth,eleheight);
					
					//chack image color pixel by pixel
					for(int i=0;i<elewidth;i++)
					{
						for(int j=0;j<eleheight;j++)
						{
							Color ac=new Color(elescreeshot.getRGB(i, j));
							if(ac.getRed()==ec.getRed() && ac.getGreen()==ec.getGreen() && ac.getBlue()==ec.getBlue())
							{
								count=count+1;
							}
						}
					}
					System.out.println("Expected color pixels count is:"+count);
					percentage=(count*100)/(elewidth*eleheight);
					System.out.println("Expected color percentage is:"+percentage);
				if(percentage>=85)
				{
					System.out.println("color test was passed");
				}else
				{
					System.out.println("color test was failed");
				}
			//close app
					driver.closeApp();
					
					}
					catch(Exception ex)
					{
					System.out.println(ex.getMessage());
					
					}
								
				//stop appium server
					Runtime.getRuntime().exec("taskkill /F /IM node.exe");
					Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
				}

			}
