package FirstModule;

public class WrapperClassesTest {

	public static void main(String[] args)
	{
		Integer x=new Integer(9);
		Integer y=new Integer("6");
		Class<? extends Integer> s=x.getClass();
		Integer z=new Integer(x+y);
		System.out.println(s);
		System.out.println(z);
		System.out.println(x);
		System.out.println(y);
		Character c=new Character('a');
		int ac=c.BYTES;
		System.out.println(ac);
		char c1=new Character('a');
		char c2='A';
		System.out.println(c);
		System.out.println(c1);
		System.out.println(c2);
		
	}
}

