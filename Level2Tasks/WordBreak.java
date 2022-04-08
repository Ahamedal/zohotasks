package Level2Tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class WordBreak {
	public static void wordBreak(ArrayList<String> B,String A) {
		int l=A.length();
		boolean[] dp=new boolean[l+1];
		dp[0]=true;
		for(int i=1;i<=l;i++) {
			for(int j=0;j<i;j++) {
				if(dp[j]&&B.contains(A.substring(j,i))) {
					dp[i]=true;
					break;
				}
			}
		}
		System.out.println(dp[l]);
		
	}
	public static void printAnagram(String[] s) {
		Map<String,List<String>> map=new HashMap<>();
		for(String str:s) {
			char[] arr=str.toCharArray();
		
		}
		
	}
	public static void permutation(String S) {
		 String prefix="";
         List<String> list=new ArrayList<>() ;
         permut(prefix,S,list);
         Collections.sort(list);
         System.out.println(list);
}
   public static void permut(String prefix,String strr,List list) {
	   Set a=new HashSet();
	   char[] ch=strr.toCharArray();
	   for(int i=0;i<strr.length();i++) {
		   for(int j=0;j<strr.length();j++) {
		   if(i!=j) {
			   char temp=ch[i];
			   ch[i]=ch[j];
			   ch[j]=temp;
		   
	        list.add(String.valueOf(ch));
	        if(j<strr.length()-1) {
	        	char temp1=ch[j];
				   ch[j]=ch[j+1];
				   ch[j+1]=temp1;
	        }
	        list.add(String.valueOf(ch));
	        if(i<strr.length()-1) {
	        	char temp1=ch[i];
				   ch[i]=ch[i+1];
				   ch[i+1]=temp1;
	        }
	        list.add(String.valueOf(ch));
	       
		   } 
		   
		   }
		   
	   }
	  a.addAll(list) ;
	  list.clear();
	  list.addAll(a);
  
//	if(strr.length()==0) {
//		list.add(prefix);
//		prefix="";
//		//return;
//	}
//	
//     for(int i=0;i<strr.length();i++) {
//    	 char ch=strr.charAt(i);
//    //	System.out.println(i+" "+ch);
//    	 
//    	 permut(prefix+ch,strr.substring(0, i)+strr.substring(i+1),list);
//     }
	
	}
   public static int countWays(String s) {
	   char[] c=s.toCharArray();
	   int[] p=new int[s.length()+1];
	   p[0]=1;
	   p[1]=1;
	   if(c[0]=='0') {
		   return 0;
	   }
	   for(int i=0;i<s.length();i++) {
		   if(c[i]=='0'&&c[i-1]>'2') {
			   return 0;
		   }
	   }
	   for(int i=2;i<=s.length();i++) {
		   p[i]=0;
		   if(c[i-1]>'0') {
			   p[i]=p[i-1];
		   }
		   if((c[i-2]=='1'||c[i-2]=='2')&&c[i-1]<'7') {
			   p[i]=p[i]+p[i-2];
		   }
	   }
	   return p[s.length()];
   }
   public static void removeChar(String s1,String s2) {
	   for(int i=0;i<s1.length();i++) {
		   for(int j=0;j<s2.length();j++) {
			   if(s1.charAt(i)==s2.charAt(j)) {
				   s1=s1.replace(String.valueOf(s1.charAt(i)), "");
			   }
		   }
	   }
	   System.out.println(s1);
   }
   public static void romanInteger(String s1) {
	   Map<String,Integer> map=new HashMap<>();
       map.put("I",1);
       map.put("V",5);
       map.put("X",10);
       map.put("L",50);
       map.put("C",100);
       map.put("D",500);
       map.put("M",1000);
       map.put("IV",4);
       map.put("IX",9);
       map.put("XL",40);
       map.put("XC",90);
       map.put("CD",400);
       map.put("CM",900);
       int result=0;
       String c=null;
       int i=0;
       while(i<s1.length()) {
    	   char a=s1.charAt(i);
    	  // char b=s1.charAt(i);
    	   if(i<s1.length()-1) {
    		 char  b=s1.charAt(i+1);
    		 c=String.valueOf(a)+String.valueOf(b);
    		
    	   }
    	  
    	   if(map.containsKey(c)) {
    		   result=result+map.get(c);
    		   i=i+2;
    	   }
    	   else if(map.containsKey(String.valueOf(a))) {
    		   result=result+map.get(String.valueOf(a));
    		   i++;
    	   }
    	   else {
    		   i++;
    	   }
       }
       System.out.println(result);
   }
   public static boolean parenthesis(String s) {
	   Stack a=new Stack();
	   for(int i=0;i<s.length();i++) {
		   char ch=s.charAt(i);
		   if(ch=='('||ch=='{'||ch=='[') {
			   a.push(ch);
		   }
		   if(a.isEmpty()) {
			   return false;
		   }
		   switch(ch) {
		   case ')':
			   if(!a.peek().equals('(')) {
				   return false;
			   }
			   a.pop();
			   break;
		   case '}':
			   if(!a.peek().equals('(')) {
				   return false;
			   }
			   a.pop();
			   break;
		   case ']':
			   if(!a.peek().equals('(')) {
				   return false;
			   }
			   a.pop();
			   break;
		   }
	   }
	   if(a.isEmpty()) {
		   return true;
	   }
	   return false;
   }
    public static void countAndSay(int n) {
    	String a="1";
    	for(int i=1;i<n;i++) {
    		String next="";
    		int k=0;
    		while(k<a.length()) {
    			int no=1;
    			while(k<a.length()-1&&(a.charAt(k)==a.charAt(k+1))) {
    				no++;
    				k++;
    			}
    			next=next+Integer.toString(no)+a.charAt(k);
    			k++;
    		}
    		a=next;
    	}
    	System.out.println(a);
    }
    public static void reverseVowel(String s) {
    	 String s1="";
         
         for(int i=0;i<s.length();i++){
             if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'){
                 s1=s1+s.charAt(i);
             }
         }
         int j=s1.length()-1;
         for(int i=0;i<s.length();i++){
         if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'){
               s=s.replace(String.valueOf(s.charAt(i)),String.valueOf(s1.charAt(j)));
               j--;
             }
         }
         System.out.println(s);
    }
    public static void countWords(String s) {
    	String ans="";
    	for(int i=0;i<s.length();i++) {
    		int no=1;
    		
    		while(i<s.length()-1&&(s.charAt(i)==s.charAt(i+1))) {
    			no++;
    			i++;
    		}
    		ans=String.valueOf(Integer.toHexString(no))+s.charAt(i)+ans;
    	}
    	System.out.println(ans);
    }
    public static boolean isomarphic(String s1,String s2) {
    	Map<Character,Character> map11=new HashMap<>();
    	Map<Character,Character> map22=new HashMap<>();
    	for(int i=0;i<s1.length();i++) {
    		char a=s1.charAt(i);
    		char b=s2.charAt(i);
    		if((map11.containsKey(a)&&map11.get(a)!=b)||(map22.containsKey(b)&&map22.get(b)!=a)) {
    			return false;
    		}
    		map11.put(a, b);
    		map22.put(b, a);
    	}
    	return true;
    }
    public static void rotated2(String s1,String s2) {
    	String temp1="";
    	String temp2="";
    	temp1=temp1+s1.substring(0,2);
    	temp1=s1.substring(2)+temp1;
    	temp2=temp2+s1.substring(s1.length()-2, s1.length());
    	temp2=temp2+s1.substring(0,s1.length()-2);
    	if(temp1.equals(s2)||temp2.equals(s2)) {
    		System.out.println(true);
    	}
    	System.out.println(false);
    }
    public static boolean permutationn(String s1,String s2) {
    	
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
