package module1package;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class Test44 {

	public static void main(String[] args) throws FindFailed 
	{
		Screen s=new Screen();
		s.click("minimize.PNG");
		
		//s.click("F:\\Naidu\\TestingSoftwares\\minimize.PNG");
		//s.mouseMove("chrome.PNG");
		if(s.exists("close.PNG") != null)
		{
			System.out.println("Element visible");
		}
		else
		{
			System.out.println("Element was not visible");
			
		}
		s.doubleClick("d.PNG");
		if(s.exists("close.PNG") != null)
		{
			System.out.println("Element visible");
		}
		else
		{
			System.out.println("Element was not visible");
			
		}
		
		s.click("close.PNG");
		s.click("max.PNG");
		
	}

}
