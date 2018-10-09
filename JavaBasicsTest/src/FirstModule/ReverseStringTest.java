package FirstModule;

import java.util.Scanner;

public class ReverseStringTest 
{

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a String");
		String x=sc.nextLine();

		String y="";
		
		for(int i=x.length()-1;i>=0;i--)
		{
			//char c=x.charAt(i);
			y=y+x.charAt(i);
		}
		
		System.out.println("Reverse String is :"+y);
		
		StringBuffer sb=new StringBuffer(x); 
		StringBuffer s1=sb.reverse();
		String res=s1.toString();
		System.out.println("Reverse String from StringBuffer class is :"+res);

		
		}


}
