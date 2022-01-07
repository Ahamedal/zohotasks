package com.logiclayer;

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
}
