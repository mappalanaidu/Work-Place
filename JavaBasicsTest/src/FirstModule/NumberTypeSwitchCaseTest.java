package FirstModule;

import java.util.Scanner;

public class NumberTypeSwitchCaseTest {

	public static void main(String[] args)
	{
		// Take a number from key board
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a number");
		String x=sc.nextLine();
		for(int i=0;i<x.length();i++)
		{
			char c=x.charAt(i);
		switch(c)
		{
			case '0':
				System.out.print("Zero ");
				break;
			case '1':
				System.out.print("One ");
				break;
			case '2':
				System.out.print("Two ");
				break;
			case '3':
				System.out.print("Three ");
				break;
			case '4':
				System.out.print("Four ");
				break;
			case '5':
				System.out.print("Five ");
				break;
			case '6':
				System.out.print("Six ");
				break;
			case '7':
				System.out.print("Seven ");
				break;
			case '8':
				System.out.print("Eight ");
				break;
			case '9':
				System.out.print("Nine ");
				break;
			default:
				System.out.print("Wrong No.");
			}
		}
	}

}
