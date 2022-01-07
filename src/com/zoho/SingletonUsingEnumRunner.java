package com.zoho;




public class SingletonUsingEnumRunner {
	public static void main(String[] args) {

	System.out.println(SingletonUsingEnum.INSTANCE.hashCode());
	System.out.println(SingletonUsingEnum.INSTANCE.hashCode());
	SingletonUsingEnum.INSTANCE.display();
}
}
