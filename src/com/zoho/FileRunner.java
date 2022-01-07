package com.zoho;

import java.io.*;

import java.util.*;
import java.lang.reflect.*;
import com.logiclayer.*;

public class FileRunner {
	public enum Color{
		VIOLET(1),INDIGO(2),BLUE(3),GREEN(4),YELLOW(5),ORANGE(6),RED(7);
		private int value;
		private Color(int code) {
			value=code;
		}
	}
    
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
    FileLogic objForFile=new FileLogic();
    int quesNo=0;
    try {
    System.out.println("enter your question no");
    quesNo=sc.nextInt();
    sc.nextLine();
    }
    catch(Exception e) {
    	System.out.println(e.getMessage());
    }
    CreateFile objForFileCreation=new CreateFile();
    PropertiesPutFile objForCase2=new PropertiesPutFile();
    FileIntoProperties objForCase3=new FileIntoProperties();
switch(quesNo) {
case 1:
try {
	objForFileCreation.case1();
}
catch(CustomException e) {
	System.out.println(e.getMessage());
}
catch(Exception e) {
	System.out.println("enter a number");
	e.printStackTrace();
}
break;
case 2:
try {
	objForCase2.case2();
}
catch(CustomException e) {
	System.out.println(e.getMessage());
}
catch(Exception e) {
	System.out.println("enter a number");
}
break;
case 3:
try {
	objForCase3.case3();
}
catch(CustomException e) {
	System.out.println(e.getMessage());
}
catch(Exception e) {
	System.out.println("enter a number");
}
break;
case 4:
try {
	System.out.println("enter path name");
	String path=sc.nextLine();
	System.out.println("enter directory name");
	String dirName=sc.nextLine();
	objForFile.makeDirectory(path,dirName);
	objForFileCreation.case1();
	objForCase2.case2();
	objForCase3.case3();
}
catch(CustomException e) {
	System.out.println(e.getMessage());
}
catch(Exception e) {
	System.out.println("enter a number");
}

break;
case 5:
try {
	System.out.println("give any string");
	String input=sc.nextLine();
	InvokeConstructor objForCase5=new InvokeConstructor(input);
	System.out.println(objForCase5);
}
catch(Exception e) {
	System.out.println(e.getMessage());
}
	break;
case 6:
try {
	System.out.println("given your name");
	String name=sc.nextLine();
	System.out.println("enter your id");
	int id=sc.nextInt();
	PojoClass objForCase6=new PojoClass(name,id);
	System.out.println(objForCase6);
	
}
catch(Exception e) {
	System.out.println("please enter number");
}

case 7:
try {
	System.out.println("given your name");
	String name_1=sc.nextLine();
	System.out.println("given your id");
	int id_1=sc.nextInt();
	PojoClass objForCase7=new PojoClass();
	objForCase7.setName(name_1);
	objForCase7.setId(id_1);
	System.out.println(objForCase7.getName());
	System.out.println(objForCase7.getId());
}
catch(Exception e) {
	System.out.println("please enter number");
}
	break;
case 8:
	try {
		Class<?> myClass = Class.forName("com.reflect.PogoReflection");
       Object myObject=myClass.getDeclaredConstructor().newInstance();
       Method[] m=myClass.getMethods();
       for(Method a:m) {
    	   System.out.println(a);
       }
       Constructor<?> objCons= myClass.getDeclaredConstructor();
       Object object=objCons.newInstance();
	   Constructor<?> cons= myClass.getDeclaredConstructor(String.class,int.class);
	    System.out.println("enter your name");
	    String name8=sc.nextLine();
	     System.out.println("enter your id");
	     int id8=sc.nextInt();
	     //sc.nextLine();
	     Object object1=cons.newInstance(name8,id8);
	     System.out.println(object1);
		 Method objForSetter=myClass.getDeclaredMethod("setName", String.class);
		 objForSetter.invoke(myObject,name8);
		 Method objForGetter=myClass.getDeclaredMethod("getName", null);
		 System.out.println(objForGetter.invoke(myObject, null));
		 
	}

	catch(Exception e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
		
	break;

case 9:
try {
	System.out.println("enter color");
	String color=sc.nextLine();
	Utility.stringCheck(color);
	String upperCaseColor=color.toUpperCase();
	Color colorName=Color.valueOf(upperCaseColor);
	switch(colorName) {
	case VIOLET:
		System.out.println("color code of "+colorName+" is "+colorName.value);
		break;
	case INDIGO:
		System.out.println("color code of "+colorName+" is "+colorName.value);
		break;
	case BLUE:
		System.out.println("color code of "+colorName+" is "+colorName.value);
		break;
	case GREEN:
		System.out.println("color code of "+colorName+" is "+colorName.value);
		break;
	case YELLOW:
		System.out.println("color code of "+colorName+" is "+colorName.value);
		break;
	case ORANGE:
		System.out.println("color code of "+colorName+" is "+colorName.value);
		break;
	case RED:
		System.out.println("color code of "+colorName+" is "+colorName.value);
		break;
	}
}
catch(Exception e) {
	System.out.println(e.getMessage());
}
    break;
case 10:
	Singleton object1=Singleton.getObject();
	Singleton object2=Singleton.getObject();
	object1.display();
	object2.display();
	break;
}
}
}
