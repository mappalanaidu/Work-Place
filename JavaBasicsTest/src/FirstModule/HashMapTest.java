package FirstModule;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

	public static void main(String[] args)
	{
		//declare hashmap to store pair of values
		HashMap<Integer,String> hm=new HashMap<Integer,String>();
		//store pair of data into hashmap
		hm.put(100, "Bhagya");
		hm.put(101, "Kusuma");
		hm.put(102, "Bhavjeet");
		hm.put(103, "Bhuvi");
		hm.put(104, "Naidu");
		
		//change value dependence on key
		hm.put(100, "Kalavathi");
		
		//replace other key value in place of existing key value
		hm.put(106, hm.remove(102));
		
		//display values 
		for(Map.Entry<Integer, String> e:hm.entrySet())
		{
			System.out.println(e.getKey()+" "+e.getValue());
		}
	}

}
