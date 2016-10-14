package com.ljt;

public class Test {
public static void main(String[] args) {
	PersonDirector pd = new PersonDirector();
	Person person = pd.constructPerson(new ManBuilder());
	System.out.println(person.getBody());
	System.out.println(person.getFooot());
	System.out.println(person.getHead());
}
}
