package com.ljt.map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class MapDemo1 {
public static void main(String[] args) {
	HashMap<String,String> map = new HashMap<>();
	map.put("a", "12");
	map.put("b", "123");
	map.put("c", "1234");
	for(int i=0;i<map.size();i++){
		Collection<String> values = map.values();
		print(values);
	}
	HashMap<String,List> map2 = new HashMap<>();
	List<Integer> list = new ArrayList<Integer>();
	List<String> list2 = new ArrayList<String>();
	list.add(1);
	list.add(12);
	list.add(123);
	list2.add("Äã");
	list2.add("ÎÒ");
	list2.add("Ëû");
	map2.put("aa",list);
	map2.put("bb",list2);
	print(map2);
}
public static void print(Object object){
	System.out.println(object);
}
}
