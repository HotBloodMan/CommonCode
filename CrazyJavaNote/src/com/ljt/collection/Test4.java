package com.ljt.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test4 {
public static void main(String[] args) {
	List<Person> list = new ArrayList<Person>();
	list.add(new Person("С��",23,"��̨��"));
	list.add(new Person("С��",25,"������"));
	list.add(new Person("С��2",28,"����"));
	list.add(new Person("С��3",30,"����"));
	
//	for(int i=0;i<list.size();i++){
//		//Person person = new Person();
//		sop(list.get(i).getName()+list.get(i).getAge()+list.get(i).getHobby());
//	}
	Iterator<Person> it = list.iterator();
	while(it.hasNext()){
		Person next = it.next();
		sop(next.getName()+next.getAge()+next.getHobby());
	}
}

private static void sop(Object list) {
	System.out.println(list);
}
}
