package com.zoho;

import java.io.IOException;


import java.util.Properties;
import java.util.Scanner;
import com.logiclayer.*;

public class FileIntoProperties {
	void case3()throws Exception{
		
		Scanner sc=new Scanner(System.in);
	    FileLogic objForFile=new FileLogic();
	    System.out.println("enter path for create file");
		String path=sc.nextLine();
		System.out.println("enter filename");
		String fileName=sc.nextLine();
		Properties propertie=objForFile.createProperty();
		Properties printPropertie=objForFile.printProperty(propertie,path,fileName);
		System.out.println(printPropertie);
		
		
	}
}
