package FirstModule;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValuesSeperationTest {

	public static void main(String[] args) throws Exception 
	{
		// Open text file in read mode
				File f1=new File("testdata.txt");
				FileReader fr=new FileReader(f1);
				BufferedReader br=new BufferedReader(fr);
				
				//Open other file for writing 
				File f2=new File("testresult.txt");
				FileWriter fw=new FileWriter(f2,true);
				BufferedWriter bw=new BufferedWriter(fw);
				Date d=new Date();
				
				bw.write("***************"+d+"********************");
				bw.newLine();
				int count=0;
				String temp="";
				while((temp=br.readLine())!=null)
				{
					Pattern p=Pattern.compile("[0-9]+");
					Matcher m=p.matcher(temp);
					while(m.find())
					{
						count++;
						bw.write(m.group()+"\t");
						
					}
					bw.newLine();
				}
				
				//System.out.println("No. of spaces are :"+count);
				//close files
				bw.close();
				fw.close();
				br.close();
				fr.close();
			
	}

}
