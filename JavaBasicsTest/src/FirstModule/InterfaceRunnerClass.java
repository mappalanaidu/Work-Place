package FirstModule;

public class InterfaceRunnerClass {

	public static void main(String[] args) 
	{
		MyInterface obj1=new InterfacceConcreate();
		int x=obj1.add(10,30);
		 int y=obj1.substract(20, 30);
		 int w=obj1.division(20, 10);
		 int z=obj1.multiplay(10,2);
		System.out.println("From Obj1  Add: "+x+"  Substract :"+y+"  Divide "+w+"  Multiplay :"+z);
		InterfacceConcreate obj2=new InterfacceConcreate();
		int x1=obj2.add(50, 40);
		int y1=obj2.substract(20, 50);
		int w1=obj2.division(20, 10);
		 int z1=obj2.multiplay(10, 20);
		System.out.println("From Obj1 : Add: "+x1+"  Substract :"+y1+"  Divide "+w1+"  Multiplay :"+z1);
		
	}

}
