package task4;
import java.util.*;
public class HashMapLogic
{
public Map createHashMap()
{
Map<Object,Object> hm=new HashMap<Object,Object>();
return hm;
}
//#1
public int sizeMap(Map hashMap)throws CreateException{
mapValidator(hashMap);
int size=hashMap.size();
return size;
}
//#2,#3,#4,#5,#6,#7
public Map addMap(Map<Object,Object> map,Object key,Object value)throws CreateException{
mapValidator(map);
map.put(key,value);
return map;
}
//#8
public boolean containsKeyInMap(Map<Object,Object> addMap,Object key)throws CreateException{
mapValidator(addMap);
boolean check=addMap.containsKey(key);
return check;
}
//#9
public boolean containsValueInMap(Map<Object,Object> addMap,Object value)throws CreateException{
mapValidator(addMap);
return addMap.containsValue(value);
}
//#11
public Object getValueInKey(Map<Object,Object> addMap,Object key)throws CreateException{
mapValidator(addMap);
Object value=addMap.get(key);
return value;
}
//#12
public Object getValueNotKey(Map<Object,Object> addMap,Object key,Object defaultValue)throws CreateException{
mapValidator(addMap);
Object value=addMap.getOrDefault(key,defaultValue);
return value;
}
//#13
public Map putAbsent(Map<Object,Object> addMap,Object key,Object value)throws CreateException{
mapValidator(addMap);
addMap.putIfAbsent(key,value);
return addMap;
}
//#14
public Map remove(Map<Object,Object> addMap,Object key)throws CreateException{
mapValidator(addMap);
addMap.remove(key);
return addMap;
}
//#15
public Map removeMatchValue(Map<Object,Object> addMap,Object key,Object value)throws CreateException{
mapValidator(addMap);
addMap.remove(key,value);
return addMap;
}
//#16
public Map replaceKeyValue(Map<Object,Object> addMap,Object key,Object changeValue)throws CreateException{
mapValidator(addMap);
addMap.replace(key,changeValue);
return addMap;
}
//#17
public Map replaceMatch(Map<Object,Object> addMap,Object key,Object oldValue,Object changeValue)throws CreateException{
mapValidator(addMap);
addMap.replace(key,oldValue,changeValue);
return addMap;
}
//#18
public Map putMap(Map<Object,Object> firstMap,Map<Object,Object> secondMap)throws CreateException{
mapValidator(firstMap);
mapValidator(secondMap);
secondMap.putAll(firstMap);
return secondMap;
}
//#20
public Map clearMap(Map<Object,Object> addMap)throws CreateException
{
mapValidator(addMap);
addMap.clear();
return addMap;
}

public void mapValidator(Map<Object,Object> addMap)throws CreateException
{
if(addMap==null)
{
throw new CreateException("Map cannot be null");
}
}

}
