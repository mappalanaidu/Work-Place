package FirstModule;

import java.util.Scanner;

public class PrimeNumberTesting {

	public static void main(String[] args)
	{
		// given no is prime or not
				Scanner sc=new Scanner(System.in);
				System.out.println("enter any number");
				int x=sc.nextInt();
				int flag=0;
				//logic
				for(int i=2;i<x;i++)
				{
					
				System.out.println(i+"time out side Loop is running");
					if(x%i==0)
					{
						System.out.println(i+"time from Inside Loop is running");
						flag=1;
						break;
					}
				}
				if(flag==0)
				{
				System.out.println("given no is prime");
				}
				else
				{
				System.out.println("given no is not a prime");
					
				}
	}

}
