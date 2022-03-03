package com.logiclayer;

import level3.*;

public class Utility {
	public static void stringCheck(String testString)throws CustomException{
		if(testString==null||testString.isEmpty()){
		throw new CustomException("String can not be null or empty");
		}
		}
	public static void checkingStringArray(String[] inputStrArray)throws CustomException{
		for(String wordStr:inputStrArray){
		  stringCheck(wordStr);
		  }
		  }
	public static void nullCheck(Object fileObj)throws CustomException{
		if(fileObj==null){
		throw new CustomException(fileObj+"cannot be null");
		}
		}
   public static void nullCheck(Object object,String str)throws CustomException{
	   if(object==null){
			throw new CustomException(str+"cannot be null");
   }
}
}