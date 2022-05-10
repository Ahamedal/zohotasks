package zoholevel2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CommonElement {
public Set<Integer> commonElement(int[] array1,int[] array2,int[] array3) {
	Set<Integer> list=new HashSet<>();

	
	for(int i=0;i<array1.length;i++) {
		boolean flag=true;
		for(int j=0;j<array2.length;j++) {
			if(!flag) {
				break;
			}
			if(array1[i]==array2[j]) {
			for(int k=0;k<array3.length;k++) {
			if(array2[j]==array3[k]) {
				list.add(array1[i]);
				flag=false;
				break;
			  }
			}
		}
		}
	}
	return list;
	
}
public void inputGenerator() {
	CommonElement obj1=new CommonElement();
	int[] array1= {1,5,10,20,40,80};
	int[] array2= {6,7,20,80,100};
	int[] array3= {3,4,15,20,30,70,80,120};
	System.out.println(obj1.commonElement(array1, array2, array3));
	
}
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	CommonElement obj=new CommonElement();
	obj.inputGenerator();
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
	System.out.println("How many integers do you want");
	int size3=sc.nextInt();
	sc.nextLine();
	int[] array3=new int[size3];
	System.out.println("Enter "+size3+" Integer value");
	for(int i=0;i<size3;i++) {
		array3[i]=sc.nextInt();
	}
	System.out.println(obj.commonElement(array1, array2, array3));
}
}
