package MyJarFilesTest;

import FirstModule.Sample3;
import FirstModule.Sample4;
import FirstModule.Sample5;
import FirstModule.Test1;

public class FirstJarFileTest1
{

	public static void main(String[] args) 
	{
		//create object to Sample3 class
		Sample3 s=new Sample3();
		float x=s.add(10,50);
		//System.out.println(x);
		Sample4 s4=new Sample5();
		int y=s4.add(20, 80);
		System.out.println(y);
		int z=s4.subtract(50, 60);
		System.out.println(z);
		Test1 t=new Test1();
		int count=0;
		while(2>1)
			{
			float x1=s.add(10,50);
			int z1=s4.subtract(50, 60);
			System.out.println(z1);
			
			//t.main(null);
			count++;
			if(count==10000)
				break;
			}
				
	}

}
