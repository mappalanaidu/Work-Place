package FirstModule;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class LettersCountingInString 
{
	public static void main(String[] args) throws Exception
	{
		/*Scanner sc=new Scanner(System.in);
		System.out.println("Enter a String");
		String x=sc.nextLine();
		*/
		File f=new  File("Letters.txt");
		FileReader fr=new FileReader(f);
		BufferedReader br=new BufferedReader(fr);
		int count=0;
		String temp="";
		if((temp=br.readLine())!=null)
		{
			String s=temp;
		for(int i=0;i<s.length();i++)
		{
			for(int j=0;j<s.length();j++)
			{
				if(s.charAt(i)==s.charAt(j))
				{
					count++;
				}
			}
			File f1=new File("LettersResulet.txt");
			FileWriter fw=new FileWriter(f1,true);
			fw.write((char)s.charAt(i)+" Letter is repeated in given String is :"+count+"\t");
			fw.flush();
			fw.close();
			System.out.println((char)s.charAt(i)+" Letter is repeated in given String is :"+count);
				String d=String.valueOf(s.charAt(i));
				s=s.replace(d,"");
				count=0;
		}
		
	}

	}
}