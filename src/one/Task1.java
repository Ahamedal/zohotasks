
package one;

public class Task1{

public int getLength(String inputStr)throws Exception{
stringCheck(inputStr);
int strlen=inputStr.length();
return strlen;
}

public char[] toChar(String inputStr)throws Exception{
 stringCheck(inputStr);
 char[] chArray=inputStr.toCharArray();
  return chArray;
 
 }
 public char findLetter(String inputStr,int indexNumber)throws Exception{
 stringCheck(inputStr);
char charOfIndex=inputStr.charAt(indexNumber);
return charOfIndex;
}
public int letterOccurance(String inputStr,char findLetter)throws Exception{

int count=0;
int length=getLength(inputStr);
for(int i=0;i<length;i++){
   if(findLetter==inputStr.charAt(i)){
   count++;
   }
   }
 
   return count;
   }
 
public int findLetterPosition(String inputStr,char inputLetter)throws Exception{
    stringCheck(inputStr);
    int lastIndex=inputStr.lastIndexOf(inputLetter);
   return lastIndex;
   }
public String printSubString(String inputStr,int startPosition,int endPosition)throws Exception{
stringCheck(inputStr);
numberCheck(startPosition,inputStr);
numberCheck(endPosition,inputStr);
positionCheck(startPosition,endPosition);
String resultStr=inputStr.substring(startPosition,endPosition);

return resultStr;
}
public String findSubString(String inputStr,int startPosition,int endPosition)throws Exception{
positionCheck(startPosition,endPosition);
String resultStr=printSubString(inputStr,startPosition,endPosition);

return resultStr;
}
public String replace(String inputStr,int startPosition,int endPosition,String replacingStr)throws Exception{
stringCheck(inputStr);
stringCheck(replacingStr);
positionCheck(startPosition,endPosition);
numberCheck(startPosition,inputStr);
numberCheck(endPosition,inputStr);

String tempString=inputStr.substring(startPosition,endPosition);
String resultStr=inputStr.replace(tempString,replacingStr);

return resultStr;
}
public boolean checkStart(String inputStr,String testString)throws Exception{
stringCheck(inputStr);
stringCheck(testString);
boolean startCheckk=inputStr.startsWith(testString);
return startCheckk;
}
public boolean checkEnd(String inputStr,String testString)throws Exception{
stringCheck(inputStr);
stringCheck(testString);
boolean endChek=inputStr.endsWith(testString);
return endChek;
}
public String upperCase(String inputStr)throws Exception{
stringCheck(inputStr);
String result11=inputStr.toUpperCase();
 return result11;
}
public String lowerCase(String inputStr)throws Exception{
stringCheck(inputStr);
String result12=inputStr.toLowerCase();
return result12;
}
public String reverse(String inputStr)throws Exception{

String resultStr="";
char[] c=toChar(inputStr);
int strLen=getLength(inputStr);
for(int i=strLen-1;i>=0;i--){
 resultStr=resultStr+c[i];
 }

return resultStr;
 }
public String multiStr(String inputStr)throws Exception{
stringCheck(inputStr);
return inputStr;


}
public String multiStr2(String inputStr)throws Exception{
stringCheck(inputStr);
 String resultStr=inputStr.replaceAll(" ","");
return resultStr;
}
public String[] split(String inputStr){
String[] splitStr=inputStr.split(" ");

return splitStr;

}
public String concat(int num,String[] inputStrArray)throws Exception{
checkingStringArray(inputStrArray);

String hypenstring=String.join("-",inputStrArray);

return hypenstring ;
}
private void checkingStringArray(String[] inputStrArray)throws Exception{
for(String wordStr:inputStrArray){
  stringCheck(wordStr);
  }
  }
public boolean equals(String inputStr1,String inputStr2)throws Exception{
stringCheck(inputStr1);
stringCheck(inputStr2);
 boolean result=inputStr1.equals(inputStr2);
 return result;
}
public boolean ignoreCase(String inputStr1,String inputStr2)throws Exception{
stringCheck(inputStr1);
stringCheck(inputStr2);
boolean result=inputStr1.equalsIgnoreCase(inputStr2);
return result;
}
public String trim(String inputStr)throws Exception{
stringCheck(inputStr);
String resultStr=inputStr.trim();
return resultStr;
}
public void stringCheck(String testString)throws Exception{
if(testString==null||testString.isEmpty()){
throw new Exception("String can not be null or empty");
}
}
public void numberCheck(int testNumber,String testString)throws Exception{
if(testNumber<0||testString.length()<=testNumber){
throw new Exception("number cannot be negative or given number exceeds the length of given String");
}
}
public void positionCheck(int startPosition,int endPosition)throws Exception{
if(startPosition>endPosition){
System.out.println("your input is invalid");
}
}
}
















































 
 
   


