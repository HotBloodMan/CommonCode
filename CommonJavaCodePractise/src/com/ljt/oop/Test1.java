package com.ljt.oop;

import java.lang.reflect.Array;
import java.util.Collections;

public class Test1 {
public static void main(String[] args) {
	int[] arr={12,3,343,45,5,2};
	int t=getMax(arr);
	print(t);
	sort(arr);
	printArray(arr);
}
public static int getMax(int[] arr){
	int max=0;
	for(int i=0;i<arr.length-1;i++)
	{
		if(arr[i]>max){
			max=arr[i];
		}
	}
		return max;
}
public static void print(Object obj)
{
	System.out.println(obj);
}
public static void sort(int[] arr){
	for(int i=0;i<arr.length-1;i++){
		for(int j=i+1;j<arr.length;j++){
			if(arr[i]>arr[j]){
				swap(arr,i,j);
			}
		}
	}
}
private static void swap(int[] arr, int i, int j) {
	int f;
	if(arr[i]<arr[j]){
		f=arr[i];
		arr[i]=arr[j];
		arr[j]=f;
	}
}
public static void printArray(int[] arr)
{
	System.out.print("[");
	for(int x=0; x<arr.length; x++)
	{
		if(x!=arr.length-1)
			System.out.print(arr[x]+", ");
		else
			System.out.println(arr[x]+"]");
	}
}


}
