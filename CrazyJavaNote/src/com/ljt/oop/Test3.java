package com.ljt.oop;

public class Test3 {
public static void main(String[] args) {
	int s=50;
	boolean flag=charTo(s);
	print(flag);
}
public static boolean  charTo(int s){
	
	if(s>45){
		return true;
	}
	return false;
	
}
public static void print(Object obj){
	System.out.println(obj);
}
}
