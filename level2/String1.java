package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class String1 {
	public void printPattern(String s) {
		
		int a = 0;
		a = s.length() / 2;
		char[] c = s.toCharArray();
		String s2 = "";
		for (int i = a; i < s.length(); i++) {
			s2 = s2 + c[i];
			System.out.print(s2 + "$" + " ");
		}
		for (int i = 0; i < a; i++) {
			s2 = s2 + c[i];
			System.out.print(s2 + "$" + " ");
		}

	}
	 public int wordBreak(String A, ArrayList<String> B )
	    {
	        
	         int len=A.length();
	      
	       boolean[] dp=new boolean[len+1];
	       dp[0]=true;
	       for(int i=1;i<=A.length();i++){
	           for(int j=0;j<i;j++){
	               if(dp[j]&&B.contains(A.substring(j,i))){
	                   dp[i]=true;
	                   break;
	               }
	           }
	       }
	       if(dp[len]){
	           return 1;
	       }
	       return 0;
	    }
	 
	 public String remainingString(String S, char ch, int count) {
	 
	        int noOfTimes=0;
	        if(count==0){
	            return S;
	        }
	        for(int i=0;i<S.length();i++){
	            if(S.charAt(i)==ch){
	                noOfTimes++;
	            }
	            if(count==noOfTimes){
	                if(i==S.length()-1){
	                    return "Empty string";
	                }
	                return S.substring(i+1);
	            }
	        }
	        return "Empty string";
	    }
	 
	 public int totalDecoding(String str)
	    {
	        char[] c=str.toCharArray();
	        int n=str.length();
	        int[] p=new int[n+1];
	        if(c[0]=='0'){
	            return 0;
	        }
	        p[0]=1;
	        p[1]=1;
	        for(int i = 1; i < n; i++){
					if(c[i] == '0' && c[i-1] > '2')
						return 0;
				}
	        for(int i=2;i<=n;i++){
	            p[i]=0;
	            if(c[i-1]>'0'){
	                p[i]=p[i-1];
	            }   
	            if(c[i-2]=='1'||(c[i-2]=='2'&&c[i-1]<'7')){
	                p[i]=p[i]+p[i-2];
	            
	            }
	        }
	    return p[n];
	    }
	 

	  public String reverseEachWords(String S)
	    {
	        // your code here
	        String ans="";
			 String a="";
		        for(char g:S.toCharArray()){
		            if(g=='.'){
		            	
		               ans=ans+a+".";
		               a="";
		             
		            }
		            else  a=g+a;
		            
		        }
		        ans=ans+a;
		        return ans;
	    }
	  
	 public String reverseWithSpacesIntact(String S)
	    {
	        // your code here
	        char[] result=new char[S.length()];
	        int j=S.length()-1;
	        for(int i=0;i<S.length();i++){
	            if(S.charAt(i)==' '){
	                result[i]=' ';
	            }
	            if(S.charAt(i)!=' '){
	                while(S.charAt(j)==' '){
	                    j--;
	                }
	                result[j]=S.charAt(i);
	                j--;
	            }
	        }
	       return String.valueOf(result);
	    }
	 
	 public String crossPattern(String S){
	        
	        // code here
	        StringBuilder s2=new StringBuilder();
	       
	       // char[] l=new char[S.length()*S.length()];
	    
	   for(int i=0;i<S.length();i++) {
		for(int j=0;j<S.length();j++) {
		
			if(i==j) {
				s2.append(S.charAt(i));
			
			   
			   
				
			}
		else if(i==S.length()-1-j) {
				s2.append(S.charAt(j));

			}
			else {
				s2.append(' ');
		
			}
		
		}
		
		

	}
	  return s2.toString();      
	    }
	 
	public boolean kPangram(String str, int k) 
	    {
	        // code here
	        if(str.replaceAll(" ","").length()<26){
	            return false;
	        }
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
		        if(k+count>=26){
		            return true;
		        }
		      return false;
	    }
	public int maxChars(String s)
    {
        //code here
         char[] c=s.toCharArray();

        int k=-1;
        for(int i=0;i<s.length();i++){
        
              
            int start=s.indexOf(s.charAt(i));
            int last=s.lastIndexOf(s.charAt(i));
               
               k=Math.max(k,last-start-1);
             }
          
        return k;
    }
	public List<String> find_permutation(String S) {
        // Code here
        String prefix="";
             List<String> list=new ArrayList<>() ;
             permut(prefix,S,list);
             Collections.sort(list);
             return list;
    }
       public static void permut(String prefix,String strr,List list) {

		if(strr.length()==0) {
			list.add(prefix);
			prefix="";
			//return;
		}
	
	     for(int i=0;i<strr.length();i++) {
	         //System.out.println(i);
	    	 char ch=strr.charAt(i);
	    //	System.out.println(i+" "+ch);
	    	 
	    	 permut(prefix+ch,strr.substring(0, i)+strr.substring(i+1),list);
	     
		}
    }
     
       static int[] x={-1,-1,-1,0,0,1,1,1};
       static int[] y={-1,0,1,-1,1,-1,0,1};
       public int[][] searchGrid(char[][] grid, String word)
       {
         ArrayList<ArrayList<Integer>> list = new ArrayList<>();
           
           for(int row=0;row<grid.length;row++)
           {
               for(int col=0;col<grid[0].length;col++)
               {
                   if(search(grid,row,col,word))
                   {
                       ArrayList<Integer> num=new ArrayList<>();
                       num.add(row);
                       num.add(col);
                       list.add(num);
                   }
               }
           }
           
           int[][] result= new int[list.size()][2] ;
           
           for(int i=0;i<result.length;i++)
           {
               result[i][0]=list.get(i).get(0);
               result[i][1]=list.get(i).get(1);
           }
           
           return result;
           
       }
       
       static boolean search(char[][] grid,int row,int col,String word)
       {
           
           if(grid[row][col]!=word.charAt(0))
           {
               return false;
           }
           
           for(int dir=0;dir<8;dir++)
           {
               int k,rd=row+x[dir],cd=col+y[dir];
               
               int wordLen=word.length();
               
               for(k=1;k<wordLen;k++)
               {
                   
                   if(rd>=grid.length || rd<0|| cd>=grid[0].length|| cd<0)
                   {
                       break;
                   }
                   
                   if(grid[rd][cd]!=word.charAt(k))
                   {
                       break;
                   }
                   rd +=x[dir];
                   cd +=y[dir];
               }
               
               if(k==wordLen)
               {
                   return true;
               }
           }
           
           
           return false;
       }
       public String shufflesString(String s, int[] indices) {
           String s2="";
           for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                  if(i==indices[j]){
                  s2=s2+s.charAt(j) ;   
               }
            }
         
           }
           return s2;
       }
       public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
           String s1="";
           String s2="";
           for(int i=0;i<word1.length;i++){
               s1=s1+word1[i];
           }
           for(int j=0;j<word2.length;j++){
               s2=s2+word2[j];
           }
           if(s1.equals(s2)){
               return true;
           }
           return false;
           
       }
       public List<List<String>> Anagrams(String[] string_list) {
           // Code here
         List<List<String>> result=new ArrayList<>();
               Map<String,List<String>> map=new HashMap<>();
                List<String> list=null;
   		for(String str:string_list) {
   			char[] arr=str.toCharArray();
   			Arrays.sort(arr);
   			String key=new String(arr);
   			if(map.get(key)==null){
   			   list=new ArrayList<>();
   			    map.put(key,list);
   			    list.add(str);
   			}else{
   			    map.get(key).add(str);
   			}
   		      
   		
   		}
   		result.addAll(map.values());
   		return result;
       }
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String1 obj=new String1();
		System.out.println("Enter Question No");
		int no=sc.nextInt();
		sc.nextLine();
		switch(no) {
		case 1:
			System.out.println("Enter the String");
			String s1=sc.next();
			obj.printPattern(s1);
			break;
		
		case 2:
			System.out.println("Enter the String");
			String A=sc.next();
			ArrayList<String> B=new ArrayList<String>();
			System.out.println("how many strings do you want");
			int n=sc.nextInt();
			for(int i=0;i<n;i++) {
				String s=sc.next();
				B.add(s);
				}
			System.out.println(obj.wordBreak(A, B));
			break;
			
		case 3:
			System.out.println("Enter the String");
			String s3=sc.next();
			System.out.println("Enter the charcter");
			char c=sc.next().charAt(0);
			System.out.println("Enter the count");
			int count=sc.nextInt();
		    sc.nextLine();
		    System.out.println(obj.remainingString(s3, c, count));
		    break;
		    
		case 4:
			System.out.println("Enter the String");
			String s4=sc.next();
		    System.out.println(obj.totalDecoding(s4));
		    break;
		    
		case 5:
			System.out.println("Enter the String");
			String s5=sc.next();
		    System.out.println(obj.reverseEachWords(s5));
		    break;
		    
		case 6:
			System.out.println("Enter the String");
			String s6=sc.next();
		    System.out.println(obj.reverseWithSpacesIntact(s6));
		    break;
		 
		case 7:
			System.out.println("Enter the String");
			String s7=sc.next();
		    System.out.println(obj.crossPattern(s7));
		    break;
		    
		case 8:
			System.out.println("Enter the string");
			String sss=sc.next();
			System.out.println("Enter the k");
			int k=sc.nextInt();
			sc.nextLine();
			System.out.println(obj.kPangram(sss, k));
			break;
			
		case 9:
			System.out.println("Enter the String");
			String s9=sc.next();
		    System.out.println(obj.maxChars(s9));
		    break;
		    
		case 10:
			System.out.println("Enter the String");
			String s10=sc.next();
		    System.out.println(obj.find_permutation(s10));
		    break;
		
		case 11:
			char[][] cc={{'a','b','c'},{'d','r','f'},{'g','h','i'}};
			System.out.println("Enter the String");
			String s11=sc.next();
		    System.out.println(obj.searchGrid(cc, s11));
		    break;
		    
		case 12:
			int a[]= {4,5,6,7,0,2,1,3};
			System.out.println("Enter the String");
			String s12=sc.next();
		    System.out.println(obj.shufflesString(s12, a));
		    break;
		
		case 13:
			String[] word1= {"ab","c"};
			String[] word2= {"a","bc"};
			System.out.println(obj.arrayStringsAreEqual(word1, word2));
			break;
			
		case 14:
			String[] words= {"act","god","tac","cat"};
			System.out.println(obj.Anagrams(words));
			break;
			
		}
	}

}
