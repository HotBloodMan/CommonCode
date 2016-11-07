package com.ljt.oop;

public class Outer {
private static  int x=3;
class Inner{
	void function(){
		System.out.println(Outer.this.x);
	}
}
void method(){
	Inner inner = new Inner();
	inner.function();
}
public static void main(String[] args) {
//	Outer outer = new Outer();
//	outer.method();
	Inner inner = new Outer().new Inner();
	inner.function();
}
}
