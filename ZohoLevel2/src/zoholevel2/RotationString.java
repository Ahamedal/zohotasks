package zoholevel2;

import java.util.Scanner;

public class RotationString {
	public String subStr(String s,int start,int end) {
		String s1="";
		for(int i=start;i<end;i++) {
			s1=s1+s.charAt(i);
		}
		return s1;
	}
	public boolean equalTwoString(String string1,String temp) {
		string1=string1.toUpperCase();
		temp=temp.toUpperCase();
		if(string1.length()!=temp.length()) {
			return false;
		}
		for(int i=0;i<string1.length();i++) {
			if(string1.charAt(i)!=temp.charAt(i)) {
				return false;
			}
		}
		return true;
	}
 public boolean isRotation(String string1,String string2) throws Exception {
	 stringCheck(string1);
	 stringCheck(string2);
	 int len=string1.length();
	 if(len!=string2.length()) {
		 return false;
	 }

	 String temp1="";
	 String temp2="";
	 for(int i=0;i<len;i++) {
		 
		 temp1=subStr(string1,len-i,len)+subStr(string1,0, len-i);//clockwise
		 temp2=subStr(string1,0,len-i)+subStr(string1,len-i,len);//anticlockwise
		
		 if(equalTwoString(string2,temp1)||equalTwoString(string2,temp2)) {
			 return true;
		 }
		 
	 }
	 return false;
 }
 public void stringCheck(String string) throws Exception {
	 if(string==null||string.isEmpty()) {
		 throw new Exception("Enter valid input");
	 }
 }
 public static void main(String[] args) {
	 Scanner sc=new Scanner(System.in);
	 
	 RotationString obj=new RotationString();
	 try {
	 System.out.println("Enter the first String");
	 String string1=sc.nextLine();
	 System.out.println("Enter the second String");
	 String string2=sc.nextLine();
	 System.out.println(obj.isRotation(string1, string2));
	 }
	 catch(Exception e) {
		 System.out.println(e.getMessage());
	 }
	 
	 
 }
}
