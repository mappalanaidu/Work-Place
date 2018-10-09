package FirstModule;

public class SingleLevelInheritanceTest {

	public static void main(String[] args)
	{
		Child c=new Child();
		c.display2();
		//c.x=20;
		c.y=50;
		c.display1();
		
		Parent p=new Parent();
		p.x=10;
		p.display1();
		
				
	}

}
