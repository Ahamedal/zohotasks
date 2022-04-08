package Level2Tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Array2Tasks {
	public static void rotateOne(int[] a) {
		int temp=a[a.length-1];
		for(int i=a.length-1;i>0;i--) {
			a[i]=a[i-1];
		}
		a[0]=temp;
		//System.out.println(Arrays.toString(a));
	}
	public static void leftRotate(int[] a) {
		int temp=a[0];
		for(int i=0;i<a.length-1;i++) {
			a[i]=a[i+1];
		}
		a[a.length-1]=temp;
		//System.out.println(Arrays.toString(a));
	}
public static void misMatch(String[] ar1,String[] ar2) {
	String temp1="";
	String temp2="";
	for(int i=0;i<ar1.length;i++) {
		if(ar1[i].equals(ar2[i])){
			if(!temp1.equals("")) {
				System.out.print(temp1+","+temp2+",");
				temp1="";
				temp2="";
				
			}
		}
		else {
			temp1=temp1+ar1[i];
			temp2=temp2+ar2[i];
		}
		
	}
}
public static void allPair(int[] array1) {
	for(int i=0;i<array1.length;i++) {
		for(int j=i+1;j<array1.length;j++) {
			if(array1[i]+array1[j]==12) {
				System.out.println("("+array1[i]+","+array1[j]+")");
			}
		}
	}
}
public static void rotateLengthSize(int[] array1) {
	int d=array1.length;
	for(int i=0;i<d;i++) {
		rotateOne(array1);
	}
	System.out.println(Arrays.toString(array1));
}
public static void intersect(List<Integer> one,List<Integer> two) {
	List<Integer> intersect=new ArrayList<>();
	for(int i=0;i<one.size();i++) {
		if(one.contains(one.get(i))&&two.contains(one.get(i))) {
			intersect.add(one.get(i));
		}
	}
	System.out.println(intersect);
}
public static void except(List<Integer> one,List<Integer> two) {
	List<Integer> except=new ArrayList<>();
	for(int i=0;i<one.size();i++) {
		if(one.get(i)%2==0) {
			except.add(one.get(i));
		}
	}
	for(int i=0;i<two.size();i++) {
		if(two.get(i)%2!=0) {
			except.add(two.get(i));
		}
	}
	System.out.println(except);
}
public static void union(List<Integer> one,List<Integer> two) {
	List<Integer> unions=new ArrayList<>();
	
	List<Integer> intersect=new ArrayList<>();
	for(int i=0;i<one.size();i++) {
		if(!unions.contains(one.get(i))) {
			unions.add(one.get(i));
		}
	}
	for(int i=0;i<two.size();i++) {
		if(!unions.contains(two.get(i))) {
			unions.add(two.get(i));
		}
	}
	System.out.println(unions);
}
public static void printDuplicates(int[] array) {
	Arrays.sort(array);
	for(int i=0;i<array.length;i++) {
		int count=1;
		while(i<array.length-1&&array[i]==array[i+1]) {
			count++;
			i++;
		}
		System.out.println(array[i]+"-"+count);
	}
}
public static void increasingSubSequences(int[] array) {
	int max=0;
	int[] lis=new int[array.length];
	ArrayList a=new ArrayList();
	for(int i=0;i<array.length;i++) {
		lis[i]=1;
	}
	for(int i=1;i<array.length;i++) {
		for(int j=0;j<i;j++) {
			if(array[i]>array[j]&&lis[i]<lis[j]+1) {
				lis[i]=lis[j]+1;
			}
		}
	}
	for(int i=0;i<array.length;i++) {
		if(max<lis[i]) {
		max=lis[i];
		a.add(array[i]);
		}
	}
	System.out.println(a+" "+max);
}
public static void grandFather(Map<String,String> map,String person1,int level) {
	int count=0;
	int k=0;
	
	Set<String> key=map.keySet();
	String[] arr=new String[5];
	 arr[0]=person1;
	 
	 for(int i=0;i<level;i++) {
		 k=0;
	  
	    for(String p:key) {
	    	for(String person:arr) {
		 if(map.get(p).equals(person)) {
			arr[k++]=p;
			 count++;
		 }
	   }
	  }
	  		 
    }
	  
	  
	
	System.out.println(count);
}
public static boolean nonDecreasing(int[] array) {
	int count=0;
	for(int i=0;i<array.length;i++) {
		if(i<array.length-1&&array[i]>array[i+1]) {
			count++;
		}
	}
	if(count<=1) {
		return true;
	}
	return false;
}
public static void leftRotation(int[] a,int d) {
	for(int i=0;i<d;i++) {
		leftRotate(a);
	}
	System.out.println(Arrays.toString(a));
}
public static void multipl(int[] a) {
	int max=0;
	for(int i=0;i<a.length;i++) {
		for(int j=0;j<i;j++) {
			for(int k=0;k<j;k++) {
				if(a[i]*a[j]*a[k]>max) {
					max=a[i]*a[j]*a[k];
				}
			}
		}
	}
	System.out.println(max);
}
public static void sum(int a,int s) {
	String b="";
	int sum=0;
	int c=0;
   while(a>0) {
	   c=a%10;
	   sum=sum+c;
	   a=a/10;
   }
   if(sum==10) {
	   b=b+s;
   }
   else if(sum>9) {
     sum(sum,s);
   }
   else {
	   b=s+b+(10-sum);  
   }
 System.out.println(b);
}
public static int sums(int a) {
	int sum=0;
	
	 while(a>0) {
		 int  c=a%10;
		   sum=sum+c;
		   a=a/10;
	   }
	 return sum;
}
public static void ascendingsBasedSum(int[] a) {
	int max=0;
	int max1=0;
	for(int i=0;i<a.length;i++) {
		for(int j=i+1;j<a.length;j++) {
		max=sums(a[i]);
		max1=sums(a[j]);
		if(max>max1||(max==max1&&a[i]>a[j])) {
			int temp=a[i];
			a[i]=a[j];
			a[j]=temp;
		}
	}
	}
	System.out.println(Arrays.toString(a));
}
public static void minDiff(int[] a) {
	int min=Integer.MAX_VALUE;
	int temp1=0;
	int temp2=0;
	for(int i=0;i<a.length;i++) {
		for(int j=i+1;j<a.length;j++) {
			int diff=Math.abs(a[i]-a[j]);
			if(diff<min) {
				temp1=a[i];
				temp2=a[j];
				min=diff;
			}
			
		}
	}
	System.out.println(temp1+","+temp2);
}
public static void printArray(int[] a) {
	int rows=5;
	int k=1;
	for (int i = 1; i <= rows; i++)
    {
        k=i;
        for (int j = 1; j <= i; j++)
        {
            System.out.print(a[k-1] + " ");
            k = k + rows - j; 
        }
        System.out.println();
    }
//	int n=5;
//	int k=1;
//	for(int i=0;i<n;i++) {
//		k=i;
//		for(int j=1;j<=i;j++) {
//		System.out.print(a[k + 5 - j ]+" ");
//		}
//		System.out.println();
//	}
}
public static void close(int[] a,int x) {
	int min=Integer.MAX_VALUE;
	int temp1=0;
	int temp2=0;
	String ans="";
	for(int i=0;i<a.length;i++) {
		for(int j=i+1;j<a.length;j++) {
			int diff=Math.abs(x-(a[i]+a[j]));
			if(diff<min) {
				temp1=a[i];
				temp2=a[j];
				min=x-(a[i]+a[j]);
			}
		}
	}
	System.out.println(temp1+" "+temp2);
}
public static boolean subSetSum(int[] a) {
  int start1=0;
  int end1=1;
  int start2=2;
  int end2=a.length-1;
   Arrays.sort(a);
   return recur2(a,start1,end1,start2,end2);
}
public static boolean recur2(int[] a,int start1,int end1,int start2,int end2) {
	int ans1=0;
	int ans2=0;
	if(end1==a.length-1) {
		return false;
	}
	for(int i=start1;i<=end1;i++) {
		ans1=ans1+a[i];
	}
	for(int i=start2;i<=end2;i++) {
		ans2=ans2+a[i];
	}
	if(ans1==ans2) {
		return true;
	}
	
	return recur2(a,start1,end1+1,start2+1,end2);
}
public static int chocolates(int[] a,int m) {
	Arrays.sort(a);
	int start=0;
	int end=m;
	int min=Integer.MAX_VALUE;
			return recur(a,start,end,min);
}
public static int recur(int[] a,int start,int end,int min) {

	
	if(end==a.length-1) {
		return min;
		}
	int diff=a[end-1]-a[start];
	if(diff<min) {
		min=diff;
	}
	
	
	return recur(a,start+1,end+1,min);
	
}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        Map<String,String> map=new HashMap<>();
        map.put("ram", "syam");
        map.put("akil", "syam");
        map.put("nikil", "ram");
        map.put("subhash", "ram");
        map.put("karthik", "akil");
       
//        System.out.println("how many pairs do you want");
//        int n=sc.nextInt();
//        String[] child=new String[n];
//        String[] father=new String[n];
//        for(int i=0;i<n;i++) {
//        	System.out.println("enter childname");
//        	child[i]=sc.next();
//        	System.out.println("enter fathername");
//        	father[i]=sc.next();
//        }
//        ArrayList l=null;
//        for(int i=0;i<father.length;i++)
//    	{
//    		if(map.get(father[i])==null){
//    			l=new ArrayList();
//    			map.put(father[i],l);
//    			}
//    	 map.get(father[i]).add(child[i]);
//    		
//    		}
//      System.out.println("enter person name");
//       String p=sc.next();
//        System.out.println("enter level");
//        int level=sc.nextInt();
    //   grandFather(map,p,level);
        
//		List<Integer> one=new ArrayList<>();
//		int a=6;
//		for(int i=0;i<a;i++) {
//			one.add(sc.nextInt());
//		}
//		List<Integer> two=new ArrayList<>();
//		int b=5;
//		for(int i=0;i<b;i++) {
//			two.add(sc.nextInt());
//		}
		//union(one,two);
		//except(one,two);
		//intersect(one,two);
		int[] a=  {15, 5, 20, 10, 35, 15,10}  ;
		//System.out.println(chocolates(a,3));
		//System.out.println(subSetSum(a));
		//close(a,2);
		//printArray(a);
		//minDiff(a);
		
		//ascendingsBasedSum(a);
		//sum(25,25);
		//multipl(a);
		//leftRotation(a,2);
		//System.out.println(nonDecreasing(a));
	//	increasingSubSequences(a);
		//printDuplicates(a);
		//rotateLengthSize(a);
		//allPair(a);
	//	rotateOne(a);
		//String[] ar1= {"a","b","c","d" ,"e" ,"f" ,"g","h","i"};
		//String[] ar2= {"a","b","d","e","e","g","g","i","i"};
		//misMatch(ar1,ar2);
		System.out.println(subSetSum(a));
	}

}
