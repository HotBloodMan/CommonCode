package com.ljt;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ReadStandard {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			PrintStream ps = new PrintStream(new FileOutputStream("H:\\out.txt"));
			sc.useDelimiter("\n");
			while(sc.hasNext()){
				//�����
				ps.println("���������������:"+sc.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
