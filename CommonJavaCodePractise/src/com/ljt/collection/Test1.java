package com.ljt.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class Test1 {
public static void main(String[] args) {
	ArrayList<ArrayList<String>> list = new ArrayList<>();
	ArrayList<String> list2 = new ArrayList<String>();
	ArrayList<String> list3 = new ArrayList<String>();
	list2.add("a");
	list2.add("b");
	list2.add("c");
	list3.add("d");
	list3.add("e");
	list3.add("f");
	list.add(list2);
	list.add(list3);
	Iterator<ArrayList<String>> it = list.iterator();
	while(it.hasNext()){
		ArrayList<String> next = it.next();
		print(next);
		for(int i=0;i<next.size();i++){
			print(next.get(i));
		}
	}
}
public static void print(Object obj){
	System.out.println(obj);
}
}
