package FirstModule;

public class MultiLevelInheritanceTest {

	public static void main(String[] args)
	{
		Parent p=new Parent();
		p.x=10;
		p.display1();
		Child c=new Child();
		//c.x=20;
		//c.y=30;
		
		c.display2();
		c.display1();
		GChild gc=new GChild();
		
		gc.display3();
		gc.display2();
		Parent g=new GChild();
		//g.x=80;
		g.display1();
	}

}
