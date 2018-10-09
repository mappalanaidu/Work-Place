package FirstModule;

import java.util.Scanner;

public class StringSplitTest {

	public static void main(String[] args)
	
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a String");
		String x=sc.nextLine();
		String y[]=x.split(" ");
		//pring word in string array
		for(int i=0;i<y.length;i++) 
		{
			System.out.println(y[i]);
		}
		String sub=x.substring(4, x.length());
		System.out.println("Sub String is :"+sub);
		//concatnation of array words into a string
		String c="";
		for(int i=y.length-1;i>=0;i--)
		{
			c=c.concat(y[i])+" ";
		}
		System.out.println("Reverse Concatnation String is :"+c);
		
		String replace=c.replace(" ", ",");
		System.out.println("After rplacing space with cama String is :"+replace);
		String joins=String.join("-", y);
		System.out.println("Joins String is :"+joins);
				
	}														

}
