package FirstModule;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test17 {

	public static void main(String[] args) throws Exception
	{
		try
		{
		String number = "";
         String letter = "";
         // enter any text file to read
		File f=new File("test.txt");	
         FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
				File f1=new File("test1.txt");	
	        	FileWriter fw1=new FileWriter(f1);
	        	///BufferedWriter br1=new BufferedWriter(fw1);
	        	File f2=new File("test2.txt");	
	        	FileWriter fw2=new FileWriter(f2);
	        	//BufferedWriter br2=new BufferedWriter(fw2);
			String input;
	        while((input=br.readLine())!=null)
			{
	        	System.out.println(input);
	        	   
		        for (int i=0; i<input.length(); i++)
		        {
		        	char a = input.charAt(i);
                    if (Character.isDigit(a)) 
                    {
                         number = number + a;
                         fw2.write(a);
                      } 
                    else {
                          letter = letter + a;
                          fw1.write(a);
                        }
                    
  		      }
		           
		       }
	        System.out.println("Alphates in string:"+letter);
            System.out.println("Numbers in String:"+number);

	        fw1.flush();
	        fw1.close();
	        fw2.flush();
	        fw2.close();
	        
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		}
	}	
