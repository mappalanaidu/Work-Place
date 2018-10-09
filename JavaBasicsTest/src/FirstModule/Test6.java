package FirstModule;

import java.util.Scanner;

public class Test6 {

	public static void main(String[] args) 
	{
		// Stars prining in traingle
				Scanner sc=new Scanner(System.in);
				System.out.println("enter any no");
				int x=sc.nextInt();
				//logi
				for(int i=1; i<=x; i++)
				{
					for(int j=1; j<=i; j++)
					{
						System.out.print("* ");
					}
					for(int k=x-1; k>=i; k--)
					{
						System.out.print(" ");
					}
					System.out.println("");
				}
	}
}