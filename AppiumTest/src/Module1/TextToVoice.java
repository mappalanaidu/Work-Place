package Module1;

import java.util.Locale;
import java.util.Scanner;


import javax.speech.Central;
import javax.speech.EngineException;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;

public class TextToVoice
{
	public static void main(String[] args) throws Exception
	{
		
		 try
	        {
			 
			 	// Get data from keyboard
				Scanner sc=new Scanner(System.in);
				System.out.println("enter text to convert speech");
				String x=sc.nextLine();
				
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
	             
	           for(int i=0;i<10;i++)
	           {
	        	   // speaks the given text until queue is empty.
	          
	            synthesizer.speakPlainText(x, null);         
	          
	           synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
	           }
	           // Deallocate the Synthesizer.
	            synthesizer.deallocate();                                 
	        } 
	 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }
		
		
		
		/*try
		{
		// Get data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("enter text to convert speech");
		String x=sc.nextLine();
		
		//convert give text to voice
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
		Synthesizer s=Central.createSynthesizer(new SynthesizerModeDesc(Locale.UK));
		s.allocate();
		s.resume();
		s.speakPlainText(x,null);
		s.waitEngineState(Synthesizer.QUEUE_EMPTY);
		s.deallocate();
		}
		catch(Exception ex)
		{
		}
*/		
	}

}
