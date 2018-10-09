package FirstModule;

public class Child extends Parent
{
	public int x;
	public int y;
	public void display2()
	{	this.x=20;
		//super.x=30;
		System.out.println(y);
	}
	public void display1()
	{
		//this.display1();
		//super.display1();
		System.out.println(x);
	}
	
}
