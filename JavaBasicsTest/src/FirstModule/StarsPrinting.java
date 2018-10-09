package FirstModule;

import java.util.Scanner;

public class StarsPrinting {

	public static void main(String[] args) 
	{
		// Stars prining in traingle
		Scanner sc=new Scanner(System.in);
		System.out.println("enter any no");
		int x=sc.nextInt();
		//logic
		
		for(int i=1; i<=x; i++)
		{
			for(int j=x; j>=i; j--)
			{
				System.out.print(" ");
			}
			
			for(int j=1; j<=i; j++)
			{
				System.out.print("* ");
			}
			for(int k=x; k>=i; k--)
			{
				System.out.print(" ");
			}
			System.out.println();
		}
		for(int i=x; i>=1; i--)
		{
			for(int j=x; j>=i; j--)
			{
				System.out.print(" ");
			}
			
			for(int j=1; j<=i; j++)
			{
				System.out.print("* ");
			}
			for(int k=x; k>=i; k--)
			{
				System.out.print(" ");
			}
			System.out.println();
		}
		
	}

}
