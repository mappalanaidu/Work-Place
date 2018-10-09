package FirstModule;

public class ThreadRunnerTest 
{
	public static void main(String[] args) throws InterruptedException
	{
		Thread2 t2=new Thread2();
		Thread1 t1=new Thread1();
		t1.start();
		//t1.sleep(2000);
		
		t2.start();
	}

}

