package com.ljt.collection;

import java.util.Vector;

public class VectorDemo {
public static void main(String[] args) {
	Vector vector = new Vector();
	vector.addElement("89");
	vector.addElement("80");
	vector.addElement("12");
	vector.addElement("45");
	print(vector);
	String f = (String) vector.firstElement();
	print(f);
}
public static void print(Object obj)
{
	System.out.println(obj);
}
}
