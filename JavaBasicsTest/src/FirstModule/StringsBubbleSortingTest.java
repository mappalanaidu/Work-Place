package FirstModule;

import java.util.ArrayList;
import java.util.Scanner;

public class StringsBubbleSortingTest {

	public static void main(String[] args)
	{
	    
		//declare dynamic array
		ArrayList<String> al=new ArrayList<String>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a size");
		int n=Integer.parseInt(sc.nextLine());
		for(int i=0;i<n;i++)
		{
			switch(i+1)
			{
			case 1:
				System.out.println("Enter 1st word");
				break;
			case 2:
				System.out.println("Enter 2nd word");
				break;
			case 3:
				System.out.println("Enter 3rd word");
				break;
			default:
				System.out.println("Enter "+(i+1)+"th word");
				break;
				
			}
			al.add(sc.nextLine());
		}
		//Bubble Sorting Technic
				for(int i=0;i<n;i++)
				{
					for(int j=0;j<n-1;j++)
					{
						if(al.get(j).compareToIgnoreCase(al.get(j+1))>0)
						{
							String temp=al.get(j);
							al.set(j, al.get(j+1));
							al.set(j+1,temp);

							
						}
					}
				}
				//display sorted data
				for(int k=0;k<n;k++)
				{
					System.out.print(al.get(k)+" ");
				}
			}

		}