package collectionpkg;

import java.util.*;

public class MapSample {
	
	public static void main(String[] args) {
		TreeMap <String,String> myMap= new TreeMap<>(); 
		myMap.put("FR","France"); 
		myMap.put("IN","India");
		myMap.put("US","USA");
		myMap.put("UK","United Kingdom");
		System.out.println(myMap.get("FR"));
		myMap.remove("US");
		
		for ( Map.Entry<String, String> map: myMap.entrySet())
		{
			System.out.println(map.getKey()+":"+map.getValue());
		}
		
	}

}
