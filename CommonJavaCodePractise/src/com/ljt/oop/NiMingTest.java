package com.ljt.oop;

public class NiMingTest {
	private final int x=9;
//	class Inner extends Abs{
//		private final int x=9;
//		@Override
//		void show() {
//			System.out.println("hh=="+x);
//		}
//	}
	Abs ab=new Abs(){
		@Override
		void show() {
		System.out.println("hh=="+x);	
		}
	};
	
	
	
	public static void main(String[] args) {
//		Abs inner = new NiMingTest().new Inner();
//		inner.show();
		new NiMingTest().ab.show();
	}
}
abstract class Abs{
	abstract void show();
}