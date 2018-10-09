package FirstModule;

public class GChild extends Child
{
	public int y;
	
	public void display3()
	{
		
		//this.y=50;
		super.y=40;
		System.out.println(y);
		//this.display2();
		//super.display2();
	}
	public void display2()
	{    super.display2();
		System.out.println(y);
	}	
}
