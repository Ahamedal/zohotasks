package tasktwo;
import java.util.Scanner;
import stringbuilder.Task2;
public class Task2Main{
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
Task2 task2Obj=new Task2();
int k=0;
try{
System.out.println("enter question no");
k=sc.nextInt();
sc.nextLine();
}
catch(Exception e){
System.out.println("invalid number");
}
switch(k){
case 1:
  StringBuilder name1=task2Obj.createBuilder();
  try{
  int lengthForEmptyStr=task2Obj.getLength(name1);
  System.out.println(lengthForEmptyStr);
  System.out.println("enter a string");
  String stringName1=sc.next();
  
  name1=task2Obj.appendString(name1,stringName1);
  System.out.println(name1);
  int lengthAfterAppend=task2Obj.getLength(name1);
  System.out.println("length of append String="+lengthAfterAppend);
  }
  catch(Exception e1){
  System.out.println(e1.getMessage());
  }
  break;
  
  
case 2:
   System.out.println("Enter String");
   String stringName2=sc.nextLine();
try{
   StringBuilder name2=task2Obj.createBuilder(stringName2);
   System.out.println("length="+task2Obj.getLength(name2));

   System.out.println("how many string do you want");
   int number=sc.nextInt();
   sc.nextLine();
   try{
   String[] strArray=new String[number];
   System.out.println("Enter string");
   for(int i=0;i<number;i++){
   strArray[i]=sc.nextLine();
   }
   System.out.println("enter symbol and space");
   String symbol2=sc.nextLine();
   StringBuilder resultStr=task2Obj.separateAppendString(stringName2,strArray,symbol2);
   System.out.println("length of after append:"+task2Obj.getLength(resultStr));
   System.out.println(resultStr);
   }
   catch(Exception e2){
   System.out.println(e2.getMessage());
   }
   }
catch(Exception e22){
System.out.println("please enter a number");
}
  break;
  
case 3:
    System.out.println("enter first String");
    String stringName3=sc.nextLine();
try{
    System.out.println("how many string do you want");
   int size=sc.nextInt();
   sc.nextLine();
   String[] strArray2=new String[size];
   System.out.println("Enter  string after first string");
   for(int i=0;i<size;i++){
   strArray2[i]=sc.nextLine();
   }
 try{
   System.out.println("enter space or symbol");
   String symbol3=sc.nextLine();
 StringBuilder beforeInsert=task2Obj.separateAppendString(stringName3,strArray2,symbol3);
  System.out.println(task2Obj.getLength(beforeInsert));
    System.out.println("insert String");
    String insertStr=sc.nextLine();
    StringBuilder afterInsert=task2Obj.insertString(stringName3,beforeInsert,insertStr,symbol3);
    System.out.println("length of after insert:"+task2Obj.getLength(afterInsert));
    System.out.println(afterInsert);
    }
   catch(Exception e3){
    System.out.println(e3.getMessage());
   }
   }
catch(Exception e){
System.out.println("enter valid number");
}
    break;
case 4:
     System.out.println("enter first String");
    String stringName4=sc.nextLine();
 try{
    System.out.println("how many string do you want");
   int size4=sc.nextInt();
   sc.nextLine();
   String[] strArray4=new String[size4];
   System.out.println("Enter  string after first string");
   for(int i=0;i<size4;i++){
   strArray4[i]=sc.nextLine();
   }
     try{
    System.out.println("enter space or symbol");
   String symbol4=sc.nextLine();
   StringBuilder befDelete=task2Obj.separateAppendString(stringName4,strArray4,symbol4);
 System.out.println("length of before delete:"+task2Obj.getLength(befDelete));
  StringBuilder afterDelete=task2Obj.deleteString(stringName4,befDelete,symbol4);
  System.out.println("length of after delete:"+task2Obj.getLength(afterDelete));
  System.out.println(afterDelete);
  }
  catch(Exception e4){
  System.out.println(e4.getMessage());
  }
  }
catch(Exception e){
System.out.println("enter valid number");
}
   break; 
case 5:
     
     System.out.println("enter first String");
    String stringName5=sc.nextLine();
try{
    System.out.println("how many string do you want after 1 string");
   int size5=sc.nextInt();
   sc.nextLine();
   String[] strArray5=new String[size5];
   System.out.println("Enter  string after first string");
   for(int i=0;i<size5;i++){
   strArray5[i]=sc.nextLine();
   }
   try{
    System.out.println("enter space or symbol");
    String symbol5=sc.nextLine();
    char ch=symbol5.charAt(0);
    StringBuilder befHypen=task2Obj.separateAppendString(stringName5,strArray5,symbol5);
     System.out.println("length of before hypen:"+task2Obj.getLength(befHypen));
     System.out.println(befHypen);
     System.out.println("enter change symbol char");
     char changeSymbol=sc.next().charAt(0);
     StringBuilder aftHypen=task2Obj.hypenString(befHypen,ch,changeSymbol);
     System.out.println("length of after hypen:"+task2Obj.getLength(aftHypen));
     System.out.println(aftHypen);
     }
     catch(Exception e5){
     System.out.println(e5.getMessage());
     }
     }
catch(Exception e){
System.out.println("enter valid number");
}
     break;
case 6:
     System.out.println("enter first String");
    String stringName6=sc.nextLine();
try{
    System.out.println("how many string do you want after 1 string");
   int size6=sc.nextInt();
   sc.nextLine();
   String[] strArray6=new String[size6];
   System.out.println("Enter  string after first string");
   for(int i=0;i<size6;i++){
   strArray6[i]=sc.nextLine();
   }   
   
    try{
    System.out.println("enter space or symbol");
    String symbol6=sc.nextLine();
     StringBuilder befReverse=task2Obj.separateAppendString(stringName6,strArray6,symbol6);
     System.out.println("length of before reverse:"+task2Obj.getLength(befReverse));
     StringBuilder aftReverse=task2Obj.reverseString(befReverse);
     System.out.println(aftReverse);
     System.out.println("length of after reverse:"+task2Obj.getLength(aftReverse));
     }
     catch(Exception e6){
     System.out.println(e6.getMessage());
     }
     }
catch(Exception e){
System.out.println("enter valid number");
}    
break;
case 7:
   System.out.println("enter String");
   String stringName7=sc.nextLine();
   int startPosition=0;
   int endPosition=0;
try{
   System.out.println("enter starting position");
    startPosition=sc.nextInt();
   System.out.println("enter ending position");
    endPosition=sc.nextInt();
   sc.nextLine();
   try{
   StringBuilder firstStr7=task2Obj.createBuilder(stringName7);
    System.out.println("length of before delete:"+task2Obj.getLength(firstStr7));
   StringBuilder aftDltStr=task2Obj.dltString(firstStr7,startPosition,endPosition);
   System.out.println("length of after delete:"+task2Obj.getLength(aftDltStr));
   System.out.println(aftDltStr);
   }
   catch(Exception e7){
   System.out.println(e7.getMessage());
   }
   }
catch(Exception e77){
System.out.println("enter a valid number");
}
   break;
case 8:
   System.out.println("enter String");
   String stringName8=sc.next();
   int startPosition1=0;
   int endPosition1=0;
try{
   System.out.println("enter starting position");
   startPosition1=sc.nextInt();
   System.out.println("enter ending position");
   endPosition1=sc.nextInt();
   sc.nextLine();
   try{
   System.out.println("enter replace String");
   String repStr=sc.nextLine();
   StringBuilder firstStr1=task2Obj.createBuilder(stringName8);
   System.out.println("length of before reverse:"+task2Obj.getLength(firstStr1));
   StringBuilder aftRepStr=task2Obj.repString(firstStr1,startPosition1,endPosition1,repStr);
   System.out.println("length of after revese:"+task2Obj.getLength(aftRepStr));
   System.out.println(aftRepStr);
   }
   catch(Exception e8){
   System.out.println(e8.getMessage());
   }
   }
catch(Exception e88){
System.out.println("enter a valid number");
}
   break;
case 9:
   System.out.println("enter first String");
    String stringName9=sc.nextLine();
try{
    System.out.println("how many string do you want after 1 string");
   int size9=sc.nextInt();
   sc.nextLine();
   String[] strArray9=new String[size9];
   System.out.println("Enter  string after first string");
   for(int i=0;i<size9;i++){
   strArray9[i]=sc.nextLine();
   }   
    try{
    System.out.println("enter find Symbol");
    String symbol9=sc.nextLine();
     StringBuilder beforeIndex=task2Obj.separateAppendString(stringName9,strArray9,symbol9);
     System.out.println("length of before index:"+task2Obj.getLength(beforeIndex));
     System.out.println(beforeIndex);
     System.out.println("symbol first index:"+task2Obj.indexOfChar(beforeIndex,symbol9));
     }
     catch(Exception e9){
     System.out.println(e9.getMessage());
     }
     }
catch(Exception e88){
System.out.println("enter a valid number");
}
     break;
case 10:
     System.out.println("enter first String");
    String stringName10=sc.nextLine();
try{
    System.out.println("how many string do you want after 1 string");
   int size10=sc.nextInt();
   sc.nextLine();
   String[] strArray10=new String[size10];
   System.out.println("Enter  string after first string");
   for(int i=0;i<size10;i++){
   strArray10[i]=sc.nextLine();
   }   
    try{
    System.out.println("enter find Symbol");
    String symbol10=sc.nextLine();
     StringBuilder beforeLastIndex=task2Obj.separateAppendString(stringName10,strArray10,symbol10);
     System.out.println(task2Obj.getLength(beforeLastIndex));
     System.out.println(beforeLastIndex);
     System.out.println(task2Obj.lastIndexOfChar(beforeLastIndex,symbol10));
     }
     catch(Exception e10){
     System.out.println(e10.getMessage());
     }
     }
catch(Exception e88){
System.out.println("enter a valid number");
}
     break;
default:
    System.out.println("enter a correct number and below 10");
}

  }
  }
