package com.ljt;

public class ManBuilder implements PersonBuilder{
	Person person;
	public ManBuilder() {
		super();
		person = new Man();
	}
	@Override
	public void buildHead() {
		// TODO Auto-generated method stub
		person.setHead("����man��ͷ");
	}
	@Override
	public void buildBody() {
		// TODO Auto-generated method stub
		person.setBody("����man������");
	}
	@Override
	public void buildFoot() {
		// TODO Auto-generated method stub
		person.setFooot("����man�Ľ�");
	}
	@Override
	public Person buildPerson() {
		// TODO Auto-generated method stub
		return person;
	}
}
