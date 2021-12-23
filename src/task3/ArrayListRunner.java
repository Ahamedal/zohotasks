package task3;
import java.util.*;
import arraylist.ArrayListLogic;
public class ArrayListRunner{
public static void main(String[] args){

Scanner sc=new Scanner(System.in);
ArrayListLogic objForArrayList=new ArrayListLogic();
int quesNo=0;
try{
System.out.println("enter question no");
quesNo=sc.nextInt();
sc.nextLine();
}
catch(Exception e){
System.out.println("invalid number");
}
switch(quesNo){
case 1:
try{
      List emptyList=objForArrayList.createList();
      System.out.println("emptyList"+objForArrayList.sizeOfList(emptyList));
      }
catch(Exception e){
  System.out.println(e.getMessage());
  }
  break;
case 2:
try{
      System.out.println("how many string do you want");
   int number=sc.nextInt();
   sc.nextLine();
   try{
   String[] strArray2=new String[number];
   System.out.println("Enter string");
   for(int i=0;i<number;i++){
   strArray2[i]=sc.nextLine();
   }
   List emptyList2=objForArrayList.createList();
   List myList1=objForArrayList.addList(emptyList2,strArray2);
   System.out.println("after add List:"+myList1);
   System.out.println("size of after add:"+objForArrayList.sizeOfList(myList1));
   }
   catch(Exception e){
  System.out.println(e.getMessage());
  }
  }
catch(Exception e){
System.out.println("please enter a number");
}
break;
case 3:
try{
   System.out.println("how many integer do you want");
   int size=sc.nextInt();
   sc.nextLine();
   Integer[] intArray=new Integer[size];
   System.out.println("Enter Integer");
   for(int i=0;i<size;i++){
   intArray[i]=sc.nextInt();
   }
   try{
   List emptyList3=objForArrayList.createList();
   List myList3=objForArrayList.addList(emptyList3,intArray);
   System.out.println("after add List:"+myList3);
   System.out.println("size of addList:"+objForArrayList.sizeOfList(myList3));
   }
   catch(Exception e){
  System.out.println(e.getMessage());
  }
  }
catch(Exception e){
System.out.println("please enter a number");
} 
break;
case 4:
try{
   List myList4=objForArrayList.createList();
   System.out.println("how many objects do you want");
   int size4=sc.nextInt();
   Object objArray[]=new Object[size4];
   for(int i=0;i<size4;i++){
  ArrayListLogic customObject=new ArrayListLogic();
   objArray[i]=customObject;
     }
   myList4=objForArrayList.addList(myList4,objArray);
   System.out.println("addList:"+myList4);
   System.out.println("size:"+objForArrayList.sizeOfList(myList4));
   }
   catch(Exception e){
  System.out.println(e.getMessage());
  }
break;
case 5:
try{
     System.out.println("how many String do you want");
     int size5=sc.nextInt();
     sc.nextLine();
    String[] strArray5=new String[size5];
   System.out.println("Enter string");
   for(int i=0;i<size5;i++){
   strArray5[i]=sc.nextLine();
  }
  System.out.println("how many integer do you want");
   int size52=sc.nextInt();
   sc.nextLine();
   Integer[] intArray5=new Integer[size52];
   System.out.println("Enter Integer");
   for(int i=0;i<size52;i++){
   intArray5[i]=sc.nextInt();
   }
   System.out.println("how many objects do you want");
   int size53=sc.nextInt();
   Object objArray5[]=new Object[size53];
   for(int i=0;i<size53;i++){
  ArrayListLogic customObject2=new ArrayListLogic();
   objArray5[i]=customObject2;
     }
   try{
   List myList51=objForArrayList.createList();
   
   objForArrayList.addList(myList51,strArray5);
   objForArrayList.addList(myList51,intArray5);
   List finalAddList=objForArrayList.addList(myList51,objArray5);
   System.out.println("last add List:"+finalAddList);
   System.out.println("size:"+objForArrayList.sizeOfList(finalAddList));
   }
   catch(Exception e){
   System.out.println(e.getMessage());
   }
   }
catch(Exception e){
System.out.println("enter a number");
}
break;

case 6:
try{
     System.out.println("how many String do you want");
     int size6=sc.nextInt();
     sc.nextLine();
    String[] strArray6=new String[size6];
   System.out.println("Enter string");
   for(int i=0;i<size6;i++){
   strArray6[i]=sc.nextLine();
  }
  System.out.println("what string do you find");
  String findStr=sc.nextLine();
  try{
  List myList6=objForArrayList.createList();
  List addList6=objForArrayList.addList(myList6,strArray6);
  System.out.println(objForArrayList.findIndex(addList6,findStr));
  System.out.println(addList6);
  System.out.println(objForArrayList.sizeOfList(addList6));
  }
  catch(Exception e){
  System.out.println(e.getMessage());
  }
  }
catch(Exception e){
System.out.println("enter a number");
}
break;
case 7:
try{
     System.out.println("how many String do you want");
     int size7=sc.nextInt();
     sc.nextLine();
    String[] strArray7=new String[size7];
   System.out.println("Enter string");
   for(int i=0;i<size7;i++){
   strArray7[i]=sc.nextLine();
  }
  try{
  List myList7=objForArrayList.createList();
  List addList7=objForArrayList.addList(myList7,strArray7);
  Iterator iterator=addList7.iterator();
  for(int i=0;iterator.hasNext();i++){
  System.out.println(iterator.next());
  }
  }
  catch(Exception e){
  System.out.println(e.getMessage());
  }
  }
catch(Exception e){
System.out.println("enter a number");
}
break;
case 8:
try{
     System.out.println("how many String do you want");
     int size8=sc.nextInt();
     sc.nextLine();
    String[] strArray8=new String[size8];
   System.out.println("Enter string");
   for(int i=0;i<size8;i++){
   strArray8[i]=sc.nextLine();
  }
  System.out.println("enter index do you want");
  int index=sc.nextInt();
  sc.nextLine(); 
  try{ 
  List myList8=objForArrayList.createList();
  List addList8=objForArrayList.addList(myList8,strArray8);
  System.out.println("element in index:"+objForArrayList.findElementAtIndex(addList8,index-1));
  System.out.println("addList:"+addList8);
  System.out.println("size:"+objForArrayList.sizeOfList(addList8));
  }
  catch(Exception e){
  System.out.println(e.getMessage());
  }
  }
catch(Exception e){
System.out.println("enter a number");
}
break;
case 9:
try{
     System.out.println("how many String do you want");
     int size9=sc.nextInt();
     sc.nextLine();
    String[] strArray9=new String[size9];
   System.out.println("Enter string");
   for(int i=0;i<size9;i++){
   strArray9[i]=sc.nextLine();
  }
  System.out.println("enter duplicate string");
  String duplicateStr=sc.nextLine();
  try{ 
  List myList9=objForArrayList.createList();
  List addList9=objForArrayList.addList(myList9,strArray9);
  System.out.println("dublicate String fistIndex:"+objForArrayList.findIndex(addList9,duplicateStr));
  System.out.println("dublicate String last index:"+objForArrayList.findLastDuplicates(addList9,duplicateStr));
  }
  catch(Exception e){
  System.out.println(e.getMessage());
  }
  }
catch(Exception e){
System.out.println("enter a number");
}
break;
case 10:
try{
     System.out.println("how many String do you want");
     int size10=sc.nextInt();
     sc.nextLine();
    String[] strArray10=new String[size10];
   System.out.println("Enter string");
   for(int i=0;i<size10;i++){
   strArray10[i]=sc.nextLine();
  }
  System.out.println("what position to you add");
  int position=sc.nextInt();
  sc.nextLine();
  System.out.println("what string to insert");
  String insertStr=sc.nextLine();
  try{ 
  List myList10=objForArrayList.createList();
  List addList10=objForArrayList.addList(myList10,strArray10);
  List listAfterInsert=objForArrayList.insertList(addList10,position-1,insertStr);
  System.out.println("list after insert:"+listAfterInsert);
  System.out.println("size of after insert:"+objForArrayList.sizeOfList(listAfterInsert));
  }
  catch(Exception e){
  System.out.println(e.getMessage());
  }
  }
 catch(Exception e){
 System.out.println("enter a number");
 }
break;
case 11:
 try{
     System.out.println("how many String do you want");
     int size11=sc.nextInt();
     sc.nextLine();
    String[] strArray11=new String[size11];
   System.out.println("Enter string");
   for(int i=0;i<size11;i++){
   strArray11[i]=sc.nextLine();
  }
  System.out.println("enter start position");
  int startPosition=sc.nextInt();
  sc.nextLine();
  System.out.println("enter end position");
  int endPosition=sc.nextInt();
  sc.nextLine();
  try{ 
  List myList11=objForArrayList.createList();
  objForArrayList.addList(myList11,strArray11);
  List list2=objForArrayList.takeSubList(myList11,startPosition-1,endPosition);
  System.out.println("sub list:"+list2);
  }
  catch(Exception e){
  System.out.println(e.getMessage());
  }
  }
 catch(Exception e){
 System.out.println("enter a number");
 }
break;
case 12:
try{
     System.out.println("howmany String do you want");
     int size12=sc.nextInt();
     sc.nextLine();
     String[] strArray12=new String[size12];
     System.out.println("Enter string");
     for(int i=0;i<size12;i++){
     strArray12[i]=sc.nextLine();
     }
     System.out.println("howmany more String do you want");
     int size12_1=sc.nextInt();
     sc.nextLine();
     String[] strArray12_1=new String[size12_1];
     System.out.println("Enter string");
     for(int i=0;i<size12_1;i++){
     strArray12_1[i]=sc.nextLine();
     }
     try{
     List myList12_1=objForArrayList.createList();
     List myList12_2=objForArrayList.createList();
     objForArrayList.addList(myList12_1,strArray12);
     objForArrayList.addList(myList12_2,strArray12_1);
     objForArrayList.addAllList(myList12_1,myList12_2);
     System.out.println("third list:"+myList12_1);
     System.out.println("size of third list:"+objForArrayList.sizeOfList(myList12_1));
     }
     catch(Exception e){
     System.out.println(e.getMessage());
     }
     }
catch(Exception e){
System.out.println("please enter a number");
}
break;
case 13:
try{
     System.out.println("how many String do you want");
     int size13=sc.nextInt();
     sc.nextLine();
     String[] strArray13=new String[size13];
     System.out.println("Enter string");
     for(int i=0;i<size13;i++){
     strArray13[i]=sc.nextLine();
     }
     System.out.println("how many more String do you want");
     int size13_1=sc.nextInt();
     sc.nextLine();
     String[] strArray13_1=new String[size13_1];
     System.out.println("Enter string");
     for(int i=0;i<size13_1;i++){
     strArray13_1[i]=sc.nextLine();
     }
     try{
     List myList13_1=objForArrayList.createList();
     List myList13_2=objForArrayList.createList();
     objForArrayList.addList(myList13_1,strArray13);
     objForArrayList.addList(myList13_2,strArray13_1);
     objForArrayList.addAllList(myList13_2,myList13_1);
    
     System.out.println("third list:"+myList13_2);
     System.out.println("size of third list:"+objForArrayList.sizeOfList(myList13_2));
     }
     catch(Exception e){
     System.out.println(e.getMessage());
     }
     }
catch(Exception e){
System.out.println("please enter a number");
}
break;
case 14:
try{
     System.out.println("how many decimal values do you want");
     int size14=sc.nextInt();
     sc.nextLine();
     Float[] floatArray14=new Float[size14];
     System.out.println("Enter decimal values");
     for(int i=0;i<size14;i++){
     floatArray14[i]=sc.nextFloat();
     }
     System.out.println("what float do you want to remove");
     float removeFloat=sc.nextFloat();
     try{
     List myList14=objForArrayList.createList();
     objForArrayList.addList(myList14,floatArray14);
     objForArrayList.removeList(myList14,removeFloat);
     System.out.println("list after remove:"+myList14);
     System.out.println("size:"+objForArrayList.sizeOfList(myList14));
     }
     catch(Exception e){
     System.out.println(e.getMessage());
     }
     }
catch(Exception e){
System.out.println("please enter a number");
}
break;
case 15:
try{
     System.out.println("how many decimal values do you want");
     int size15=sc.nextInt();
     sc.nextLine();
     Float[] floatArray15=new Float[size15];
     System.out.println("Enter decimal value");
     for(int i=0;i<size15;i++){
     floatArray15[i]=sc.nextFloat();
     }
     System.out.println("enter index value do you want remove");
     int removeIndex=sc.nextInt();
     try{
     List myList15=objForArrayList.createList();
     objForArrayList.addList(myList15,floatArray15);
     objForArrayList.removeListUsingIndex(myList15,removeIndex-1);
     System.out.println("remove list:"+myList15);
     System.out.println("size:"+objForArrayList.sizeOfList(myList15));
     }
     catch(Exception e){
     System.out.println(e.getMessage());
     }
     }
catch(Exception e){
System.out.println("please enter a number");
}
break;
case 17:
try{
     System.out.println("how many String do you want");
     int size17=sc.nextInt();
     sc.nextLine();
     String[] strArray17=new String[size17];
     System.out.println("Enter string");
     for(int i=0;i<size17;i++){
     strArray17[i]=sc.nextLine();
     }
     System.out.println("how many String do you want");
     int size17_1=sc.nextInt();
     sc.nextLine();
     String[] strArray17_1=new String[size17_1];
     System.out.println("Enter string");
     for(int i=0;i<size17_1;i++){
     strArray17_1[i]=sc.nextLine();
     }
     try{
      List myList17_1=objForArrayList.createList();
      objForArrayList.addList(myList17_1,strArray17);
      List myList17_2=objForArrayList.createList();
      objForArrayList.addList(myList17_2,strArray17_1);
      objForArrayList.removeAllList(myList17_1,myList17_2);
      System.out.println("remove firstlist:"+myList17_1);
      System.out.println("size:"+objForArrayList.sizeOfList(myList17_1));
      }
      catch(Exception e){
      System.out.println(e.getMessage());
      }
      }
catch(Exception e){
System.out.println("please enter number");
}
break;
case 18:
try{
     System.out.println("how many String do you want");
     int size18=sc.nextInt();
     sc.nextLine();
     String[] strArray18=new String[size18];
     System.out.println("Enter string");
     for(int i=0;i<size18;i++){
     strArray18[i]=sc.nextLine();
     }
     System.out.println("how many String do you want");
     int size18_1=sc.nextInt();
     sc.nextLine();
     String[] strArray18_1=new String[size18_1];
     System.out.println("Enter string");
     for(int i=0;i<size18_1;i++){
     strArray18_1[i]=sc.nextLine();
     }
     try{
      List myList18_1=objForArrayList.createList();
      objForArrayList.addList(myList18_1,strArray18);
      List myList18_2=objForArrayList.createList();
      objForArrayList.addList(myList18_2,strArray18_1);
      objForArrayList.retainAllList(myList18_1,myList18_2);
      System.out.println("retain List:"+myList18_1);
      System.out.println("size:"+objForArrayList.sizeOfList(myList18_1));
      }
      catch(Exception e){
      System.out.println(e.getMessage());
      }
      }
catch(Exception e){
System.out.println("please enter number");
}
break;
case 19:
try{
     System.out.println("how many decimal values do you want");
     int size_1=sc.nextInt();
     sc.nextLine();
     Long[] longArray=new Long[size_1];
     System.out.println("Enter decimal value");
     for(int i=0;i<size_1;i++){
     longArray[i]=sc.nextLong();
     }
     try{
     List myList_1=objForArrayList.createList();
     objForArrayList.addList(myList_1,longArray);
     objForArrayList.removeLong(myList_1);
     System.out.println("clear list:"+myList_1);
     System.out.println("size:"+objForArrayList.sizeOfList(myList_1));
     }
     catch(Exception e){
     System.out.println(e.getMessage());
     }
     }
catch(Exception e){
System.out.println("please enter a number");
}
break;
case 20:
 try{
     System.out.println("how many String do you want");
     int size20=sc.nextInt();
     sc.nextLine();
     String[] strArray20=new String[size20];
     System.out.println("Enter string");
     for(int i=0;i<size20;i++){
     strArray20[i]=sc.nextLine();
     }
     System.out.println("enter string what you check");
     String checkStr=sc.nextLine();
     try{
     List myList20=objForArrayList.createList();
     objForArrayList.addList(myList20,strArray20);
     System.out.println("String is contains:"+objForArrayList.containsInList(myList20,checkStr));
     System.out.println("add list:"+myList20);
     System.out.println("size:"+objForArrayList.sizeOfList(myList20));
     }
     catch(Exception e){
     System.out.println(e.getMessage());
     }
     }
catch(Exception e){
System.out.println("enter a number");
}
break;
default:
System.out.println("please enter a correct number or enter below 20");
break; 
}
}
}
