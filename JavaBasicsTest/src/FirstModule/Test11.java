package FirstModule;

import java.util.Scanner;

public class Test11 {

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter first no");
		int x=sc.nextInt();
		System.out.println("Enter second no");
		int y=sc.nextInt();
		
		// create obj to interface 
		Sample4 obj1=new Sample5();
		int z=obj1.add(x, y);
		System.out.println("Add result :"+z);
		
		int w=obj1.subtract(x, y);
		System.out.println("Subtract result :"+w);
		
	}

}
