package FirstModule;

	public class AClass
	{
	    private int _myField;

	    public AClass()
	    {
	        int i = 0; // 1
	        _myField = 0; // 2

	       // AClass aClass = new AClass(); // 3
	        // Note StackOverflowException here, this is just to show there is no 
	        // difference between memory allocation in a constracutor and a method.
	    }

	    public static AClass Create()
	    {
	        int i = 0; // 4

	        AClass aClass = new AClass(); // 5

	        aClass._myField = 0; // 6

	        return aClass;
	    }
	}

