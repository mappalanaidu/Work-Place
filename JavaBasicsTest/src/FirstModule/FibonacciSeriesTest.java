package FirstModule;

import java.util.Scanner;

public class FibonacciSeriesTest {

	public static void main(String[] args) 
	{
		// Fibonacci Series
		Scanner sc=new Scanner(System.in);
		System.out.println("enter any no");
		int x=sc.nextInt();
		//logi
		int temp1=0, temp2=1;
		System.out.println("Fibonacci Series of your entered no :");
		int res=temp1+temp2;
		while(res<=x)
		{
			System.out.print(" "+res);
			temp1=temp2;
			temp2=res;
			res=temp1+temp2;
		}
	}

}
