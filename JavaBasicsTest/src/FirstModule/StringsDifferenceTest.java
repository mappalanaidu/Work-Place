package FirstModule;

import java.util.Scanner;

import org.apache.commons.lang.StringUtils;

public class StringsDifferenceTest {

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Eneter First String");
		String s1=sc.nextLine();
		System.out.println("Eneter Second String");
		String s2=sc.nextLine();
		String sd="";
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
				for(int i=0;i<s1.length()&& i<s2.length();i++)
				{
				if(s1.charAt(i)==s2.charAt(i))
				{
					continue;
				}else
				{
					sd=s1.substring(i, s1.length());
					
				}
				break;
				}
				System.out.println("First String is miss matched with Second String from : "+sd);
			  }
		else
				{
					for(int i=0;i<s1.length()&& i<s2.length();i++)
					{
					if(s1.charAt(i)==s2.charAt(i))
					{
						continue;
					}else
					{
						sd=s2.substring(i, s2.length());
						
					}
					break;
					}
					System.out.println("Second String is miss matched with First String from : "+sd);
				}	
		}
		
		/*StringUtils su=new StringUtils();
		String out=su.difference(s1,s2);
		System.out.println("Different Characters in both the Strings are : "+out);
		*/
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
