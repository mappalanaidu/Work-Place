package FirstModule;

public class Test13 {

	public static void main(String[] args)
	{
	Sample8 obj1=new Sample8();
	obj1.display();
	int x=obj1.display(30, 40);
	System.out.println(x);
	
	Sample8 obj2=new Sample8(50,60);
	obj2.display();
	int y=obj2.display(30, 40);
	System.out.println(y);
	
	}

}
