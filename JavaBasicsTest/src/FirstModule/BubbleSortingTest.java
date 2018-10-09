package FirstModule;

import java.util.Scanner;

public class BubbleSortingTest {

	public static void main(String[] args)
	{
		// declare 5 input values array
		int x[]=new int[5];
		//take input from keyboard
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<5;i++)
		{
			System.out.println("Enter "+(i+1)+" value");
			x[i]=sc.nextInt();
		}
		//Bubble Sorting Technic
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(x[j]>x[j+1])
				{
					int temp=x[j];
					x[j]=x[j+1];
					x[j+1]=temp;
					
				}
			}
		}
		//display sorted data
		for(int i=0;i<5;i++)
		{
			System.out.print(x[i]+" ");
		}
	}

}
