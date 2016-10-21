package com.ljt;

import java.io.RandomAccessFile;

public class RandomAccessFileTest {
public static void main(String[] args) {
	try {
		RandomAccessFile raf = new RandomAccessFile("H:\\out.txt","r");
		System.out.println("RandomAccessFile���ļ�ָ��ĳ�ʼλ��:"+raf.getFilePointer());
		//�ƶ�raf���ļ���¼ָ���λ��
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
