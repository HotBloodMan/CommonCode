package com.ljt.oop;

public class InnerTest2 {
	private static final int x=7;
public static void main(String[] args) {
	Inner.function();
}
static class Inner{
	private static final int x=9;
	static void function(){
		System.out.println("��������ǣ�"+InnerTest2.x);
	}
}
}
