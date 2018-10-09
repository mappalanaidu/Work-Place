package FirstModule;

import java.util.Scanner;

public class SwitchCaseToDisplayDay {

	public static void main(String[] args)
	{
		// Take a number from key board
				Scanner sc=new Scanner(System.in);
				System.out.println("enter a day number");
				int x=sc.nextInt();
				
				switch(x)
				{
					case 1:
						System.out.print("Sunday");
						break;
					case 2:
						System.out.print("Monday");
						break;
					case 3:
						System.out.print("Tuesday");
						break;
					case 4:
						System.out.print("Wednesday");
						break;
					case 5:
						System.out.print("Thursday");
						break;
					case 6:
						System.out.print("Friday");
						break;
					case 7:
						System.out.print("Saturday");
						break;
					default:
						System.out.print("Wrong Week day No.");
				}
			}

		}
