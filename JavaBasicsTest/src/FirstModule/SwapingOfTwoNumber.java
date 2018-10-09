package FirstModule;

import java.util.Scanner;

public class SwapingOfTwoNumber {

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter First Number");
		int x=sc.nextInt();
		System.out.println("Enter Second Number");
		int y=sc.nextInt();
		System.out.println("Before Swaping x="+x+"  y="+y);
		x=x+y;
		y=x-y;
		x=x-y;
		System.out.println("After Swaping x="+x+"  y="+y);
		

	}

}
