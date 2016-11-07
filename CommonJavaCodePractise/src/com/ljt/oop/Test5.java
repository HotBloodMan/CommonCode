package com.ljt.oop;

public class Test5 {

	public static void function(Animal a){
		a.eat();
		a.sleep();
	}
	public static void main(String[] args) {
		Test5.function(new Cat());
		Test5.function(new Dog());
	}
}
class Cat implements Animal{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("吃鱼");
	}
	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("睡大觉");
	}
}
class Dog implements Animal{
	@Override
	public void eat() {
		System.out.println("吃骨头");
	}
	@Override
	public void sleep() {
		System.out.println("吃一天");
	}
	
}