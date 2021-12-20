package stringbuilder;
import one.Task1;
public class Task2{
Task1 objForTask1=new Task1();
public StringBuilder createBuilder(){
 StringBuilder inputBuilder=new StringBuilder();
 return inputBuilder;
 }
public StringBuilder createBuilder(String inputStr)throws Exception{
 objForTask1.stringCheck(inputStr);
 StringBuilder inputBuilder=new StringBuilder(inputStr);
 return inputBuilder;
 }
 public StringBuilder appendString(StringBuilder inputStringBuilder,String inputString2)throws Exception{
 builderValidator(inputStringBuilder);
objForTask1.stringCheck(inputString2);
inputStringBuilder.append(inputString2);
 return inputStringBuilder;
}
 //#1 qus
public int getLength(StringBuilder inputString)throws Exception{
builderValidator(inputString);
int length=inputString.length();
return length;
}
//#2 ques;
public StringBuilder separateAppendString(String inputString,String[] strArray,String symbol)throws Exception{
objForTask1.checkingStringArray(strArray);
StringBuilder inputStringBuilder=createBuilder(inputString);
for(String str:strArray){
appendString(inputStringBuilder,symbol);
appendString(inputStringBuilder,str);
}

return inputStringBuilder;
}


//#3 ques;
public StringBuilder insertString(String inputString1,StringBuilder appendStr,String insertStr,String symbol)throws Exception{
builderValidator(appendStr);
appendStr.insert(objForTask1.getLength(inputString1)+1,insertStr);
appendStr.insert(objForTask1.getLength(inputString1)+objForTask1.getLength(insertStr)+1,symbol);
return appendStr;
}
//#4 qus;
public StringBuilder deleteString(String inputString1,StringBuilder appendStrBuilder,String space)throws Exception{
builderValidator(appendStrBuilder);
objForTask1.stringCheck(space);
appendStrBuilder.delete(0,objForTask1.getLength(inputString1)+1);
return appendStrBuilder;
}
//#5 qus;
public StringBuilder hypenString(StringBuilder appendStrBuilder,char appendChar,char symbolChangeChar)throws Exception{
for(int i=0;i<getLength(appendStrBuilder);i++){
if(appendStrBuilder.charAt(i)==appendChar){
appendStrBuilder.setCharAt(i,symbolChangeChar);
}
}
return appendStrBuilder;
}
//#6 ques;
public StringBuilder reverseString(StringBuilder appendStrBuilder)throws Exception{
builderValidator(appendStrBuilder);
appendStrBuilder.reverse();
return appendStrBuilder;
}
//#7 ques;
public StringBuilder dltString(StringBuilder inputStrBuilder,int startPosition,int endPosition)throws Exception{
builderValidator(inputStrBuilder);
numberValidator(startPosition,inputStrBuilder);
numberValidator(endPosition,inputStrBuilder);
objForTask1.positionCheck(startPosition,endPosition);
inputStrBuilder.delete(startPosition,endPosition);
return inputStrBuilder;
}
//#8 ques;
public StringBuilder repString(StringBuilder inputStrBuilder,int startPosition,int endPosition,String repStr)throws Exception{
builderValidator(inputStrBuilder);
objForTask1.stringCheck(repStr);
numberValidator(startPosition,inputStrBuilder);
numberValidator(endPosition,inputStrBuilder);
objForTask1.positionCheck(startPosition,endPosition);
inputStrBuilder.replace(startPosition,endPosition,repStr);
return inputStrBuilder;
}
//#9 ques;
public int indexOfChar(StringBuilder inputStrBuilder,String findChar)throws Exception{
builderValidator(inputStrBuilder);
objForTask1.stringCheck(findChar);
int index=inputStrBuilder.indexOf(findChar);
return index;
}
//#10 ques;
public int lastIndexOfChar(StringBuilder inputStrBuilder,String findChar)throws Exception{
builderValidator(inputStrBuilder);
objForTask1.stringCheck(findChar);
int index=inputStrBuilder.lastIndexOf(findChar);
return index;
}
public void builderValidator(StringBuilder inputStrBuilder)throws Exception{
if(inputStrBuilder==null){
throw new Exception("String cannot be null and cannot be empty");
}
}

public void numberValidator(int testNumber,StringBuilder testBuilder)throws Exception{
builderValidator(testBuilder);
if(testNumber<0||testBuilder.length()<=testNumber){
throw new Exception("Number cannot be empty or given number exceeds the length of the String");
}
}
}
