package com.ljt.oop;

public class InnerTest3 {

	void function(int x){
		class Inner{
			int x=9;
		    void show(int a){
			System.out.println("Êý×ÖÊ½=="+a);	
			}
		}
		new Inner().show(x);
	}
	public static void main(String[] args) {
		new InnerTest3().function(28);
	}
}
