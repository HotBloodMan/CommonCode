package com.ljt.oop;

public class Test3 extends Tem{
	
public Test3() {
		super();
	}

	public Test3(int x) {
		super(x);
	}

public static void main(String[] args) {
	Test3 test3 = new Test3();
	System.out.println(test3.a);
	Test3 test = new Test3(23);
	System.out.println(test.a);
	
}
}
abstract class Tem{
	int a;
	public Tem(){
		a=7;
	}
	public Tem(int x){
		a=x;
	}
}
