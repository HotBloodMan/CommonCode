package com.ljt;

import java.io.RandomAccessFile;

public class RandomAccessFileTest {
public static void main(String[] args) {
	try {
		RandomAccessFile raf = new RandomAccessFile("H:\\out.txt","r");
		System.out.println("RandomAccessFile的文件指针的初始位置:"+raf.getFilePointer());
		//移动raf的文件记录指针的位置
		raf.seek(300);
		byte[] bbuf=new byte[1024];
		int hasRead=0;
		while((hasRead=raf.read(bbuf))>0){
			System.out.println(new String(bbuf,0,hasRead));
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
