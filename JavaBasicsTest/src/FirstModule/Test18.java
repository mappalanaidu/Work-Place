package FirstModule;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Test18 {

	public static void main(String[] args) throws Exception 
	{
		// We need to provide file path as the parameter:
		  // double backquote is to avoid compiler interpret words
		  // like \test as \t (ie. as a escape sequence)
		  File file = new File("test.txt");
		 
		  BufferedReader br = new BufferedReader(new FileReader(file));
		 
		  String st1=br.readLine();
		  System.out.println(st1);
		  String st;
		  while ((st = br.readLine()) != null)
		    System.out.println(st);
	}

}
