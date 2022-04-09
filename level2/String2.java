package level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class String2 {
	public boolean checkIfPangram(String sentence) {
        boolean[] result=new boolean[26];
        for(int i=0;i<sentence.length();i++){
            if(sentence.charAt(i)>='a'&&sentence.charAt(i)<='z'){
                result[sentence.charAt(i)-'a']=true;
            }
        }
    for(int j=0;j<result.length;j++){
        if(!result[j]){
            return false;
        }
    }
    return true;    
    }
	
	public String removeChars(String string1, String string2){
	        // code here
	         for(int i=0;i<string1.length();i++){
	         for(int j=0;j<string2.length();j++){
	            
	             if(string1.charAt(i)==string2.charAt(j)){
	                     String s2="";
	                     s2=s2+string1.charAt(i);
	                    string1=string1.replace(s2,""); 
	                 
	                 }
	             }
	         }
	        
	        return string1;
	    }
	
		public int romanToInt(String s1) {
			Map<String, Integer> map = new HashMap<>();
			map.put("I", 1);
			map.put("V", 5);
			map.put("X", 10);
			map.put("L", 50);
			map.put("C", 100);
			map.put("D", 500);
			map.put("M", 1000);
			map.put("IV", 4);
			map.put("IX", 9);
			map.put("XL", 40);
			map.put("XC", 90);
			map.put("CD", 400);
			map.put("CM", 900);
			int result = 0;
			String c = null;
			int i = 0;
			while (i < s1.length()) {
				char a = s1.charAt(i);
				char b = s1.charAt(i);
				if (i < s1.length() - 1) {
					b = s1.charAt(i + 1);

				}
				c = String.valueOf(a) + String.valueOf(b);
				if (map.containsKey(c)) {
					result = result + map.get(c);
					i = i + 2;
				} else if (map.containsKey(String.valueOf(a))) {
					result = result + map.get(String.valueOf(a));
					i++;
				} else {
					i++;
				}
			}
			return result;
		}
		
		public boolean isValidParenthesis(String s) {
	        Stack<Character> stack=new Stack<>();
	        for(int i=0;i<s.length();i++){
	            char ch=s.charAt(i);
	            if(ch=='('||ch=='['||ch=='{'){
	                stack.push(ch);
	                continue;
	            }
	           if(stack.isEmpty()){
	               return false;
	            }
	            switch(ch){
	                case ')':
	                    if(!stack.peek().equals('(')){
	                        return false;
	                    }
	                   stack.pop();
	                    break;
	                case '}':
	                    if(!stack.peek().equals('{')){
	                        return false;
	                    }
	                    stack.pop();
	                    break;
	                case ']':
	                    if(!stack.peek().equals('[')){
	                    return false;
	                    }
	                    stack.pop();
	                    break;
	    
	                
	            }
	        }
	        if(stack.isEmpty()){
	            return true;
	        }
	        return false;
	        
	    }
		
		public String countAndSay(int n) {
	        String resul="1";
	        
	    
	        for(int i=1;i<n;i++){
	            String next1="";
	            int k=0;
	        while(k<resul.length()){
	            int no=1;
	            while(k<resul.length()-1&&resul.charAt(k)==resul.charAt(k+1)){
	                no++;
	                k++;
	                  }
	                
	                next1=next1+Integer.toString(no)+resul.charAt(k);
	                k++;
	                
	            }
	            resul=next1;
	        }
	        return resul;
	        
	    }
		
		public String reversingTheVowels (String s)
	    {
	        // your code here
	        String s1="";
	        char[] c=s.toCharArray();
	        for(int i=0;i<s.length();i++){
	            if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'){
	                s1=s1+s.charAt(i);
	            }
	        }
	        int j=s1.length()-1;
	        for(int i=0;i<s.length();i++){
	        if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'){
	             c[i]=s1.charAt(j);
	              j--;
	            }
	        }
	        return String.valueOf(c);
	    }
		
		public String firstAlphabet(String S) {
	        // code here
	         String s2="";
	        String[] array=S.split(" ");
	        for(String s:array){
	            s2=s2+s.charAt(0);
	        }
	        return s2;
	    }
		
		public String encryptString(String S){
	        // code here
	    String ans="";
	    	for(int i=0;i<S.length();i++) {
	    		int no=1;
	    		
	    		while(i<S.length()-1&&(S.charAt(i)==S.charAt(i+1))) {
	    			no++;
	    			i++;
	    		}
	    		ans=String.valueOf(Integer.toHexString(no))+S.charAt(i)+ans;
	    	}
	    	return ans;
	        
	    }
		
		 public boolean areIsomorphic(String str1,String str2)
		    {
		        // Your code here
		         Map<Character,Character> map11=new HashMap<>();
		        Map<Character,Character> map22=new HashMap<>();
		        if(str1.length()!=str2.length()){
		            return false;
		        }
		        for(int i=0;i<str1.length();i++){
		            char a=str1.charAt(i);
		            char b=str2.charAt(i);
		     if(map11.containsKey(a)&&map11.get(a)!=b||map22.containsKey(b)&&map22.get(b)!=a){
		         return false;
		     }
		     map11.put(a,b);
		     map22.put(b,a);
		        }
		       return true; 
		        
		    }
		 
		 public int minimumNumberOfDeletions(String S) {
		        
		        //your code here
		        int start=0;
		        int end=S.length()-1;
		        int minDelete=lps(S,start,end);
		        return S.length()-minDelete;
		        }
		        
		  static int lps(String s,int start,int end) {
				int lp=0;
				if(start==end) {
					return 1;
				}
			   
				if(s.charAt(start)==s.charAt(end)) {
				   lp=2+lps(s,start+1,end-1);
				}
				else {
					lp=Math.max(lps(s,start+1,end),lps(s,start,end-1));
				}
				
				
				return lp;
		        }
		 
		  public boolean isRotated(String str1, String str2)
		    {
		        // Your code here
		         String temp1="";
		        temp1=temp1+str1.substring(0,2);
		        temp1=str1.substring(2,str1.length())+temp1;
		        String temp2="";
		        temp2=temp2+str1.substring(0,str1.length()-2);
		        temp2=str1.substring(str1.length()-2,str1.length())+temp2;
		     
		        if(temp1.equals(str2)||temp2.equals(str2)){
		            return true;
		        }
		        return false;
		    }
		  
		    public boolean isValidIP(String s) {
		        Set<String> set=new HashSet<>();
		        // Write your code here
		        for(int i=0;i<256;i++){
		            set.add(Integer.toString(i));
		        }
		        String[] arr=s.split("[.]");
		        int count=0;
		        for(int i=0;i<s.length();i++){
		            if(s.charAt(i)=='.'){
		                count++;
		            }
		        }
		        if(count!=3){
		            return false;
		        }
		        if(arr.length!=4){
		            return false;
		        }
		        for(int i=0;i<arr.length;i++){
		            if(!set.contains(arr[i])){
		                return false;
		            }
		        }
		        return true;
		    }
		    
		    public int formPalindrome(String str)
		    {
		        // code here
		        StringBuffer sb=new StringBuffer(str);
		        sb.reverse();
		        String str2=new String(sb);
		        int x=str.length();
		        int y=str2.length();
		        int[][] dp=new int[x+1][y+1];
		        for(int i=0;i<x+1;i++){
		            for(int j=0;j<y+1;j++){
		                if(i==0||j==0){
		                    dp[i][j]=0;
		                }
		                else if(str.charAt(i-1)==str2.charAt(j-1)){
		                    dp[i][j]=1+dp[i-1][j-1];
		                }
		                else{
		                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
		                }
		            }
		        }
		        
		    return x-dp[x][y];
		        
		    }
		    
		    public boolean checkPermut(String s1, String s2) {
		        if(s1.length()==1){
		            if(s2.contains(s1)){
		                return true;
		            }
		            else{
		                return false;
		            }
		        }
		     	char[] c=s1.toCharArray();
		    	Arrays.sort(c);
		    	for(int i=0;i<s2.length();i++) {
		    		String temp="";
		    		temp=temp+s2.charAt(i);
		    		for(int j=i+1;j<s2.length();j++) {
		    			temp=temp+s2.charAt(j);
		    			char[] c1=temp.toCharArray();
		    			Arrays.sort(c1);
		    			if(Arrays.equals(c, c1)){
		    				return true;
		    			}
		    		}
		    		
		    	}
		    	return false;
		    }
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	String2 obj=new String2();
	System.out.println("Enter Question No");
	int no=sc.nextInt();
	sc.nextLine();
   
	switch(no) {
	case 1:
		System.out.println("Enter the String");
		String s1=sc.nextLine();
	    System.out.println(obj.checkIfPangram(s1));
	    break;
	    
	case 2:
		System.out.println("Enter the String");
		String s21=sc.nextLine();
		System.out.println("Enter the String");
		String s22=sc.nextLine();
		System.out.println(obj.removeChars(s21, s22));
		break;
		
	case 3:
		System.out.println("enter the String");
		String s3=sc.next();
		System.out.println(obj.romanToInt(s3));
		break;
		
	case 4:
		System.out.println("Enter the String");
		String ss=sc.nextLine();
	    System.out.println(obj.isValidParenthesis(ss));
	    break;
	    
	case 5:
		System.out.println("enter the number");
		int n=sc.nextInt();
		sc.nextLine();
		System.out.println(obj.countAndSay(n));
		break;
		
	case 6:
		System.out.println("Enter the String");
		String s6=sc.nextLine();
	    System.out.println(obj.reversingTheVowels(s6));
	    break;
	
	case 7:
		System.out.println("Enter the String");
		String s7=sc.nextLine();
	    System.out.println(obj.firstAlphabet(s7));
	    break;
	    
	case 8:
		System.out.println("enter the String");
		String sss=sc.nextLine();
		System.out.println(obj.encryptString(sss));
		break;
		
	case 9:
		System.out.println("Enter the String");
		String s99=sc.nextLine();
		System.out.println("Enter the String");
		String s999=sc.nextLine();
		System.out.println(obj.areIsomorphic(s99, s999));
		break;
		
	case 10:
		System.out.println("Enter the String");
		String s10=sc.nextLine();
		System.out.println(obj.minimumNumberOfDeletions(s10));
		break;
		
	case 11:
		System.out.println("Enter the String");
		String s11=sc.nextLine();
		System.out.println("Enter the String");
		String s111=sc.nextLine();
	    System.out.println(obj.isRotated(s11, s111));
	    break;
	    
	case 12:
		System.out.println("Enter the String");
		String s12=sc.nextLine();
	    System.out.println(obj.isValidIP(s12));
	    break;
	    
	case 13:
		System.out.println("Enter the String");
		String s13=sc.nextLine();
		System.out.println(obj.formPalindrome(s13));
		break;
		
	case 14:
		System.out.println("Enter the String");
		String s1s=sc.nextLine();
		System.out.println("Enter the String");
		String s1ss=sc.nextLine();
		System.out.println(obj.checkPermut(s1s,s1ss));
		break;
		
		
	}
}
}
