package FirstModule;

public class Sample8
{
//data members
	public int x;
	public int y;
	//constructor
	public Sample8()
	{
		x=10;
		y=20;
	}
	public Sample8(int a, int b)
	{
		x=a;
		y=b;
	}
	
	//methods
	public void display()
	{
		int z=x+y;
		System.out.println("Output is : "+z);
	}
	public int display(int p, int q)
	{
		int a=p;
		int b=q;
		int z=x+y+a+b;
		return(z);
	}
	
}
