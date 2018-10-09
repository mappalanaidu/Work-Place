package FirstModule;

import java.util.Scanner;

public class SomeStringMethodsTest {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("enter you name");
		String x=sc.nextLine();
		
		System.out.println("your entered name is :"+x);
		int l=x.length();
		System.out.println("your entered name length is :"+l);
		
		String s=x.substring(0, 4);
		System.out.println("your entered name letters from 1-6 are/is :"+s);
		System.out.println(x.contains(s));
		
		Class c=x.getClass();
		String cn=c.getName();
		System.out.println("class name is: "+cn);
	}

}
