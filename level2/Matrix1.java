package level2;

import java.util.ArrayList;
import java.util.Arrays;

public class Matrix1 {
	  int sumOfMatrix(int row, int col, int[][] arr) {
	        // code here
	         int sum=0;
	         for(int i=0;i<row;i++){
	             for(int j=0;j<col;j++){
	                 sum=sum+arr[i][j];
	             }
	         }
	         return sum;
	    }
	  
	  static void rotate(int matrix[][]) 
	    {
	        // Code Here
	        int row=matrix.length;
	        int col=matrix[0].length;
	        
	       
	        for (int i = 0; i<col; i++) {
	           
	        for (int j = i; j < row; j++) {
	           int temp=matrix[i][j];
	           matrix[i][j]=matrix[j][i];
	           matrix[j][i]=temp;
	        
	            }
	          
	          
	        }
	        for(int i=0;i<row;i++){
	            int top=0;
	            int bottom=row-1;
	            while(top<bottom){
	                int temp=matrix[top][i];
	                matrix[top][i]=matrix[bottom][i];
	                matrix[bottom][i]=temp;
	                top++;
	                bottom--;
	            }
	        }
	    }
	  
	    static void transpose(int matrix[][], int n)
	    {
	        // code here
	        for(int i=0;i<n;i++){
	            for(int j=i;j<n;j++){
	                int temp=matrix[i][j];
	                matrix[i][j]=matrix[j][i];
	                matrix[j][i]=temp;
	            }
	        }
	    }
	    
	    public static ArrayList<ArrayList<Integer>> uniqueRow(int a[][],int r, int c)
	    {
	        //add code here.
	        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
	      
	        for(int i=0;i<r;i++){
	            int flag=0;
	            for(int j=0;j<i;j++){
	                flag=1;
	                for(int k=0;k<c;k++){
	                    if(a[j][k]!=a[i][k]){
	                        flag=0;
	                    }
	                }
	                    if(flag==1){
	                      break;  
	                    }
	                
	                
	            }
	            if(flag==0){
	                  ArrayList<Integer> arr=new ArrayList<>();
	                for(int j=0;j<c;j++){
	                    arr.add(a[i][j]);
	                }
	                
	           ans.add(arr);
	            }
	        }
	        return ans;
	    }
	    
	    public void setZeroes(int[][] matrix) {
	        int row=matrix.length;
	        int col=matrix[0].length;
	        int[][] temp=new int[row][col];
	      for(int i=0;i<row;i++){
	          for(int j=0;j<col;j++){
	              temp[i][j]=1;
	          }
	      }
	        for(int i=0;i<row;i++){
	            for(int j=0;j<col;j++){
	                if(matrix[i][j]==0){
	                    for(int k=0;k<col;k++){
	                        temp[i][k]=0;
	                    }
	                    for(int k=0;k<row;k++){
	                        temp[k][j]=0;
	                    }
	                }
	           }
	        }
	        for(int i=0;i<row;i++){
	            for(int j=0;j<col;j++){
	                if(temp[i][j]==0){
	                    matrix[i][j]=temp[i][j];
	                }
	            }
	        }
	    }
	    
	    static int isSuperSimilar(int n, int m, int mat[][], int x)
	    {
	        // code here
	        for(int i=0;i<mat.length;i++){
	            for(int j=0;j<mat[0].length;j++){
	                if(mat[i][(j+x)%m]!=mat[i][j]){
	                    return 0;
	                }
	            }
	        }
	        return 1;
	        
	    }
	    
	    static int[] x={-1,-1,-1,0,0,1,1,1};
	    static int[] y={-1,0,1,-1,1,-1,0,1};
	    
	    public int[][] searchWord(char[][] grid, String word)
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
	    
	public static void sortDiagonal(int[][] arrray) {
		int[] temp=new int[arrray.length];
		int k=0;
		for(int i=0;i<arrray.length;i++) {
			for(int j=0;j<arrray.length;j++) {
				if(i==j) {
				temp[k++]=arrray[i][j];
				}
			}
		}
		Arrays.sort(temp);
		k=0;
		for(int i=0;i<arrray.length;i++) {
			for(int j=0;j<arrray.length;j++) {
				if(i==j) {
					arrray[i][j]=temp[k++];
				}
			}
		}
		for(int i=0;i<arrray.length;i++) {
			for(int j=0;j<arrray.length;j++) {
				System.out.print(arrray[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void maximumOnes(int[][] ones,int m,int n) {
		int k=Integer.MIN_VALUE;
		int h=0;
		for(int i=0;i<m;i++) {
			int max=0;
			for(int j=0;j<n;j++) {
				max=max+ones[i][j];
			}
			if(max>k) {
				k=max;
				h=i;
			}
		}
		for(int j=0;j<n;j++) {
			ones[h][j]=0;
		}
		System.out.println(Arrays.deepToString(ones));
	}
	public static void main(String[] args) {
		int[][] a= {{0,1,1,1},{0,0,1,1},{1,1,1,1},{0,0,0,0}};
		//sortDiagonal(a);
		maximumOnes(a,4,4);
	}

}
