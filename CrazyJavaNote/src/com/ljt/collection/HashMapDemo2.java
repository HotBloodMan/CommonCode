package com.ljt.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HashMapDemo2 {
public static void main(String[] args) {
	Map<String,List<Person>> map = new HashMap<>();
	List<Person> p1=new ArrayList<>();
	List<Person> p2=new ArrayList<>();
	p1.add(new Person("1",23,"qq"));
	p1.add(new Person("2",24,"qt"));
	p2.add(new Person("3",25,"qu"));
	p2.add(new Person("4",26,"qp"));
	map.put("a", p1);
	map.put("b", p2);
	
	Iterator<String> it = map.keySet().iterator();
	while(it.hasNext()){
		String next = it.next();
		System.out.println(next);
		List<Person> list = map.get(next);
		System.out.println("list==>>");
		sop(list);
	}
}
private static void sop(List<Person> list) {
//		Iterator<Person> its = list.iterator();
//		while(its.hasNext()){
//			Person next = its.next();
//			System.out.println("next"+next.getName()+next.getAge()+next.getHobby());
//			
//		}
	for(int i=0;i<list.size();i++){
		System.out.println(list.get(i).getName());
	}
}
}
