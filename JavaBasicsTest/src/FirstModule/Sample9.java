package FirstModule;

public class Sample9 
{
//data members
	public int x;
	public int y;
	//constructors
	public Sample9()
	{
		x=10;
		y=20;
	}
	
	public Sample9(int a, int b)
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
		
}
