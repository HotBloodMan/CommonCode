package com.ljt.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapDemo2 {
public static void main(String[] args) {
	Map<String,String> map = new HashMap<>();
	map.put("a","12");
	map.put("aa","123");
	map.put("aaa","1234");
	Set<Entry<String, String>> set = map.entrySet();
	Iterator<Entry<String, String>> it = set.iterator();
	while(it.hasNext()){
		Entry<String, String> next = it.next();
		String key = next.getKey();
		String value = next.getValue();
		print(key+"对应的值是:"+value);
	}
}
private static void print(Object next) {
	// TODO Auto-generated method stub
	System.out.println("next=="+next);
}
}