package com.ljt.oop;

public class InnerTest1 {

	private  class xinZang{
		void funtion(){
			System.out.println("������");
		}
	}
	public void show(){
		new xinZang();
	}
	public static void main(String[] args) {
	new InnerTest1().new xinZang().funtion();
	}
	
}
