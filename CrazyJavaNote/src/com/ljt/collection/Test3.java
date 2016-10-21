package com.ljt.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test3 {
public static void main(String[] args) {
	String [] str={"tr","te","tup"};
	List<String> list = Arrays.asList(str);
	sop(list);
	for(String obj:str){
		System.out.println("obj="+obj.toString());
	}
}
public static void sop(Object obj){
	System.out.println("list="+obj);
}
}
