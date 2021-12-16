package zoho;
import one.Task1;
import java.util.Scanner;


public class TaskMain{
public static void main(String[] args){
// String s1=args[0];
//Task1.args(s1);
System.out.println("2.character array,3.print last before letter,4.occurance of a letter in a string,5.greatest position of letter in string,"
+ "6.print last five letters,7.print first three letters in a string,8.replace XYZ,9.starts with 'ent',10.ends with 'le',"
+ "11.Uppercase,12.Lowercase,13.reverse string,14.accept multiple string,"
+ "15.concat multiple string,16.split string,17.hypenated string,18.equals two string,19.equals ignorsecase,20.space eliminated using trim.");
Task1 taskObject=new Task1();
Scanner sc=new Scanner(System.in);
int k=0;
try{
System.out.println("enter no");
k=sc.nextInt();
sc.nextLine();
}
catch(ArithmeticException e){
System.out.println("invalid number");
}
catch(Exception e){
System.out.println("invalid number");
}
switch(k){
case 1:
try {
String cmdStr=args[0];
System.out.println(taskObject.getLength(cmdStr));
}
catch(Exception e) {
System.out.println("enter valid input");
}
break;
case 2:
System.out.println("2.character array");
   System.out.println("enter string");
   String inputStr=sc.nextLine();
   try{
   System.out.println(taskObject.toChar(inputStr));
   }
   catch(Exception e){
   System.out.println(e.getMessage());
   }
   
   break;
case 3:
System.out.println("print the letter in position");
System.out.println("enter a string");
  String inputStr1=sc.nextLine();
  int number3=0;
  try {
  System.out.println("enter the position of letter do you want");
   number3=sc.nextInt();
  sc.nextLine();
     try{
        System.out.println(taskObject.findLetter(inputStr1,number3));
        }
     catch(Exception e1){
     System.out.println(e1.getMessage());
     }
     }
 catch(Exception e2){
     System.out.println("please a enter a number");
     }
     
 
   break;
case 4:
System.out.println("occurance of a letter in a string");
  System.out.println("enter a string");
  String inputStr4=sc.nextLine();
  System.out.println("enter a character");
char findLetter=sc.next().charAt(0);
 try{
   System.out.println(taskObject.letterOccurance(inputStr4,findLetter));
   }
 catch(Exception error){
 System.out.println(error.getMessage());
 }
   break;
case 5:
System.out.println("greatest position of letter in string");
   System.out.println("enter a string");
  String inputStr5=sc.nextLine();
  System.out.println("enter a character");
    char inputLetter=sc.next().charAt(0);
    try{
   System.out.println(taskObject.findLetterPosition(inputStr5,inputLetter));
  }
  catch(Exception error){
 System.out.println(error.getMessage());
 }
   break;
case 6:
      System.out.println("finding substring");
System.out.println("enter a string");
  String inputStr6=sc.nextLine();
  int startPosition=0;
  int endPosition=0;
  try {
  System.out.println("enter startingposition");
  startPosition=sc.nextInt();
  System.out.println("enter endingposition");
  endPosition=sc.nextInt();
  sc.nextLine();
      try{
      System.out.println(taskObject.findSubString(inputStr6,startPosition,endPosition));
          }
       catch(Exception error) {
       System.out.println(error.getMessage());
       }
       }
  catch(Exception e){
  System.out.println("please enter a number");
  }
break;
case 7:
System.out.println("printing substring");
System.out.println("enter a string");
  String stringName7=sc.nextLine();
  int startPosition1=0;
  int endPosition1=0;
  try {
  System.out.println("enter startingPosition");
  startPosition1=sc.nextInt();
  System.out.println("enter endingPosition");
  endPosition1=sc.nextInt();
  sc.nextLine();
      try{
      System.out.println(taskObject.printSubString(stringName7,startPosition1,endPosition1));
          }
       catch(Exception error) {
       System.out.println(error.getMessage());
       }
       }
  catch(Exception e){
  System.out.println("please enter a number");
  }
  
   break;
case 8:
System.out.println("replace");
System.out.println("enter a string");
  String stringName8=sc.nextLine();
  int startPosition2=0;
  int endPosition2=0;
  try {
  System.out.println("enter startingPosition");
  startPosition2=sc.nextInt();
  System.out.println("enter endingPosition");
  endPosition2=sc.nextInt();
  sc.nextLine();
  System.out.println("enter replacestring");
  String replaceStr=sc.nextLine();
   try{
 
   System.out.println(taskObject.replace(stringName8,startPosition2,endPosition2,replaceStr));
   }
   catch(Exception error){
   System.out.println(error.getMessage());
   }
   }
catch(Exception e){
System.out.println("please enter a number");
}
  
   break;
case 9:
System.out.println("starts with");
   System.out.println("enter a string");
  String stringName9=sc.nextLine();
  System.out.println("starting letters");
  String startString=sc.nextLine();
  try{
  
  System.out.println(taskObject.checkStart(stringName9,startString));
  }
  catch(Exception e){
  System.out.println(e.getMessage());
  }
  
  break;
case 10:
       System.out.println("ends with");
System.out.println("enter a string");
  String stringName10=sc.nextLine();
 
  System.out.println("starting letters");
  String endString=sc.nextLine();
  try{
  System.out.println(taskObject.checkEnd(stringName10,endString));
  }
  catch(Exception e){
  System.out.println(e.getMessage());
  }
  
  break;
case 11:
System.out.println("Uppercase");
   System.out.println("enter string");
   String stringName11=sc.nextLine();
    try{
  System.out.println(taskObject.upperCase(stringName11));
  }
  catch(Exception e){
  System.out.println(e.getMessage());
  }
  break;
case 12:
System.out.println("lowercase");
System.out.println("enter a string");
  String stringName12=sc.nextLine();
   try{
  System.out.println(taskObject.lowerCase(stringName12));
  }
  catch(Exception e){
  System.out.println(e.getMessage());
  }
  
  break;
case 13:
System.out.println("reverse string");
System.out.println("enter a string");
  String stringName13=sc.nextLine();
 try{
 System.out.println(taskObject.reverse(stringName13));
 }
 catch(Exception e){
  System.out.println(e.getMessage());
  }
  
  break;
case 14:
System.out.println("accept multiple string");
   System.out.println("enter a string");
   String stringName14=sc.nextLine();
   try{
   System.out.println(taskObject.multiStr(stringName14));
   }
   catch(Exception e){
  System.out.println(e.getMessage());
  }
   break;
case 15:
System.out.println("concat multiple string");
 System.out.println("enter a string");
   String stringName15=sc.nextLine();
   try{
 System.out.println(taskObject.multiStr2(stringName15));
 }
 catch(Exception e){
  System.out.println(e.getMessage());
  }
   
 break;
case 16:
 System.out.println("split string");
System.out.println("enter a string");
  String stringName16=sc.nextLine();
 try{
     String[] splitSentence=taskObject.split(stringName16);
     for(String n:splitSentence){
     System.out.println(n);
     }
     }
 catch(Exception e){
  System.out.println(e.getMessage());
  }

break;
case 17:
int num=0;
System.out.println("hypenated string");
try{
System.out.println("how many string do you want");
num=sc.nextInt();
sc.nextLine();
     try{
     System.out.println("enter a string");

     String[] array=new String[num];

    for(int i=0;i<num;i++){
    array[i]=sc.nextLine();
 
    }

    System.out.println(taskObject.concat(num,array));
    }
    catch(Exception error){
    System.out.println(error.getMessage());
    }
    }
catch(Exception e){
System.out.println("enter a correct number");
}

 break;
case 18:
System.out.println("equals two string");
System.out.println("enter a 1st string");
String stringName18="";
   stringName18=sc.nextLine();
  System.out.println("enter a 2nd string");
  String stringName182=sc.nextLine();
 try{
  System.out.println(taskObject.equals(stringName18,stringName182));
  }
  catch(Exception e){
  System.out.println(e.getMessage());
  }
  
  break;
 
case 19:
System.out.println("equals ignore case");
System.out.println("enter a 1st string");
  String stringName19=sc.nextLine();
  System.out.println("enter a 2nd string");
  String stringName192=sc.nextLine();
  try{
  System.out.println(taskObject.ignoreCase(stringName19,stringName192));
  }
  catch(Exception error){
    System.out.println(error.getMessage());
    }
  break;
 
case 20:
System.out.println("eliminate space using trim");
  System.out.println("enter a string");
  String stringName20=sc.nextLine();
   try{
  System.out.println(taskObject.trim(stringName20));
  }
  catch(Exception e){
  System.out.println(e.getMessage());
  }
 
 break;

default:
System.out.println("enter correct number and below 20");

 }


 }
 }


