package zoholevel2;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.Scanner;

public class MergingArray {
public int[] mergingArray(int n1,int n2,int[] array1,int[] array2) {
	int[] mergeArray=new int[n1+n2];
	int i=0;
	int j=0;
	int k=0;
	
	while(i<array1.length&&j<array2.length) {
		if(array1[i]<array2[j]) {
			mergeArray[k++]=array1[i++];
			
		}
		else {
			mergeArray[k++]=array2[j++];
		}
			
	}
	while(i<array1.length) {
		mergeArray[k++]=array1[i++];
	}
	while(j<array2.length) {
		mergeArray[k++]=array2[j++];
	}
	

int[] mergeArray2=new int[n1+n2];

int z=0;
	int mid=mergeArray.length/2;
	int m=mergeArray.length-1;
	for(int l=0;l<mid;l++) {
		mergeArray2[z++]=mergeArray[l];
	    mergeArray2[z++]=mergeArray[m];
	    m--;
	    
	}
	if((n1+n2)%2!=0) {
		mergeArray2[z]=mergeArray[mid];
	}
	return mergeArray2;
//	int j=array2.length-1;
//	
//	while(array1[array1.length-1]>array2[0]) {
//		if(array1[array1.length-1]>array2[0]) {
//			int temp=array1[array1.length-1];
//			array1[array1.length-1]=array2[0];
//			array2[0]=temp;
//			Arrays.sort(array1);
//			Arrays.sort(array2);
//			
//		}
//	}
//	
//List<Integer> list=new ArrayList<>();
//	for(int i=0;i<array1.length;i++) {
//		list.add(array1[i]);
//		if(j>=0) {
//		list.add(array2[j]);
//		j--;
//		}
//		
//	}
//	while(j>=0) {
//		list.add(array2[j]);
//		j--;
//	}
//	for(int i=0;i<list.size();i++) {
//		mergeArray[i]=list.get(i);
//	}
//	return mergeArray;
//	int i=0;
//	int j=0;
//	int k=0;
//	while(i<array1.length&&j<array2.length)
}
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	MergingArray obj=new MergingArray();
	System.out.println("How many integers do you want");
	int size1=sc.nextInt();
	sc.nextLine();
	int[] array1=new int[size1];
	System.out.println("Enter "+size1+" Integer value");
	for(int i=0;i<size1;i++) {
		array1[i]=sc.nextInt();
	}
	System.out.println("How many integers do you want");
	int size2=sc.nextInt();
	sc.nextLine();
	int[] array2=new int[size2];
	System.out.println("Enter "+size2+" Integer value");
	for(int i=0;i<size2;i++) {
		array2[i]=sc.nextInt();
	}
	System.out.println(Arrays.toString(obj.mergingArray(size1, size2, array1, array2)));
}
}
