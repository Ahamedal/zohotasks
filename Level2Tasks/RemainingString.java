package Level2Tasks;

import java.util.Scanner;

public class RemainingString {
	public static String remainingString(String s,char c,int count) {
		int no=0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)==c) {
				no++;
			}
			if(no==count) {
				if(i==s.length()-1) {
					return "empty string";
				}
				return s.substring(i+1);
			}
		}
		return "Empty string";
	}
	
	public static void reverseEach(String s) {
		String[] sp=s.split("[.]");
		String a="";
		for(String str:sp) {
		
				String ans="";
				for(int i=0;i<str.length();i++) {
					ans=str.charAt(i)+ans;
				
			}
				if(a=="") {
					a=a+ans;
				}
				else {
				a=a+"."+ans;
				}
		}
		System.out.println(a);

	}
	
	public static void reverseSpace(String s) {
		char[] ch=new char[s.length()];
		int j=s.length()-1;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)==' ') {
				ch[i]=' ';
			}
			if(s.charAt(i)!=' ') {
			while(s.charAt(j)==' ') {
				j--;
			}
				ch[j]=s.charAt(i);
				j--;
			}
		}
		System.out.println(ch);
	}
	public static void cross(String s) {
		for(int i=0;i<s.length();i++) {
			for(int j=0;j<s.length();j++) {
				if(i==j) {
					System.out.print(s.charAt(i));
				}
				else if(i+j==s.length()-1) {
					System.out.print(s.charAt(j));
				}
				else {
					System.out.print(' ');
				}
			}
		
		}
	}
	public static boolean kPangram(String str,int k) {
		  int count=0;
	        boolean[] b=new boolean[26];
	        for(int i=0;i<str.length();i++){
	            if(str.charAt(i)>='a'&&str.charAt(i)<='z'){
	               b[str.charAt(i)-97]=true;
	            }
	        }
	        for(boolean f:b) {
	        	if(f) {
	        	count++;
	        	}
	        }
	        if(k+count>=26||count==26){
	            return true;
	        }
	      return false;
	    }
	public static void maxNo(String s) {
		int k=-1;
		for(int i=0;i<s.length();i++) {
			for(int j=i+1;j<s.length();j++) {
				if(s.charAt(i)==s.charAt(j)) {
					k=Math.max(k, j-i-1);
				}
			}
		}
		System.out.println(k);
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a string");
		String A=sc.nextLine();
		maxNo(A);
		//cross(A);
		//reverseSpace(A);
		//reverseEach(A);
//		char c=sc.next().charAt(0);
	//	int count=sc.nextInt();
//System.out.println(kPangram(A,count));
			}

}
