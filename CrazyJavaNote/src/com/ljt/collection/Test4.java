package com.ljt.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test4 {
public static void main(String[] args) {
	List<Person> list = new ArrayList<Person>();
	list.add(new Person("小李",23,"打台球"));
	list.add(new Person("小张",25,"打蓝球"));
	list.add(new Person("小李2",28,"打球"));
	list.add(new Person("小李3",30,"打球"));
	
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
