package com.ljt.collection;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinekedListDemo {
	static LinkedList list;
	public static void main(String[] args) {
		list = new LinkedList();
		list.add("ad");
		list.add("ad2");
		list.add("ad3");
		list.add("ad4");
//		String first = (String) list.getFirst();
//		System.out.println(first);
//		list.removeLast();
//		print(list);
//		String peek =(String) list.peek();
//		print("========================");
//		print(peek);
//		String s="798";
//		addFirst(s);
		//print(list);
		ListIterator iterator = list.listIterator();
		boolean it = iterator.hasPrevious();
		print(iterator);
		print(it);
		boolean b = iterator.hasPrevious();
		list.subList(0, 2);
		print("--------------");
		print(list);
	}
	public static void print(Object obj)
	{
		System.out.println(obj);
	}
	public static void addFirst(Object obj){
		//LinkedList lv = new LinkedList();
		list.addFirst(obj);
		System.out.println(list);
	}
}
