package FirstModule;

public class SingletonRunnerClass {

	public static void main(String[] args) 
	{
		// create object to singleton class
		SingletonClass sc=SingletonClass.create();
		sc.display();

	}

}
