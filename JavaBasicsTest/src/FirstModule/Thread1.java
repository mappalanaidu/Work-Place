package FirstModule;

public class Thread1 extends Thread
{
	public void run()
	{
	for(int i=0;i<=50;i++)
	{
		System.out.println("First for() Loop");
	}
	System.out.println("****************-Middle-*****************");
	System.out.println("****************-Middle-*****************");
	System.out.println("****************-Middle-*****************");
	System.out.println("****************-Middle-*****************");
	System.out.println("****************-Middle-*****************");
	System.out.println("****************-Middle-*****************");
	System.out.println("****************-Middle-*****************");
	System.out.println("****************-Middle-*****************");
	System.out.println("****************-Middle-*****************");
	System.out.println("****************-Middle-*****************");
	try
	{
		Thread.sleep(1000);
	}catch(Exception e)
	{
		
	}
	System.out.println("@@@@@@@****************-Middle-*****************@@@@@@");
	System.out.println("****************-Middle-*****************");
	System.out.println("****************-Middle-*****************");
	System.out.println("****************-Middle-*****************");
	System.out.println("****************-Middle-*****************");
	}
}
