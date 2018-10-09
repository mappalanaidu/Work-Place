package FirstModule;

import java.util.Scanner;

public class FactorialTesting {

	public static void main(String[] args)
	{
		// Factorial of given no 
		Scanner sc=new Scanner(System.in);
		System.out.println("enter any no");
		//String x=sc.nextLine();
		int x=sc.nextInt();
		//logi
		int fn=1;
		for(int i=1; i<=x; i++)
		{
		fn=fn*i;
		}
		System.out.println("given no factorial is : "+fn);
	}

}
