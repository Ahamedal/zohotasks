package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Array1 {

public int[] smallerNumbersThanCurrent(int[] nums) {
       int[] smaller=new int[nums.length];
       for(int i=0;i<nums.length;i++){
           int count=0;
           for(int j=0;j<nums.length;j++){
               if(i!=j&&nums[j]<nums[i]){
                   count++;
               }
            }
           smaller[i]=count;
       }
       
      return smaller;
   }

public long maxSubarraySum(int arr[], int n){
       
       // Your code here
       int last=arr[0];
       int max=arr[0];
       for(int i=1;i<n;i++){
           last=Math.max(arr[i],last+arr[i]);
           max=Math.max(max,last);
       }
       return max;
       
   }

public  int[] convertToWave(int arr[], int n){
       
       // Your code here
       for(int i=0;i<arr.length;i++){
           if(i<arr.length-1&&(arr[i+1]>arr[i])){
               int temp=arr[i];
               arr[i]=arr[i+1];
               arr[i+1]=temp;
               i++;
           }
       }
       return arr;
       
   }

public ArrayList<Long> alternateSort(long arr[] ,int N)
   {
       
       // Your code goes here
       ArrayList<Long> ans=new ArrayList<>();
       Arrays.sort(arr);
       int j=arr.length-1;
       for(int i=0;i<N;i++)
       {
           ans.add(arr[j]);

           ans.add(arr[i]);
           j--;
       }
       return ans;
       
   }

public int majorityElement(int a[], int size)
   {
       // your code here
        int ans=-1;
   // your code here
   Arrays.sort(a);
   for(int i=0;i<a.length;i++){
       int count=1;
     
        while(i<size-1&&a[i]==a[i+1]){
            count++;
            i++;
       }
     
       ans=Math.max(ans,count);
      if(count>size/2){
          return a[i];
      }
   }
   return -1;
   }

public int searchElement(int A[], int key)
   {
       // Complete this function
        int n= A.length;
       for(int i=0;i<n;i++){
           if(A[i]==key){
              return i;

           }
         
       }
       return  -1;
   }

public long minValueToBalance(long a[] ,int n)
   {
       long sum1=0;
       long sum2=0;
       
    for(int i=0;i<n/2;i++){
        sum1=sum1+a[i];
    }
    for(int i=n/2;i<n;i++){
        sum2=sum2+a[i];
    }
    if(sum1>sum2){
        return sum1-sum2;
    }
    else{
        return sum2-sum1;
    }
   }

public int[] shuffle(int[] nums, int n) {
       int[] arr=new int[n+n];
       int j=n;
       int k=0;
    for(int i=0;i<n;i++){
     arr[k++]=nums[i];
     
     arr[k++]=nums[j];
     
        j++;
    }
       return arr;
   }

public int numPairs(int[] nums) {
       int count=0;
       for(int i=0;i<nums.length;i++){
           for(int j=i+1;j<nums.length;j++){
               if(nums[i]==nums[j]&&i<j){
                   count++;
               }
           }
       }
       return count;
   }

public int minimum_difference(int[] arr)
   {
       // code here
       Arrays.sort(arr);
       int ans=Integer.MAX_VALUE;
      for(int i=0;i<arr.length-1;i++){
       
         int diff=Math.abs(arr[i]-arr[i+1]);
         if(diff<ans){
             ans=diff;
         }
         
      }
      return ans;
   }

public ArrayList<Integer> leaders(int arr[], int n){
       // Your code here
     
   ArrayList<Integer> list=new ArrayList<>();
   int max=arr[arr.length-1];
   list.add(max);
       for(int i=n-2;i>=0;i--){
           
           if(max<=arr[i]){
               max=arr[i];
               list.add(arr[i]);
           }
       }
    Collections.reverse(list);
    return list;
   }

public int minDist(int a[], int n, int x, int y) {
       // code here
       int ans=Integer.MAX_VALUE;
       int xx=-1;
       int yy=-1;
      for(int i=0;i<n;i++){
         if(a[i]==x){
            xx=i;
         }
         else if(a[i]==y){
            yy=i;  
         }
         if(xx>-1&&yy>-1){
             ans=Math.min(ans,Math.abs(xx-yy));
         }
         
      }
      if(ans==Integer.MAX_VALUE){
          return -1;
      }
      return ans;
   }
public int[] rearrange(int arr[], int n) {
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
        int k=0;
      for(int i=0;i<n;i++){
          if(pos.size()!=0){
             arr[k++]=pos.get(0);
              pos.remove(pos.get(0));
          }
          if(neg.size()!=0){
         arr[k++]=neg.get(0);
         neg.remove(neg.get(0));
          }
      }
      return arr;
   }
public boolean findSumWith0(int arr[],int n)
   {
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
public int firstNonRepeating(int arr[], int n)
   {
       // Complete the function
       Map<Integer,Integer> hm=new HashMap<>();
       for(int i=0;i<n;i++){
           if(hm.containsKey(arr[i])){
               hm.put(arr[i],hm.get(arr[i])+1);
           }
           else{
           hm.put(arr[i],1);
           }
       }
       for(int i=0;i<n;i++){
           if(hm.get(arr[i])==1){
               return arr[i];
           }
       }
       return 0;
   }

public int findMin(int arr[], int n)
   {
       //complete the function here
      int temp=arr[0];
      for(int i=0;i<n;i++){
          if(temp>arr[i]){
              temp=arr[i];
          }
      }
      return temp;
   }

public int kthSmallest(int[] arr, int k)
    {
        //Your code here
        Arrays.sort(arr);
        return arr[k-1];
    }
public int getPairsCount(int[] arr, int n, int k) {
       // code here
     int count=0;
       Map<Integer,Integer> map=new HashMap<>();
       for(int i=0;i<n;i++){
         if(map.containsKey(k-arr[i])){
             count=count+map.get(k-arr[i]);
         }
         if(map.containsKey(arr[i])){
             map.put(arr[i],map.get(arr[i])+1);
         }
         else{
             map.put(arr[i],1);
         }
           
       }
     
       return count;
   }
public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
Array1 obj=new Array1();
System.out.println("Enter Quesno");
int no=sc.nextInt();
sc.nextLine();
switch(no) {
case 1:
int t = sc.nextInt();
         sc.nextLine();
  for(int i = 0; i < t; i++){
       int n = sc.nextInt();
 int d = sc.nextInt();
sc.nextLine();
 int[] arr = new int[n];
   
 for(int index = 0; index < n; index++){
     arr[index] = sc.nextInt();
       }  
  for(int j=d;j<arr.length;j++){
      System.out.print(arr[j]+" ");
  }
 
  for(int k=0;k<d;k++){
      System.out.print(arr[k]+" ");
  }
 
  System.out.println()  ;
 }  
 break;
 
case 2:
System.out.println("How many Integer do you want");
int n2=sc.nextInt();
int[] arr2=new int[n2];
for(int i=0;i<n2;i++) {
System.out.println("Enter Number");
arr2[i]=sc.nextInt();
}
System.out.println(Arrays.toString(obj.smallerNumbersThanCurrent(arr2)));
break;

case 3:
System.out.println("How many Integer do you want");
int n3=sc.nextInt();
int[] arr3=new int[n3];
for(int i=0;i<n3;i++) {
System.out.println("Enter Number");
arr3[i]=sc.nextInt();
}

System.out.println(obj.maxSubarraySum(arr3, n3));
break;

case 4:
System.out.println("How many Integer do you want");
int n4=sc.nextInt();
int[] arr4=new int[n4];
for(int i=0;i<n4;i++) {
System.out.println("Enter Number");
arr4[i]=sc.nextInt();
}

int[] ans1 = obj.convertToWave(arr4, n4);
        for (int i = 0; i < n4; i++) {
            System.out.print(ans1[i] + " ");
        }
        System.out.println();
break;

case 5:
System.out.println("How many Integer do you want");
int n5=sc.nextInt();
long[] arr5=new long[n5];
for(int i=0;i<n5;i++) {
System.out.println("Enter Number");
arr5[i]=sc.nextLong();
}
ArrayList<Long> ans = obj.alternateSort(arr5, n5);
         for (int i = 0; i < n5; i++) {
             System.out.print(ans.get(i) + " ");
         }
         System.out.println();
         break;
         
case 6:
System.out.println("How many Integer do you want");
int n6=sc.nextInt();
int[] arr6=new int[n6];
for(int i=0;i<n6;i++) {
System.out.println("Enter Number");
arr6[i]=sc.nextInt();
}
System.out.println(obj.majorityElement(arr6, n6));
break;

case 7:
break;

case 8:
System.out.println("Enter the arraysize");
int noo=sc.nextInt();
int[] arr8=new int[noo];
for(int i=0;i<noo;i++) {
System.out.println("Enter number");
arr8[i]=sc.nextInt();
}
System.out.println("enter searchElement");
int key=sc.nextInt();
System.out.println(obj.searchElement(arr8, key));
break;

case 9:
System.out.println("How many Integer do you want");
int n9=sc.nextInt();
long[] arr9=new long[n9];
for(int i=0;i<n9;i++) {
System.out.println("Enter Number");
arr9[i]=sc.nextLong();
}
System.out.println(obj.minValueToBalance(arr9, n9));
break;

case 10:
System.out.println("How many Integer do you want");
int n10=sc.nextInt();
int[] arr10=new int[n10];
for(int i=0;i<n10;i++) {
System.out.println("Enter Number");
arr10[i]=sc.nextInt();
}

System.out.println(Arrays.toString(obj.shuffle(arr10, n10)));
       
break;

case 11:
System.out.println("How many Integer do you want");
int n11=sc.nextInt();
int[] arr11=new int[n11];
for(int i=0;i<n11;i++) {
System.out.println("Enter Number");
arr11[i]=sc.nextInt();
}
System.out.println("enter key value");
int key3=sc.nextInt();
System.out.println(obj.getPairsCount(arr11, n11, key3));
       
break;

case 12:
System.out.println("How many Integer do you want");
int n12=sc.nextInt();
int[] arr12=new int[n12];
for(int i=0;i<n12;i++) {
System.out.println("Enter Number");
arr12[i]=sc.nextInt();
}

System.out.println(obj.numPairs(arr12));
break;

case 13:
System.out.println("How many Integer do you want");
int n13=sc.nextInt();
int[] arr13=new int[n13];
for(int i=0;i<n13;i++) {
System.out.println("Enter Number");
arr13[i]=sc.nextInt();
}
System.out.println(obj.minimum_difference(arr13));
break;

case 14:
System.out.println("How many Integer do you want");
int n14=sc.nextInt();
int[] arr14=new int[n14];
for(int i=0;i<n14;i++) {
System.out.println("Enter Number");
arr14[i]=sc.nextInt();
}

ArrayList<Integer> ans2 = obj.leaders(arr14, n14);
        for (int i = 0; i < ans2.size(); i++) {
            System.out.print(ans2.get(i)+ " ");
        }
        System.out.println();
break;

case 15:
System.out.println("How many Integer do you want");
int n15=sc.nextInt();
int[] arr15=new int[n15];
for(int i=0;i<n15;i++) {
System.out.println("Enter Number");
arr15[i]=sc.nextInt();
}
System.out.println("Enter x value");
int x=sc.nextInt();
System.out.println("Enter y value");
int y=sc.nextInt();
System.out.println(obj.minDist(arr15, n15, x, y));
break;

case 16:
System.out.println("How many Integer do you want");
int n16=sc.nextInt();
int[] arr16=new int[n16];
for(int i=0;i<n16;i++) {
System.out.println("Enter Number");
arr16[i]=sc.nextInt();
}
int[] ans3=obj.rearrange(arr16, n16);
for (int i = 0; i < n16; i++) {
           System.out.print(ans3[i]+ " ");
       }
       System.out.println();
       
   break;
   
case 17:
System.out.println("How many Integer do you want");
int n17=sc.nextInt();
int[] arr17=new int[n17];
for(int i=0;i<n17;i++) {
System.out.println("Enter Number");
arr17[i]=sc.nextInt();
}
System.out.println(obj.findSumWith0(arr17, n17));
break;

case 18:
System.out.println("How many Integer do you want");
int n18=sc.nextInt();
int[] arr18=new int[n18];
for(int i=0;i<n18;i++) {
System.out.println("Enter Number");
arr18[i]=sc.nextInt();
}
System.out.println(obj.firstNonRepeating(arr18, no));
break;

case 19:
System.out.println("how many Integer do you want");
int nn=sc.nextInt();
int[] arr19=new int[nn];
for(int i=0;i<nn;i++) {
System.out.println("Enter number");
arr19[i]=sc.nextInt();
}
System.out.println(obj.findMin(arr19, nn));
break;

case 20:
System.out.println("How many Integer do you want");
int n20=sc.nextInt();
int[] arr20=new int[n20];
for(int i=0;i<n20;i++) {
System.out.println("Enter Number");
arr20[i]=sc.nextInt();
}
System.out.println("Enter key number");
int key2=sc.nextInt();
System.out.println(obj.kthSmallest(arr20,  key2));

}
}

}


