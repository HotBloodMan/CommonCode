package com.ljt.fanxing;

public class Test2 <T>{
	
	public <T> void qq(T t){
		System.out.println("你好"+t);
	}
	public <Q> void print(Q t){
		System.out.println("打印的是"+t);
	}
	
	public static void main(String[] args) {
		Test2 t = new Test2();
		t.qq(new Integer(4));
		t.print("哈哈");
	}
}
