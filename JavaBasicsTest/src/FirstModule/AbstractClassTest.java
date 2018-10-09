package FirstModule;

public class AbstractClassTest {

	public static void main(String[] args) 
	{
		Sameple10 obj1=new AbstracConcreateClass();
		int x=obj1.add(10,30);
		 int y=obj1.substract(20, 30);
		System.out.println("From Obj1  Add: "+x+"  Substract :"+y);
		AbstracConcreateClass obj2=new AbstracConcreateClass();
		int x1=obj2.add(50, 40);
		int y1=obj2.substract(20, 50);
		int z=obj2.multiplay(10, 20);
		System.out.println("From Obj1 : Add: "+x1+"  Substract :"+y1+"  Multiplay :"+z);
	}

}
