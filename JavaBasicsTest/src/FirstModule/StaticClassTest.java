package FirstModule;

public class StaticClassTest {

	public static void main(String[] args) 
	{
		StaticClass.display();
		StaticClass s=new StaticClass();
		s.x=10;
		s.y=20;
		s.display();
		main("9");
	}
	public static void main(String x) 
	{
		
		System.out.println("HI"+x);
	}

}
