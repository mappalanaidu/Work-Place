package FirstModule;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringWithRegexTest {

	public static void main(String[] args) throws Exception
	{
		// Open text file in read mode
		File f1=new File("testdata.txt");
		FileReader fr=new FileReader(f1);
		BufferedReader br=new BufferedReader(fr);
		
		//Open other file for writing 
		File f2=new File("testresult.txt");
		FileWriter fw=new FileWriter(f2);
		BufferedWriter bw=new BufferedWriter(fw);
		
		String s="";
		int nol=0;
		int now=0;
		int non=0;
		
		while((s=br.readLine())!=null)
		{
			nol=nol+1;
			if(nol==2)
			{
				bw.write("Second line from the given file is : "+s);
				bw.newLine();
				System.out.println(s);
			}
			String[] temp=s.split(" ");
			now=now+temp.length;
			Pattern p=Pattern.compile("[0-9]+");
			Matcher m=p.matcher(s);
			while(m.find())
			{
				non=non+1;
			}
		}
		//send out put to other file
		bw.write("No. lines in file are : "+nol);
		bw.newLine();
		bw.write("No. words in file are : "+now);
		bw.newLine();
		bw.write("No. Numaric Values in file are : "+non);
		
		//close files
		bw.close();
		fw.close();
		br.close();
		fr.close();
		
	}

}
