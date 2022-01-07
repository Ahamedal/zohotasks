package com.zoho;

import java.io.*;
import java.util.*;
import com.logiclayer.*;

public class CreateFile {
		 void case1()throws Exception{
			
			Scanner sc=new Scanner(System.in);
			
			FileLogic objForFile=new FileLogic();
		    System.out.println("enter path for create file");
			String path=sc.nextLine();
			System.out.println("enter filename");
			String fileName=sc.nextLine();
		    File file1=objForFile.createFile(path,fileName);
			System.out.println("you want to append to existing file? if yes enter true otherwise enter false");
			boolean check;
			try {
		       check=sc.nextBoolean();
			}
			catch(Exception e) {
				throw new CustomException(e);
			}
			FileWriter myFile=objForFile.createWriter(file1,check);
			System.out.println("howmany string do you added to file");
			int size=sc.nextInt();
			sc.nextLine();
			String[] strArray=new String[size];
			System.out.println("enter String");
			for(int i=0;i<size;i++) {
				strArray[i]=sc.nextLine();
			}
			objForFile.writeFile(myFile,strArray);
		
		}
}
			

