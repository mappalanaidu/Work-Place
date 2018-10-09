package FirstModule;

import java.util.Scanner;

public class CountingDiffCharactersInString {

	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a String");
		String x=sc.nextLine();
		int nol=0,nou=0,nod=0,nosc=0;
		String snol="",snou="",snod="",snosc="";
		
		for(int i=0;i<x.length();i++)
		{
		char c=x.charAt(i);
		if(c<=122 && c>=97)
		{
			nol++;
			snol=snol+x.charAt(i);
		}
		else if(c<=90 && c>=65)
		{
			nou++;
			snou=snou+x.charAt(i);
		}
		else if(c<=57 && c>=48)
		{
			nod++;
			snod=snod+x.charAt(i);
		}
		else
		{
			nosc++;
			snosc=snosc+x.charAt(i);
		}
	}
		System.out.println("No of lower case alphabet are:"+nol+" Those letters are"+snol);
		System.out.println("No of upper case alphabet are:"+nou+" Those letters are"+snou);
		System.out.println("No of digits are:"+nod+" Those digits are"+snod);
		System.out.println("No of special chars are:"+nosc+" Those are"+snosc);
  }

}
