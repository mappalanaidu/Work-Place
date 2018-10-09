package FirstModule;

import java.util.Scanner;

public class StringsDiffCharactersTest {

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Eneter First String");
		String s1=sc.nextLine();
		System.out.println("Eneter Second String");
		String s2=sc.nextLine();
		String s1cs="";
		String s2cs="";
		int count=0;
		try
		{
			if(s1.equals(null) && s2.equals(null) || s1.equalsIgnoreCase(s2))
		
		{
			System.out.println("Both Strings are Same");
		}
		else
		{			
			if(s1.length()>=s2.length())
			{
				for(int i=0;i<s1.length();i++)
				{
				if(s1.charAt(i)==s2.charAt(i))
				{
					count++;
					continue;
				}else
				{
					s1cs=s1cs+s1.charAt(i);
					count++;
				}
				//s1cs=s1cs+s1.substring(i, s1.length());
				}
				s1cs=s1cs+s1.substring(count,s1.length());
				System.out.println("First String is miss matched with Second String from : "+s1cs);
			  }
		else
				{
					for(int i=0;i<s2.length();i++)
					{
					if(s1.charAt(i)==s2.charAt(i))
					{
						count++;
						continue;
					}else
					{
						s2cs=s2cs+s2.charAt(i);
						count++;
					}
					//s2cs=s2cs+s2.substring(i, s2.length());
					}
					s2cs=s2cs+s2.substring(count, s2.length());
					
					System.out.println("First String is miss matched with Second String from : "+s2cs);
				 }	
			}
		
		}
		catch(Exception e)
		{
			System.out.println("From exception :"+e.getMessage());
		}
	}

}
