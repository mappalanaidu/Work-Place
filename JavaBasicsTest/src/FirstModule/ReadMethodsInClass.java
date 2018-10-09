package FirstModule;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadMethodsInClass {

	public static void main(String[] args) 
	{
		Sample5 obj=new Sample5();
		Sample7 s7=new Sample7();
		Method m[]=obj.getClass().getMethods();
		Method m1[]=obj.getClass().getMethods();
		
		System.out.println("Total methods in Sample5 class are : "+m.length);
		
		for(int i=0;i<m.length;i++)
		{
			System.out.println(m[i].getName());
		}
System.out.println("Total methods in Sample7 class are : "+m1.length);
		
		for(int i=0;i<m1.length;i++)
		{
			System.out.println(m1[i].getName());
		}
	
	
		System.setProperty("webdriver.chrome.driver", "F:\\Naidu\\TestingSoftwares\\chromedriver.exe");
		
		WebDriver d1=new ChromeDriver();
		Method m2[]=d1.getClass().getMethods();
		
System.out.println("Total methods in WebDriver Interface class are : "+m2.length);
		
		for(int i=0;i<m2.length;i++)
		{
			System.out.println(m2[i].getName());
		}

	}

}
