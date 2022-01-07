package com.logiclayer;
import java.io.*;

import java.util.*;
public class FileLogic {
	
	     boolean check;
		//#1;
		public File createFile(String path,String fileName)throws CustomException{
		
			Utility.stringCheck(path);
			Utility.stringCheck(fileName);
			File newFile;
			try {
			newFile=new File(path+File.separator+fileName);
			if(newFile.createNewFile()) {
				System.out.println("file created");
				//return newFile;
			}
			
			else {
				
				System.out.println("file already exists");
				
				
			}
			}
			catch(Exception e)
			{
				throw new CustomException(e);
			}
			return newFile;
			
		}
		//#1
		public FileWriter createWriter(File newFile,boolean check)throws CustomException{
			   Utility.nullCheck(newFile);
			   try
			   {
               FileWriter myFile=new FileWriter(newFile,check);
				return myFile;
			   }
			   catch(IOException e) {
				   throw new CustomException(e);
			   }
			}
		//#1
		public void writeFile(FileWriter myFile,String[] inputArray)throws CustomException{
			Utility.nullCheck(myFile);
			Utility.checkingStringArray(inputArray);
			try {
			for(String str:inputArray) {
				myFile.append(str+"\n");
				
			}
			}
			catch(IOException e) {
				throw new CustomException(e);
			}
			
			finally {
				
			try {
			myFile.close();
			}
			catch(IOException e) {
			}
			}
		}
		//#2
		public Properties createProperty() {
			Properties propertie=new Properties();
			return propertie;
		}
		//#2
public void setPropertyInFile(Properties propertie,File newFile,String key,String value)throws CustomException{
			Utility.nullCheck(propertie);
			Utility.nullCheck(newFile);
			Utility.stringCheck(key);
			Utility.stringCheck(value);
			FileWriter myFile=null;
			try {
			myFile=new FileWriter(newFile);
			propertie.setProperty(key,value);
			propertie.store(myFile,null );
		 }
		 catch(IOException e) {
			 throw new CustomException(e);
		 }
		 
		 finally{
		
			 try {
				 if(myFile!=null) {
			     myFile.close();
				 }
			 }
			 catch(Exception e) {
			 }
			 }
		     
		}
		//#3
public Properties printProperty(Properties propertie,String path,String fileName)throws CustomException{
	        Utility.nullCheck(propertie);
	        Utility.stringCheck(path);
	        Utility.stringCheck(fileName);
	        try {
	        FileReader readFile=new FileReader(path+File.separator+fileName);
			propertie.load(readFile);
	        }
	        catch(IOException e) {
	        	throw new CustomException(e);
	        }
	        
			return propertie;
		}
        //#4
public void makeDirectory(String path,String dirName)throws CustomException {
			Utility.stringCheck(path);
			Utility.stringCheck(dirName);
			File myFile=new File(path+File.separator+dirName);
			boolean present=myFile.isDirectory();
			if(present) {
			myFile.mkdir();
			System.out.println("directory created");
			}
			else {
				throw new CustomException("directory already excited");
			}
			}

			
			
		}

	

