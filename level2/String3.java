package level2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
 }
}
