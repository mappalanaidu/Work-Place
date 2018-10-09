package module1package;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Scanner;

public class Test43 {

	public static void main(String[] args) throws Exception 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter some data");
		String data=sc.nextLine();
		Runtime.getRuntime().exec("notepad.exe");
		Thread.sleep(5000);
		//send msg to clipboard
		StringSelection  sdata=new StringSelection(data);		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sdata, null);
		//automate to send data to notepad using java Robot
				Robot r=new Robot();
				r.keyPress(KeyEvent.VK_CONTROL);
				r.keyPress(KeyEvent.VK_V);
				r.keyRelease(KeyEvent.VK_V);
				r.keyRelease(KeyEvent.VK_CONTROL);
			
				Thread.sleep(5000);
				r.keyPress(KeyEvent.VK_CONTROL);
				r.keyPress(KeyEvent.VK_S);
				r.keyRelease(KeyEvent.VK_S);
				r.keyRelease(KeyEvent.VK_CONTROL);
				//using java Robot to enter file path
				Thread.sleep(5000);
				StringSelection s=new StringSelection("C:\\Users\\Naidu\\Desktop\\msg.txt");
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
				r.keyPress(KeyEvent.VK_CONTROL);
				r.keyPress(KeyEvent.VK_V);
				r.keyRelease(KeyEvent.VK_V);
				r.keyRelease(KeyEvent.VK_CONTROL);
				Thread.sleep(5000);
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);
				//close notepad
				r.keyPress(KeyEvent.VK_ALT);
				r.keyPress(KeyEvent.VK_F4);
				r.keyRelease(KeyEvent.VK_F4);
				r.keyRelease(KeyEvent.VK_ALT);
				Thread.sleep(5000);
				//shutdown computer
		

	}

}
