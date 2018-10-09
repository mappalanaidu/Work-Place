package module1package;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class TextFromImage 
{

	public static void main(String[] args) throws Exception 
	
	{
		Screen s=new Screen();
		String x=s.find("Untitled.png").text();
		System.out.println("Text on Image is :"+x);
		
	}

}
