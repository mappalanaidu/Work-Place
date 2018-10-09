package FirstModule;

public class Sample10
{
//data members
	public int x;
	public int y;
	//constructor
	public Sample10()
	{
		x=10;
		y=20;
		
	}
	public Sample10(int a,int b)
	{
		x=a;
		y=b;
		
	}
	//operational methods with polymorphism
	public int add1()
	{
		//Sample10 obj=new Sample10();
		int z=x+y;
		return(z);
	}
	
public void add1(int a,int b)
	{
		int x=a, y=b;//Sample10 obj=new Sample10(a,b);
		int z=x+y;
		System.out.println(z);
	}
}
