package com.ljt.exception;

public class DivTest {
public static void main(String[] args) {
	try {
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c=a/b;
		System.out.println("�����������������Ľ���ǣ�"+c);
	} catch (IndexOutOfBoundsException e) {
		// TODO: handle exception
		System.out.println("����Խ�磺���г���ʱ����Ĳ�����������");
	}catch(NumberFormatException ne){
		ne.printStackTrace();
	}catch(ArithmeticException ae){
		System.out.println("�����쳣");
	}catch(Exception e){
		System.out.println("δ֪�쳣");
	}
}
}