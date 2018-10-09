package FirstModule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {

	public static void main(String[] args) 
	{
		String x="My name is M Appal Naidu and my DOB is 01-07-87";
		//pattern RegExp
		Pattern p=Pattern.compile("[A-Z][a-z]+");
		Matcher m=p.matcher(x);
		while(m.find())
		{
			System.out.println(m.group());
		}
	}

}
