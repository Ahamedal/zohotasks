package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class String3 {
	public int longestPrefixSuffix(String s) {
        // code here
        int a[]=new int[s.length()];
        int j=0;
        int i=1;
        while(i<s.length()){
            if(s.charAt(i)==s.charAt(j)){
                a[i]=j+1;
                i++;
                j++;
            }
            else{
                if(j==0){
                    i++;
                }
                else{
                    j=a[j-1];
                }
            }
        }
        return a[s.length()-1];
    }
	
	public boolean areKAnagrams(String s1, String s2, int k) {
	        // code here
	        int count=0;
	        if(s1.length()!=s2.length()){
	            return false;
	        }
	        for(int i=0;i<s1.length();i++){
	            for(int j=0;j<s2.length();j++){
	                if(s1.charAt(i)==s2.charAt(j)){
	                    s2=s2.replaceFirst(String.valueOf(s2.charAt(j)),"");
	                   count++; 
	                   break;
	                }
	                
	            }
	        }
	        if((s1.length()-count)<=k){
	            return true;
	        }
	        return false;
	    }
	
	public int longestUniqueSubsttr(String S){
	      Map<Character,Integer> map=new HashMap<>();
	      int j=0;
	      int k=0;
	      for(int i=0;i<S.length();i++){
	          char c=S.charAt(i);
	          if(map.containsKey(c)){
	              if(j<=map.get(c)){
	              j=map.get(c)+1;
	              }
	          }
	          k=Math.max(k,i-j+1);
	          map.put(c,i);
	      }
	      return k;
	    }
	 public static void number(String s) {
	    	int len = s.length();
	    	String temp = "";
	    	String temp2 = "";
	    	String[] ones = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
	    	"twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
	    	String[] tenes = { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
	    	String[] large = { "", "hundred", "thousand" ,"lakhs"};
	    	for (int i = 0; i < len; i++) {
	    	if (s.length() == 1 || (s.length() == 2 && s.charAt(0) == '1')) {
	    		
	    	if (s.length() == 2 && s.charAt(0) == '1') {
	    		if(temp.contains("thousand")) {
	    	    	temp=temp+"and ";
	    	    	}
	    	while (s.length() > 0) {
	    	temp2 = temp2 + s.charAt(0);
	    	s = s.replaceFirst(String.valueOf(s.charAt(0)), "");
	    	}
	    	temp = temp + ones[Integer.parseInt(temp2)];
	    	} else {
	    	temp = temp + ones[Integer.parseInt(String.valueOf(s.charAt(0)))];
	    	s = s.replace(String.valueOf(s.charAt(0)), "");
	    	}
	    	}
	    	if (s.length() == 2) {
	    	if(temp.contains("thousand")) {
	    	temp=temp+"and ";
	    	}
	    	temp = temp + tenes[Integer.parseInt(String.valueOf(s.charAt(0)))] + " ";
	    	s = s.replaceFirst(String.valueOf(s.charAt(0)), "");
	    	}
	    	if (s.length() > 2) {
	    	if (s.length() % 2 != 0&&s.length()>3) {
	    		if (s.charAt(0) == '1') {
	        		
	        	while (s.length() > 3) {
	        	temp2 = temp2 + s.charAt(0);
	        	s = s.replaceFirst(String.valueOf(s.charAt(0)), "");
	        	}
	        	temp = temp + ones[Integer.parseInt(temp2)]+" ";
	        	temp = temp + large[s.length() - 1] + " ";
	    		}
	    		else {
	    	temp = temp + tenes[Integer.parseInt(String.valueOf(s.charAt(0)))] + " ";

	    	s = s.replaceFirst(String.valueOf(s.charAt(0)), "");
	    		}
	    	}

	    	temp = temp + ones[Integer.parseInt(String.valueOf(s.charAt(0)))] + " ";
	    	temp = temp + large[s.length() - 2] + " ";
	    	s = s.replaceFirst(String.valueOf(s.charAt(0)), "");

	}
	    	}
	    	System.out.println(temp);
	    }
	    public static String commonFrag(String[] s1) {
	    	
	    		String temp = "";
	    		int count = 0;
	    		ArrayList<String> arr = new ArrayList<String>();
	    		int i=0;
	    		for (i = 0; i < s1[0].length(); i++) {
	    			
	    			
	    			
	    			if (s1[0].charAt(i) == ' ') {
	    				if (fragmentChecker(s1, temp) && count < 3) {
	    					count++;
	    					arr.add(temp);
	    					temp = temp + " ";
	    				} 
	    				else 
	    				{
	    					if (count == 3) {
	    						return arr.get(arr.size() - 1);
	    					} 
	    					
	    					arr.clear();
	    					

	    					count = 0;
	    					temp = "";
	    				}

	    			} else {
	    				temp += s1[0].charAt(i);
	    			}
	    		}
	    		if(i==s1[0].length()) {
					if (fragmentChecker(s1, temp) && count < 3) {
						count++;
						arr.add(temp);
						temp = temp + " ";
					} 
	    		}
	    		if (count == 3) {
					return arr.get(arr.size() - 1);
				} 
	    		return "no consecutive same words";
	    	}
	    public static boolean fragmentChecker(String[] s1, String temp) {
			boolean bool[] = new boolean[s1.length];
			for (int i = 0; i < s1.length; i++) {
				if (s1[i].contains(temp)) {
					bool[i] = true;
				}

			}
			for (boolean boo : bool) {
				if (!boo) {
					return false;
				}
			}

			return true;
		}
	    	
	    	
	   
	    public static void pairSub(String s1,String s2) {
	    	
	    	for(int i=0;i<s1.length();i++) {
	    		String temp1="";
	        	String temp2="";
	    		while(i<s1.length()&&(s1.charAt(i)!=s2.charAt(i))) {
	    			temp1=temp1+s1.charAt(i);
	    			temp2=temp2+s2.charAt(i);
	    			i++;
	    			}
	    		if(!temp1.equals("")) {
	    		System.out.println(temp1+","+temp2);
	    	}
	    	}
	    } 
	    public static void magicalString(String s1,String s2) {
	    	String a="abcdefghijklmnopqrstuvwxyz";
	    	String temp="";
	    	for(int i=0;i<s1.length();i++) {
	    		temp=temp+a.charAt(25-(s1.charAt(i)-'a'));
	    	}
	    	if(temp.equals(s2)) {
	    		System.out.println("it is magical string");
	    	}
	    	else {
	    		System.out.println("no such strings");
	    	}
	    }
	    public static String rev(String s) {
	    	String ans="";
	    	for(int i=0;i<s.length();i++) {
	    		ans=s.charAt(i)+ans;
	    	}
	    	return ans;
	    }
	    public static void removePalindrome(String s1) {
	    	char[] c=s1.toCharArray();
	    	String temp="";
	    	for(int i=0;i<c.length;i++) {
	    		String temp2="";
	    		while(i<c.length&&c[i]!=' ') {
	    			temp2=temp2+c[i];
	    			i++;
	    		}
	    		if(!temp2.equals(rev(temp2))) {
	    			temp=temp+temp2+" ";
	    		}
	    	
	    	}
	    	System.out.println(temp);
	    }
	    public static List<String> find_permutation(String S) {
	        // Code here
	        String prefix="";
	             List<String> list=new ArrayList<>() ;
	             permuts(prefix,S,list);
	             Collections.sort(list);
	             return list;
	    }
	       public static void permuts(String prefix,String strr,List list) {

			if(prefix!=""||strr.length()==0) {
				list.add(prefix);
				
			}
		
		     for(int i=0;i<strr.length();i++) {
		         //System.out.println(i);
		    	 char ch=strr.charAt(i);
		    //	System.out.println(i+" "+ch);
		    	 
		    	 permuts(prefix+ch,strr.substring(0, i)+strr.substring(i+1),list);
		     
			}
	    }
	    public static char Balanced(String s) {
	   
	    	for(int i=1;i<s.length()-1;i++) {
	    		int a1=0;
	    		int h=i;
	    		int a=1;
	    	while(h>0) {
	    		 a1+=a*(s.charAt(h-1)-'a'+1);
	    		 h--;
	    		 a++;
	    	}
	    	int k=i;
	    	int a2=0;
	    	int b=1;
	    	while(k<s.length()-1) {
	    		a2+=b*(s.charAt(k+1)-'a'+1);
	    		k++;
	    		b++;
	    	}
	    	if(a1==a2) {
	    		return s.charAt(i);
	    	}
	    	}
	    	return '0';
	    }
	    public static String encoding(String s1) {
	    	String temp="";
	    	String s="0";
	    	
	    	if(s1.contains("(")&&s1.contains(")")) {
	    		int first=s1.lastIndexOf("(");
	    		int last=s1.indexOf(")",first);
	    		int k=first-1;
	    		String sss="";
	    		while(k>=0&&Character.isDigit(s1.charAt(k))) {
	    			sss+=s1.charAt(k);
	    			k--;
	    		}
	    		int count=Integer.parseInt(sss);
	    	   String str=s1.substring(first+1, last);
	    		for(int i=0;i<count;i++) {
	    			temp+=str;
	    		}
	    		temp=s1.substring(0,first-sss.length())+temp+s1.substring(last+1,s1.length());
	    		return encoding(temp);
	    	}
	    	for(int i=0;i<s1.length();i++) {
	    		int k=0;
	    		if(Character.isDigit(s1.charAt(i))) {
	    			
	    			s=s+s1.charAt(i);
	    			}
	    		else if(s=="0") {
	    			temp=temp+s1.charAt(i);
	    		}
	    		else {
	    			while(k<Integer.parseInt(s)) {
	        			temp=temp+s1.charAt(i);
	        			k++;
	        			}
	    			s="0";
	    		}
	    		
	    	}
	    	
	    	return temp;
	    }
	    public static void nonDuplicate(String s) {
	    	char a='0';
	    	int[] d=new int[5];
	    	
	    	for(int i=0;i<s.length();i++) {
	    		if(s.indexOf(s.charAt(i))==s.lastIndexOf(s.charAt(i))) {
	    			a=s.charAt(i);
	    			break;
	    		}
	    		
	    	}
	    	if(a!='0') {
	    		System.out.println(a);
	    	}
	    	else {
	    		System.out.println("no non repeated words");
	    	}
	    	
	    }
	    public static void longestPreSuf(String s) {
	    	int a[]=new int[s.length()];
	        int j=0;
	        int i=1;
	        while(i<s.length()){
	            if(s.charAt(i)==s.charAt(j)){
	                a[i]=j+1;
	                i++;
	                j++;
	            }
	            else{
	                if(j==0){
	                    i++;
	                }
	                else{
	                    j=a[j-1];
	                }
	            }
	        }
	        System.out.println(a[s.length()-1]);
	    }
	    public static ArrayList alter(long[] arr,int N) {
	    	// Your code goes here
	        ArrayList<Long> ans=new ArrayList<>();
	        Arrays.sort(arr);
	        int j=arr.length-1;
	        int i=0;
	        while(i<=j)
	        {
	            ans.add( arr[j]);
	            ans.add(arr[i]);
	            i++;
	            j--;
	        }
	        return ans;
	        
	    }
	    public static int minDist(int a[],int x,int y,int n) {
	    	int ans=Integer.MAX_VALUE;
	        for(int i=0;i<n;i++){
	            if(a[i]==x){
	              int  j=i+1;
	               while(j<a.length&&a[j]==y){
	                   int diff=j-i;
	                   j++;
	                   if(diff<ans){
	                       ans=diff;
	                       break;
	                   }
	               }
	            }
	           
	        }
	        if(ans==Integer.MAX_VALUE){
	            return -1;
	        }
	        return ans;
	    }
	    public static void rearrange(int[] arr,int n) {
	    	 ArrayList<Integer> pos=new ArrayList<>();
	         ArrayList<Integer> neg=new ArrayList<>();
	         
	         for(int i=0;i<n;i++){
	             if(arr[i]>=0){
	                 pos.add(arr[i]);
	             }
	             else{
	                 neg.add(arr[i]);
	             }
	         }
	       for(int i=0;i<n;i++){
	           if(pos.size()!=0){
	              System.out.print(pos.get(0)+" ");
	               pos.remove(pos.get(0));
	           }
	           if(neg.size()!=0){
	         System.out.print(neg.get(0)+" ");
	          neg.remove(neg.get(0));
	           }
	       }
	    }
	    public static boolean findsum(int[] arr,int n) {
	    	 Set<Integer> set=new HashSet<>();
	         int sum=0;
	         for(int i=0;i<arr.length;i++){
	             
	                 
	                 sum+=arr[i];
	                 
	               
	                  if(arr[i]==0||sum==0||set.contains(sum)){
	                     return true;
	                 }
	                
	               set.add(sum);
	           
	         }
	         return false;
	    }
	    public static int firstNonRepeat(int[] arr,int n) {
	    	 Map<Integer,Integer> hm=new HashMap<>();
	         for(int i=0;i<n;i++){
	             if(hm.containsKey(arr[i])){
	                 hm.put(arr[i],hm.get(arr[i])+1);
	             }
	             else{
	             hm.put(arr[i],1);
	             }
	         }
	        
	             if(hm.containsValue(1)){
	               ;
	             }
	        
	         return 0;
	    }
		
			

 public static void main(String[] args) {
	 Scanner sc=new Scanner(System.in);
		String3 obj=new String3();
		System.out.println("Enter Question No");
		int no=sc.nextInt();
		sc.nextLine();
		switch(no) {
		case 1:
			System.out.println("Enter the String");
			String s1=sc.nextLine();
		    System.out.println(obj.longestPrefixSuffix(s1));
		    break;
		    
		case 2:
			System.out.println("Enter the String");
			String s2=sc.nextLine();
			System.out.println("Enter the String");
			String s2s=sc.nextLine();
			System.out.println("enter the kvalue");
			int k=sc.nextInt();
			System.out.println(obj.areKAnagrams(s2, s2s, k));
			break;
			
		case 3:
			System.out.println("Enter the String");
			String s3=sc.nextLine();
		    System.out.println(obj.longestUniqueSubsttr(s3));
		    break;
			
			
		}
		int[] a= {-1, 2, -1, 3, 2};
		//System.out.println(firstNonRepeat(a,5));
		//System.out.println(findsum(a,5));
		//rearrange(a,9);
		//System.out.println(minDist(a,78,68,27));
		//System.out.println(alter(a,7));
		//int n=sc.nextInt();
		//countAndSay(n);
//		ArrayList<String> B=new ArrayList<String>();
//		for(int i=0;i<n;i++) {
//			String s=sc.next();
//			B.add(s);
//			
//		}
		//System.out.println("enter string");
		//String A=sc.nextLine();
		//number(A);
		//System.out.println("enter string");
		//String B=sc.nextLine();
		//System.out.println(Balanced(A));
	//	longestPreSuf(A);
	//System.out.println(find_permutation(A));
		//removePalindrome(A);
//		nonDuplicate(A);
	//	System.out.println(encoding(A));
	//	countWords(A);
		//reverseVowel(A);
     //System.out.println(parenthesis(A));
	//	System.out.println("enter string");
     //	String B=sc.nextLine();
     //	magicalString(A,B);
     //	System.out.println("enter string");
     	//String C=sc.nextLine();
		
		
		String[] A= {"He is good bad boy","He is normal good bad boy"};
     	System.out.println(commonFrag(A));
	//	pairSub(A,B);
		//System.out.println(permutationn(A,B));
	//	rotated2(A,B);
		//System.out.println(isomarphic(A,B));
		//romanInteger(A);
	//	removeChar(A,B);
	//	System.out.println(countWays(A));
		//permutation(A);
		//wordBreak(B,A);
	}


 
}
