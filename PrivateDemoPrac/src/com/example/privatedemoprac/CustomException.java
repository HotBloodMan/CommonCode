package com.example.privatedemoprac;

//自定义异常类
public class CustomException extends Exception{
	
	public CustomException(){
		super();
	}
	public CustomException(String detailMessage,Throwable throwable){
		super(detailMessage,throwable);
	}
	public CustomException(String detailMessage){
		super(detailMessage);
	}
	public CustomException(Throwable throwable){
		super(throwable);
	}
	

}
