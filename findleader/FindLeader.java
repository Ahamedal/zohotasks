package findleader;

import java.util.ArrayList;
import java.util.List;

public class FindLeader {
	static int k=1;
	public static void main(String[] args) {
		int[][] matrix= {{0,2,0,3,1},{4,1,2,0,0},{2,0,0,0,0},{0,1,0,2,3},{0,0,1,1,0}};
		boolean[][] visited=new boolean[5][5];
		List<Integer> ans=new ArrayList<>();
		int[][] temp=new int[5][5];
		FindLeader fl=new FindLeader();
		fl.countBuildings(matrix, ans, visited, 5, 5,temp);
		int z=fl.leaderOfGroup(ans, 5, 5);
		System.out.println("Leader of the group is "+z);
		List<Integer> lis2=new ArrayList<>();
		boolean[][] visited1=new boolean[5][5];
		fl.findShortest(temp,lis2,visited1,5,5,z);
		System.out.println(lis2);
		
	}
	static int sum=0;

	public void countBuildings(int[][] mat,List<Integer> ans,boolean[][] visited,int row,int col,int[][] temp) {
		 for(int i=0; i<row; i++)
	        {
	            for(int j=0; j<col; j++)
	            {

	                if(mat[i][j]!=0&&!visited[i][j])
	                {

	                    DFS(mat,i,j,visited,row,col,temp);
	                    ans.add(sum);
                        k++;
	                    //lis.add(sum);
	                    sum=0;
	                }

	            }
	        }
	}
	public void DFS(int[][] mat,int row,int col,boolean[][] visited,int rows,int columns,int[][] temp) {
		 int rowNbr[] = {-1, 0, 0,1};                                           //Move 4 direction
	        int colNbr[] = {0, -1, 1,0};
	        visited[row][col] = true;
	        
            temp[row][col]=k;
	        sum=sum+mat[row][col];                                                                //Depth First Search

	        for (int k = 0; k < 4; k++)
	        {
	            if (isSafe(mat, row + rowNbr[k], col + colNbr[k], visited,rows,columns))
	            {
	                DFS(mat, row + rowNbr[k], col + colNbr[k], visited,rows,columns,temp);
	            }
	        }
	}
	public boolean isSafe(int[][] mat,int row,int col,boolean[][] visited,int rows,int columns) {
		 if(row>=0&&row<rows&&col>=0&&col<columns&&(mat[row][col]!=0&&!visited[row][col]))
	        {
	            return true;
	        }
	        return false;
	}
	public int leaderOfGroup(List<Integer> ans,int rows,int columns)
    {

        int a=ans.get(0);
       
        for(int i=0; i<ans.size(); i++)
        {

            if(a<ans.get(i))
            {
                a=ans.get(i);
            }

        }

        return a;

    }
	static int count=0;
	public void findShortest(int[][] mat,List<Integer> ans,boolean[][] visited,int row,int col,int leader) {
		 for(int i=0; i<row; i++)
	        {
	            for(int j=0; j<col; j++)
	            {

	                if(mat[i][j]==1&&!visited[i][j])
	                {

	                    DFS1(mat,i,j,visited,row,col);
	                    ans.add(count);
                      
	                    //lis.add(sum);
	                    count=0;
	                }

	            }
	        }
	}
	public void DFS1(int[][] mat,int row,int col,boolean[][] visited,int rows,int columns) {
		    int rowNbr[] = {-1, 0, 0,1};                                           //Move 4 direction
	        int colNbr[] = {0, -1, 1,0};
	        visited[row][col] = true;
	        
            ++ count;                                                         //Depth First Search

	        for (int k = 0; k < 4; k++)
	        {
	            if (isSafe1(mat, row + rowNbr[k], col + colNbr[k], visited,rows,columns))
	            {
	            	DFS1(mat, row + rowNbr[k], col + colNbr[k], visited,rows,columns);
	            }else {
	            	break;
	            }
	        }
	}
	public boolean isSafe1(int[][] temp,int row,int col,boolean[][] visited,int rows,int columns) {
		if(row>=0&&row<5&&col>=0&&col<5&&temp[row][col]==0&&!visited[row][col]) {
			return true;
		}
		return false;
	}
}
