package Module1;

import java.util.Locale;
import java.util.Scanner;

import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VoiceAutomation 
{
	public static void main(String[] args)
	{
		 try
	        {
			 
			 	// Get data from keyboard
				Scanner sc=new Scanner(System.in);
				System.out.println("enter text to convert speech");
				String x=sc.nextLine();
				
	                     //stop notifications in chrome
	            System.setProperty("webdriver.chrome.driver","F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
	            ChromeOptions co=new ChromeOptions();
	            co.addArguments("--use-fake-ui-for-media-stream=1");
	            
	            ChromeDriver driver=new ChromeDriver(co);
	    		driver.get("https://www.google.co.in/");
	    		WebDriverWait w=new WebDriverWait(driver,100);
	    		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("gsri_ok0")));
	    		driver.manage().window().maximize();
	    		driver.findElement(By.id("gsri_ok0")).click();
	    		Thread.sleep(5000);
	    		  // set property as Kevin Dictionary
	            System.setProperty("freetts.voices",
	                "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory"); 
	                 
	            // Register Engine
	            Central.registerEngineCentral
	                ("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
	 
	            // Create a Synthesizer
	            Synthesizer synthesizer =                                         
	                Central.createSynthesizer(new SynthesizerModeDesc(Locale.ENGLISH));     
	 
	            // Allocate synthesizer
	            synthesizer.allocate();        
	             
	            // Resume Synthesizer
	            synthesizer.resume();    
	            // speaks the given text until queue is empty.
	          
	            synthesizer.speakPlainText(x, null);         
	            synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
	           	            
	           // Deallocate the Synthesizer.
	            synthesizer.deallocate();   
	            w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='All']")));
	    		
	           // Thread.sleep(50000);
	            driver.close();
	            
	        } 
	 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }
	
	}

}
