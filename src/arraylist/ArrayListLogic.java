package arraylist;
import one.Task1;
import java.util.*;

public class ArrayListLogic{

Task1 objectForTask1=new Task1();
public List createList(){
List emptyList=new ArrayList();
return emptyList;
}
//#1 ques
public int sizeOfList(List elementsList)throws Exception{
listValidator(elementsList);
int size=elementsList.size();
return size;
}
//#2 ques
public List addList(List elementsList,Object[] inputArray)throws Exception{
listValidator(elementsList);
Collections.addAll(elementsList,inputArray);
return elementsList;
}
//#6 ques
public int findIndex(List elementsList,String findElement)throws Exception{
listValidator(elementsList);
int indexOfElement=elementsList.indexOf(findElement);
return indexOfElement;
}
//#7 ques
public List printEachElement(List elementsList)throws Exception{
listValidator(elementsList);
return elementsList;
}
//#8 ques
public String findElementAtIndex(List elementsList,int index)throws Exception{
listValidator(elementsList);
listNumberValidator(index,elementsList);
String findElement=(String)elementsList.get(index);
return findElement;
}
//#9 ques
public int findLastDuplicates(List myList,String findStr)throws Exception{
listValidator(myList);
int lastIndex=myList.lastIndexOf(findStr);
return lastIndex;
}
//#10 ques
public List insertList(List addList,int position,String insertStr)throws Exception{
listValidator(addList);
listNumberValidator(position,addList);
addList.add(position,insertStr);
return addList;
}
//#11 ques
public List takeSubList(List addList,int startPosition,int endPosition)throws Exception{
listValidator(addList);
objectForTask1.positionCheck(startPosition,endPosition);
listNumberValidator(startPosition,addList);
listNumberValidator(endPosition,addList);
List subList=addList.subList(startPosition,endPosition);
return subList;
}
//#12 ques
public List addAllList(List firstList,List secondList)throws Exception{
listValidator(firstList);
listValidator(secondList);
firstList.addAll(secondList);
return firstList;
}
//#14 ques
public List removeList(List addList,float removeFloat)throws Exception{
listValidator(addList);
addList.remove(removeFloat);
return addList;
}
//#15 ques
public List removeListUsingIndex(List addList,int index)throws Exception{
listValidator(addList);
listNumberValidator(index,addList);
addList.remove(index);
return addList;
}
//#17 ques
public List removeAllList(List list1,List list2)throws Exception{
listValidator(list1);
listValidator(list2);
list1.removeAll(list2);
return list1;
}
//#18 ques 
public List retainAllList(List firstList,List secondList)throws Exception{
listValidator(firstList);
listValidator(secondList);
firstList.retainAll(secondList);
return firstList;
}
//#19 ques
public List removeLong(List myList)throws Exception{
listValidator(myList);
myList.clear();
return myList;
}
//#20 ques
public boolean containsInList(List myList,String checkStr)throws Exception{
listValidator(myList);
boolean check=myList.contains(checkStr);
return check;
}
public void listValidator(List testList)throws Exception{
if(testList==null){
throw new Exception("List cannot be null");
}
}
public void listNumberValidator(int testNumber,List testList)throws Exception{
if(testNumber<0||sizeOfList(testList)<=testNumber){
throw new Exception("Number cannot be negative or given number exceeds the length of given List");
}
}


}
