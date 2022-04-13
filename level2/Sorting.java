package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Sorting {
	  public int minSwaps(int nums[])
	    {
	        // Code here
	        int n=nums.length;
	        int count=0;
	        int small=0;
	        for(int i=0;i<n;i++){
	            small=nums[i];
	            int in=i;
	            for(int j=i+1;j<n;j++){
	                if(nums[j]<small){
	                    small=nums[j];
	                    in=j;
	                }
	            }
	            if(nums[i]!=small){
	                int temp=nums[i];
	                nums[i]=small;
	                nums[in]=temp;
	                count++;
	            }
	        }
	        return count;
	    }
	  public static int kthSmallest(int[] arr, int l, int r, int k) 
	    { 
	        //Your code here
	        
	        // for(int i=0;i<arr.length;i++){
	        //     for(int j=i+1;j<arr.length;j++){
	        //         if(arr[i]>arr[j]){
	        //             int temp=arr[i];
	        //             arr[i]=arr[j];
	        //             arr[j]=temp;
	        //         }
	        //     }
	        // }
	        int low=0;
	        int high=arr.length-1;
	        sorting(arr,low,high);
	        return arr[k-1];
	    } 
	  
	 
	    public static void sorting(int[] arr,int low,int high){
	        if(low>=high){
	            return;
	        }
	        int ind=(low+high)/2;
	        int pivo=arr[ind];
	        int start=low;
	        int end=high;
	        while(start<=end){
	            while(arr[start]<pivo){
	                start++;
	                
	            }
	            while(arr[end]>pivo){
	                end--;
	            }
	            if(start<=end){
	                int temp=arr[start];
	                arr[start]=arr[end];
	                arr[end]=temp;
	                start++;
	                end--;
	            }
	        }
	        sorting(arr,low,end);
	        sorting(arr,start,high);
	        
	    }
	    
	    public static boolean isAnagram(String a,String b)
	    {
	        
	        // Your code here
	        if(a.length()!=b.length()){
	            return false;
	        }
	        char[] c=a.toCharArray();
	        char[] c11=b.toCharArray();
	        Arrays.sort(c);
	        Arrays.sort(c11);
	        for(int i=0;i<a.length();i++){
	            if(c[i]!=c11[i]){
	                return false;
	            }
	        }
	        return true;
	    }
	    
	    public static boolean check(long A[],long B[],int N)
	    {
	        //Your code here
	        Arrays.sort(A);
	        Arrays.sort(B);
	        if(Arrays.equals(A,B)){
	            return true;
	        }
	        return false;
	    }
	    
	    boolean arraySortedOrNot(int[] arr, int n) {
	        // code here
	        for(int i=0;i<n-1;i++){
	            if(arr[i]>arr[i+1]){
	                return false;
	            }
	        }
	        return true;
	    }
	    
	    public static int closestToZero (int arr[], int n)
	    {
	        // your code here
	        int min=Integer.MAX_VALUE;
	        for(int i=0;i<n;i++){
	            for(int j=i+1;j<n;j++){
	                int diff=Math.abs(0-(arr[i]+arr[j]));
	                if(diff<Math.abs(min)){
	                    min=arr[i]+arr[j];
	                }
	            }
	        }
	        return min;
	    }
	  public void merge(int ar1[], int ar2[], int n, int m) {
	        // code here
	      int[] join=new int[n+m];
	      int i=0;
	      int j=0;
	      int k=0;
	      while(i<ar1.length&&j<ar2.length){
	          if(ar1[i]<ar2[j]){
	              join[k++]=ar1[i++];
	          }
	          else{
	              join[k++]=ar2[j++];
	          }
	      }
	      
	      while(i<ar1.length){
	          join[k++]=ar1[i++];
	      }
	      while(j<ar2.length){
	          join[k++]=ar2[j++];
	      }
	   
	      for(int h=0;h<n;h++)  {
	          ar1[h]=join[h];
	      }
	      int a=n;
	      for(int l=0;l<m;l++){
	          ar2[l]=join[a++];
	      }
	    }
	
	  static int toyCount(int N, int K, int arr[])
	    {

	        Arrays.sort(arr);
	        int sum=0;
	        int count=0;
	        for(int i=0;i<arr.length;i++){
	            sum=sum+arr[i];
	            if(sum<=K){
	                count++;
	            }
	            else{
	                break;
	            }
	        }
	        return count;
	    }
	  
	  void bitonicGenerator(long arr[], int n)
	    {
	      int odd=1;
	      int even=n-1;
	      int mid=0;
	      if(n%2==0){
	          even=n-2;
	      }
	      while(odd<even){
	          long temp=arr[odd];
	          arr[odd]=arr[even];
	          arr[even]=temp;
	          odd=odd+2;
	          even=even-2;
	      }
	     
	      if(n%2==0){
	          mid=n/2;
	      }
	     else{
	         mid=(n/2)+1;
	     }
	     long[] l=new long[mid];
	     for(int i=0;i<mid;i++){
	         l[i]=arr[i];
	     }
	     Arrays.sort(l);
	     long[] v=new long[n-mid];
	     int i=0;
	     for(int k=mid;k<n;k++){
	         v[i++]=arr[k];
	     }
	     Arrays.sort(v);
	     
	   
	     for(int e=0;e<mid;e++){
	         arr[e]=l[e];
	     }
	     int k=mid-1;
	     if(n%2!=0){
	         k=mid-2;
	     }
	     for(int a=mid;a<n;a++){
	         arr[a]=v[k--];
	         
	     }
	    }
	  
	  static ArrayList<Integer> candyStore(int candies[],int N,int K){
	        // code here
	        Arrays.sort(candies);
	        int min=0;
	        int max=0;
	        int group=N/(K+1);
	        if(N%(K+1)!=0){
	            group=group+1;
	        }
	        for(int i=0;i<group;i++){
	            min=min+candies[i];
	        }
	        int iii=0;
	        for(int i=N-1;i>=(N-group);i--){
	            max=max+candies[i];
	          
	        }
	        ArrayList<Integer> a=new ArrayList<>();
	        a.add(min);
	        a.add(max);
	        return a;
	    }
	  
	  static void sortABS(int arr[], int n,int k)
	    {
	        // add your code here
	        TreeMap<Integer,List<Integer>> actualMap=new TreeMap<>();
	      
	      for(int i=0;i<n;i++)
	      {
	          
	          int difference=Math.abs(arr[i]-k);
	          
	          List<Integer> actualList=actualMap.get(difference);
	          
	          if(actualList==null)
	          {
	              actualList=new ArrayList<>();
	              actualMap.put(difference,actualList);
	          }
	          
	             actualList.add(arr[i]);
	          
	      }
	      
	      int temp=0;
	      
	      for(Integer key:actualMap.keySet())
	      {
	          
	            List oneList=actualMap.get(key);
	            
	            int size=oneList.size();
	            
	            for(int i=0;i<size;i++)
	            {
	                arr[temp]=(int)oneList.get(i);
	                temp++;
	            }
	          
	          
	      }
	      
	    


	        // int a=0;
	        // int b=0;
	        // for(int i=0;i<n;i++){
	        //     for(int j=i+1;j<n;j++){
	        //     a=Math.abs(k-arr[i]);
	        //     b=Math.abs(k-arr[j]);
	        //     if(a>b){
	        //         int temp=arr[i];
	        //         arr[i]=arr[j];
	        //         arr[j]=temp;
	        //     }
	        //     }
	        // }
	    }
	 public static void main(String[] args) {
		 int a[]= {10, 5, 3, 9, 2};
		 //System.out.println(closestToZero(a,3));
		// sortABS(a,5,7);
	 }
}
