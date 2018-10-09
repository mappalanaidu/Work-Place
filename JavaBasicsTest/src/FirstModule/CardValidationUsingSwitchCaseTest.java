package FirstModule;

import java.util.Scanner;

public class CardValidationUsingSwitchCaseTest {

	public static void main(String[] args) 
	{
		// Take a number from key board
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter CC  Type");
				String x=sc.nextLine();
				switch(x)
				{
					case "visha":
						System.out.print("Valid Card");
						break;
					case "Master":
						System.out.print("Valid Card");
						break;
					case "American Express":
						System.out.print("Valid Card");
						break;
					default:
						System.out.print("Invalid Card");
					}
				}
			}
