package FirstModule;

import java.util.Scanner;

public class Test12 {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter first no");
		int x=sc.nextInt();
		System.out.println("Enter second no");
		int y=sc.nextInt();	
		
		// create obj to abstract class
		
		Sample6 s6=new Sample7();
		s6.add(x, y);
		s6.subtract(x,y);
		Sample7 s7=new Sample7();
		s7.add(x, y);
		s7.subtract(x,y);
		

	}

}
