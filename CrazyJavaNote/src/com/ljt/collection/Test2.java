package com.ljt.collection;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Test2 {
public static void main(String[] args) {
	String s="adfankjkl";
	char[] t=oP(s);
	for(int i=0;i<t.length;i++){
		print(t[i]);
	}
	tSort(t);
	//Arrays.sort(t);
}
public static char[] oP(String s){
	return s.toCharArray();
}
public static void print(Object obj)
{
	System.out.println(obj);
}
public static void tSort(char[] obj){
	Arrays.sort(obj);
	print(obj);
}
}
