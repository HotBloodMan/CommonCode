package com.ljt.exception;

import java.io.FileInputStream;

public class AccessExceptionMsg {
public static void main(String[] args) {
	try {
		FileInputStream fis = new FileInputStream("H:\\out2.txt");
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
}
}
