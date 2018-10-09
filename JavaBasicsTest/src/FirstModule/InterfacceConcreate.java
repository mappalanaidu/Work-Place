package FirstModule;

public class InterfacceConcreate implements MyInterface
{

	
	public int add(int x, int y) {
		int z=x+y;
		return(z);
	}

	
	public int substract(int x, int y) {
		int z=x-y;
		return(z);
	}

	
	public int division(int x, int y) {
		int z=x/y;
		return(z);
	}

	
	public int multiplay(int x, int y) {
		int z=x*y;
		return(z);
	}

}
