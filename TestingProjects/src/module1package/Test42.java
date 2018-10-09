package module1package;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Scanner;

public class Test42 {

	public static void main(String[] args) throws IOException, InterruptedException, AWTException, HeadlessException, UnsupportedFlavorException 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter input 1");
		String x=sc.nextLine();
		System.out.println("Enter input 2");
		String y=sc.nextLine();
		Runtime.getRuntime().exec("calc.exe");
		Thread.sleep(5000);
		//send input 1 to calculator wsindow
		StringSelection  sx=new StringSelection(x);		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sx, null);
		//automate win-menu using java Robot
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
	
		Thread.sleep(5000);
		//perform +
		r.keyPress(KeyEvent.VK_ADD);
		r.keyRelease(KeyEvent.VK_ADD);
		Thread.sleep(5000);
		//send input 2 to calculator wsindow
			StringSelection  sy=new StringSelection(y);		
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sy, null);
			//automate win-menu using java Robot
			//Robot r=new Robot();
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
		
			Thread.sleep(5000);
			//perform +
			r.keyPress(KeyEvent.VK_EQUALS);
			r.keyRelease(KeyEvent.VK_EQUALS);
			Thread.sleep(5000);
			//get out put
			r.keyPress(KeyEvent.VK_CONTEXT_MENU);
			r.keyRelease(KeyEvent.VK_CONTEXT_MENU);
			Thread.sleep(5000);
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(5000);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(5000);
			String z=(String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
			System.out.println("Result is: "+z);
			//close calculator
			r.keyPress(KeyEvent.VK_ALT);
			r.keyPress(KeyEvent.VK_F4);
			r.keyRelease(KeyEvent.VK_F4);
			r.keyRelease(KeyEvent.VK_ALT);
			Thread.sleep(5000);
			//shutdown computer
			/*r.keyPress(KeyEvent.VK_WINDOWS);
			r.keyPress(KeyEvent.VK_ADD);
			r.keyPress(KeyEvent.VK_BACK_SLASH);
			r.keyPress(KeyEvent.VK_R);
			r.keyRelease(KeyEvent.VK_R);
			r.keyRelease(KeyEvent.VK_BACK_SLASH);
			r.keyRelease(KeyEvent.VK_ADD);
			r.keyRelease(KeyEvent.VK_WINDOWS);
			//Windows + I */
			
			
	}

}
