package hashmap;
import task4.*;
import java.util.*;
public class HashMapRunner{
public static void negativeCheck(int count)throws CreateException{
if(count<0){
throw new CreateException("enter only positive number");
}
}

private static Map createMapWithPairs()throws Exception{
Scanner sc=new Scanner(System.in);
HashMapLogic objForHashMap=new HashMapLogic();
System.out.println("howmany keys and values do you want");
int size=sc.nextInt();
sc.nextLine();
negativeCheck(size);
Map myMap=objForHashMap.createHashMap();
for(int i=0;i<size;i++){
System.out.println("enter key");
String key=sc.nextLine();
System.out.println("enter value");
String value=sc.nextLine();
objForHashMap.addMap(myMap,key,value);
}
return myMap;
}
public static void main(String[] args){
Scanner sc=new Scanner(System.in);
HashMapLogic objForHashMap=new HashMapLogic();
int quesNo=0;
try{
System.out.println("enter your question no");
quesNo=sc.nextInt();
sc.nextLine();
}
catch(Exception e){
System.out.println("enter number");
}
switch(quesNo){
case 1:
try{
Map emptyMap=objForHashMap.createHashMap();
System.out.println("map:"+emptyMap);
System.out.println("size of map:"+objForHashMap.sizeMap(emptyMap));
}
catch(CreateException e){
System.out.println(e.getMessage());
}
break;
case 2:
try{
Map myMap=createMapWithPairs();
System.out.println("map:"+myMap);
System.out.println("size of map:"+objForHashMap.sizeMap(myMap));
}
catch(CreateException e){
System.out.println(e.getMessage());
}
catch(Exception e){
System.out.println("please enter a number");
}
break;
case 3:
try{
System.out.println("howmany keys and values do you want");
int size_1=sc.nextInt();
sc.nextLine();
Map myMap_1=objForHashMap.createHashMap();
for(int i=0;i<size_1;i++){
System.out.println("enter key");
Integer key_1=sc.nextInt();
sc.nextLine();
System.out.println("enter value");
Integer value_1=sc.nextInt();
sc.nextLine();
objForHashMap.addMap(myMap_1,key_1,value_1);
}
System.out.println("map:"+myMap_1);
System.out.println("size of map:"+objForHashMap.sizeMap(myMap_1));
}
catch(CreateException e){
System.out.println(e.getMessage());
}
catch(Exception e){
System.out.println("please enter a number");
}
break;
case 4:
try{
System.out.println("howmany keys and values do you want");
int size4=sc.nextInt();
sc.nextLine();
Map myMap4=objForHashMap.createHashMap();
for(int i=0;i<size4;i++){
System.out.println("enter key");
String key4=sc.nextLine();
System.out.println("enter value");
Integer value4=sc.nextInt();
sc.nextLine();
objForHashMap.addMap(myMap4,key4,value4);
}
System.out.println("map:"+myMap4);
System.out.println("size of map:"+objForHashMap.sizeMap(myMap4));
}
catch(CreateException e){
System.out.println(e.getMessage());
}
catch(Exception e){
System.out.println("please enter a number");
}
break;
case 5:
try{
System.out.println("howmany keys and values do you want");
int size5=sc.nextInt();
sc.nextLine();
Map myMap5=objForHashMap.createHashMap();
for(int i=0;i<size5;i++){
System.out.println("enter key");
String key5=sc.nextLine();
HashMapLogic ownObject=new HashMapLogic();
Object myObject=ownObject;
objForHashMap.addMap(myMap5,key5,myObject);
}
System.out.println("map:"+myMap5);
System.out.println("size of map:"+objForHashMap.sizeMap(myMap5));
}
catch(CreateException e){
System.out.println(e.getMessage());
}
catch(Exception e){
System.out.println("please enter a number");
}
break;
case 6:
try{
System.out.println("howmany keys and values do you want");
int size6=sc.nextInt();
sc.nextLine();
Object key6=new Object();
Object value6=new Object();
Map myMap6=objForHashMap.createHashMap();
for(int i=0;i<size6;i++){
if(i==0){
System.out.println("enter 1 key");
key6=sc.nextLine();
System.out.println("1 value is null");
value6=null;
}
else{
System.out.println("enter key");
key6=sc.nextLine();
System.out.println("enter value");
value6=sc.nextLine();
}
objForHashMap.addMap(myMap6,key6,value6);
}
System.out.println("map:"+myMap6);
System.out.println("size of map:"+objForHashMap.sizeMap(myMap6));
}
catch(CreateException error){
System.out.println(error.getMessage());
}
catch(Exception e){
System.out.println("enter a number");
}
break;
case 7:
try{
System.out.println("howmany keys and values do you want");
int size7=sc.nextInt();
sc.nextLine();
Object key7=new Object();
Object value7=new Object();
Map myMap7=objForHashMap.createHashMap();
for(int i=0;i<size7;i++){
if(i==0){
System.out.println("null key");
key7=null;
System.out.println("enter null value");
value7=sc.nextLine();
}
else{
System.out.println("enter key");
key7=sc.nextLine();
System.out.println("enter value");
value7=sc.nextLine();
}
objForHashMap.addMap(myMap7,key7,value7);
}
System.out.println("map:"+myMap7);
System.out.println("size of map:"+objForHashMap.sizeMap(myMap7));
}
catch(CreateException error){
System.out.println(error.getMessage());
}
catch(Exception e){
System.out.println("enter a number");
}
break;
case 8:
try{
Map myMap8=createMapWithPairs();
System.out.println("enter key do check");
String checkKey=sc.nextLine();
System.out.println("key contains in map:"+objForHashMap.containsKeyInMap(myMap8,checkKey));
}
catch(CreateException e){
System.out.println(e.getMessage());
}
catch(Exception e){
System.out.println("please enter a number");
}
break;
case 9:
try{
Map myMap9=createMapWithPairs();
System.out.println("enter value do check");
String checkValue=sc.nextLine();
System.out.println("value contains in map:"+objForHashMap.containsValueInMap(myMap9,checkValue));
System.out.println("size of map:"+objForHashMap.sizeMap(myMap9));
}
catch(CreateException e){
System.out.println(e.getMessage());
}
catch(Exception e){
System.out.println("please enter a number");
}
break;
case 10:
try{
Object value_10=new Object();
Map myMap10=createMapWithPairs();
System.out.println("map:"+myMap10);
System.out.println("size of map:"+objForHashMap.sizeMap(myMap10));
System.out.println("how many replacing key to replacing value");
int size10=sc.nextInt();
sc.nextLine();
for(int i=0;i<size10;i++){
System.out.println("enter replace key");
Object key10=sc.nextLine();
System.out.println("enter replace value");
value_10=sc.nextLine();
objForHashMap.replaceKeyValue(myMap10,key10,value_10);
}
System.out.println("map:"+myMap10);
System.out.println("size of map:"+objForHashMap.sizeMap(myMap10));
}
catch(CreateException error){
System.out.println(error.getMessage());
}
catch(Exception e){
System.out.println("please enter a number");
}
break;
case 11:
try{
Map myMap11=createMapWithPairs();
System.out.println("enter key what value do get");
String getKey=sc.nextLine();
System.out.println("map:"+myMap11);
System.out.println("value is:"+objForHashMap.getValueInKey(myMap11,getKey));
}
catch(CreateException error){
System.out.println(error.getMessage());
}
catch(Exception e){
System.out.println("please enter a number");
}
break;
case 12:
try{
Map myMap12=createMapWithPairs();
System.out.println("map:"+myMap12);
System.out.println("enter non existing key what value do get");
String nonKey=sc.nextLine();
System.out.println("enter default value for non existing value");
String defaultValue=sc.nextLine();
System.out.println("value is:"+objForHashMap.getValueNotKey(myMap12,nonKey,defaultValue));
}
catch(CreateException error){
System.out.println(error.getMessage());
}
catch(Exception e){
System.out.println("please enter a number");
}
break;
case 13:
try{
Map myMap13=createMapWithPairs();
System.out.println("map:"+myMap13);
System.out.println("size of map:"+objForHashMap.sizeMap(myMap13));
System.out.println("enter non existing key put value do get");
String putKey=sc.nextLine();
System.out.println("enter value for non existing key");
String putValue=sc.nextLine();
Map myMap13_1=objForHashMap.putAbsent(myMap13,putKey,putValue);
System.out.println("map:"+myMap13_1);
System.out.println("size of map:"+objForHashMap.sizeMap(myMap13_1));
}
catch(CreateException error)
{
System.out.println(error.getMessage());
}
catch(Exception e)
{
System.out.println("please enter a number");
}
break;
case 14:
try
{
Map myMap14=createMapWithPairs();
System.out.println("enter key for remove");
String removeKey=sc.nextLine();
System.out.println("map:"+myMap14);
System.out.println("size of map:"+objForHashMap.sizeMap(myMap14));
objForHashMap.remove(myMap14,removeKey);
System.out.println("map after remove:"+myMap14);
System.out.println("size of map after remove:"+objForHashMap.sizeMap(myMap14));
}
catch(CreateException error)
{
System.out.println(error.getMessage());
}
catch(Exception e)
{
System.out.println("please enter a number");
}
break;
case 15:
try
{
Map myMap15=createMapWithPairs();
System.out.println("enter key for remove");
String removeKey_1=sc.nextLine();
System.out.println("enter old value that key for remove");
String oldValue=sc.nextLine();
System.out.println("map:"+myMap15);
System.out.println("size of map:"+objForHashMap.sizeMap(myMap15));
objForHashMap.removeMatchValue(myMap15,removeKey_1,oldValue);
System.out.println(myMap15);
System.out.println(objForHashMap.sizeMap(myMap15));
}
catch(CreateException error)
{
System.out.println(error.getMessage());
}
catch(Exception e)
{
System.out.println("please enter a number");
}
break;
case 16:
try{
Map myMap16=createMapWithPairs();
System.out.println("map:"+myMap16);
System.out.println("size of map:"+objForHashMap.sizeMap(myMap16));
System.out.println("enter howmany keys to replace value");
int size16=sc.nextInt();
sc.nextLine();
for(int i=0;i<size16;i++){
System.out.println("enter replece key");
Object key16=sc.nextLine();
System.out.println("enter replace value");
Object replaceValue=sc.nextLine();
objForHashMap.replaceKeyValue(myMap16,key16,replaceValue);
}
System.out.println("map after replace:"+myMap16);
System.out.println("size of map:"+objForHashMap.sizeMap(myMap16));
}
catch(CreateException error){
System.out.println(error.getMessage());
}
catch(Exception e){
System.out.println("please enter a number");
}
break;
case 17:
try{
Map myMap17=createMapWithPairs();
System.out.println("map:"+myMap17);
System.out.println("size of map:"+objForHashMap.sizeMap(myMap17));
System.out.println("howmany key do you want to replacing value");
int size17=sc.nextInt();
sc.nextLine();
for(int i=0;i<size17;i++){
System.out.println("enter replece key");
Object key17=sc.nextLine();
System.out.println("enter old value");
Object oldValue_1=sc.nextLine();
System.out.println("enter replace value");
Object replaceValue_1=sc.nextLine();
objForHashMap.replaceMatch(myMap17,key17,oldValue_1,replaceValue_1);
}
System.out.println("map after replace:"+myMap17);
System.out.println("size of map replace:"+objForHashMap.sizeMap(myMap17));
}
catch(CreateException error){
System.out.println(error.getMessage());
}
catch(Exception e){
System.out.println("please enter a number");
}
break;
case 18:
try{
Map myMap18_1=createMapWithPairs();
Map myMap18_2=createMapWithPairs();
System.out.println("map 1:"+myMap18_1);
System.out.println("size of map1:"+objForHashMap.sizeMap(myMap18_1));
System.out.println("map 2:"+myMap18_2);
System.out.println("size of map 2:"+objForHashMap.sizeMap(myMap18_2));
objForHashMap.putMap(myMap18_1,myMap18_2);
System.out.println(myMap18_2);
System.out.println(objForHashMap.sizeMap(myMap18_2));
}
catch(CreateException error){
System.out.println(error.getMessage());
}
catch(Exception e){
System.out.println("please enter a number");
}
break;
case 19:
try{
Map myMap19=createMapWithPairs();
System.out.println("map:"+myMap19);
System.out.println("size of map:"+objForHashMap.sizeMap(myMap19));
Iterator iteratingMap=myMap19.entrySet().iterator();
for(int i=0;iteratingMap.hasNext();i++){
System.out.println(iteratingMap.next());
}
}
catch(CreateException error){
System.out.println(error.getMessage());
}
catch(Exception e){
System.out.println("please enter a number");
}
break;
case 20:
try{
Map myMap20=createMapWithPairs();
System.out.println("map:"+myMap20);
System.out.println("size of map:"+objForHashMap.sizeMap(myMap20));
System.out.println("map after clear:"+objForHashMap.clearMap(myMap20));
System.out.println("size of map:"+objForHashMap.sizeMap(myMap20));
}
catch(CreateException error){
System.out.println(error.getMessage());
}
catch(Exception e){
System.out.println("please enter a number");
}
break;
default:
System.out.println("enter a correct number and below 20");
}
}
}
