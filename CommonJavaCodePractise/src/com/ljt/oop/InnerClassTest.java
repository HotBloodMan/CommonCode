package com.ljt.oop;

public class InnerClassTest {
public static void main(String[] args) {
	Test.function().method();
}	
}

interface Inter{
	 void method();
}

class Test{

	static Inter function() {
		// TODO Auto-generated method stub
		return new Inter(){
			@Override
			public void method() {
				System.out.println("ÄãºÃ°¡");
			}};
	}		
	}