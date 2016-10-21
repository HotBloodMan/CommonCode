package com.ljt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFromProcess {
public static void main(String[] args) throws IOException {
	Process p = Runtime.getRuntime().exec("javac");
	BufferedReader br = new BufferedReader(new InputStreamReader(p.getErrorStream()));
	String buff=null;
	try {
		while((buff=br.readLine())!=null){
			System.out.println(buff);
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
}
}
