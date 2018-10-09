package FirstModule;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) 
	{
		// Palandrom or not 
		Scanner sc=new Scanner(System.in);
		System.out.println("enter you name");
		String x=sc.nextLine();
		//int z=sc.nextInt();
	
		//logic
		
		String reverse="";
		for(int i=x.length()-1; i>=0; i--)
		{
			reverse=reverse+x.charAt(i);
		}
		if(reverse.equals(x))
		{
		System.out.println("given string is palandorm");
		}
		else
		{
		System.out.println("given string is not a palandorm");
			
		}
		}
	}
