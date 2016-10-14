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
		person.setHead("建造man的头");
	}
	@Override
	public void buildBody() {
		// TODO Auto-generated method stub
		person.setBody("建造man的身体");
	}
	@Override
	public void buildFoot() {
		// TODO Auto-generated method stub
		person.setFooot("建造man的脚");
	}
	@Override
	public Person buildPerson() {
		// TODO Auto-generated method stub
		return person;
	}
}
