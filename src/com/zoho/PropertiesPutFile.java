package com.zoho;

import java.io.File;

import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import com.logiclayer.*;

public class PropertiesPutFile {
	void case2()throws Exception{
		
		Scanner sc=new Scanner(System.in);
	    FileLogic objForFile=new FileLogic();
	    System.out.println("enter path for create file");
		String path=sc.nextLine();
		System.out.println("enter filename");
		String fileName=sc.nextLine();
		File file2=objForFile.createFile(path,fileName);
		Properties p=objForFile.createProperty();
		System.out.println("howmany pairs do you want");
		int size=sc.nextInt();
		sc.nextLine();
		for(int i=0;i<size;i++) {
			System.out.println("enter key");
			String key=sc.nextLine();
			System.out.println("enter value");
			String value=sc.nextLine();
			objForFile.setPropertyInFile(p,file2,key,value);
			 }
		
			}

}
