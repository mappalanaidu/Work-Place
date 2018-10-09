package FirstModule;

public class SingletonClass 
{
public int x;
private SingletonClass()
{
	x=10;
}
public static SingletonClass create()
{
	SingletonClass obj=new SingletonClass();
	return obj;
}
public void display()
{
	System.out.println("From SingletonClass");
	System.out.println(x);
	
}
}
