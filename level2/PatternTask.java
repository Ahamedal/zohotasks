package level2;

public class PatternTask {
	public static void pyramid(int n) {
		for(int i=1;i<=n;i++) {
			  for(int j=1;j<=n;j++)	{
				  if(j<=n-i) {
					  System.out.print(" ");
				  }
				  else {
					  System.out.print("* ");
				  }
			  }
			  System.out.println();
			}
	}
	public static void rightTriangle(int n) {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public static void leftTriangle(int n) {
		for(int i=1;i<=n;i++) {
		  for(int j=1;j<=n;j++)	{
			  if(j<=n-i) {
				  System.out.print(" ");
			  }
			  else {
				  System.out.print("*");
			  }
		  }
		  System.out.println();
		}
	}
	public static void diamondShape(int n) {
		for(int i=1;i<=n;i++) {
			  for(int j=1;j<=n+i-1;j++)	{
				  if(j<=n-i) {
					  System.out.print(" ");
				  }
				  else {
					  System.out.print("*");
				  }
			  }
			  System.out.println();
			}
		for(int i=n-1;i>0;i--) {
			  for(int j=1;j<=n+i-1;j++)	{
				  if(j<=n-i) {
					  System.out.print(" ");
				  }
				  else {
					  System.out.print("*");
				  }
			  }
			  System.out.println();
			}
		
//		for(int i=1;i<n;i++) {
//			  for(int j=1;j<=2*n-1;j++)	{
//				  if(i+j>2*n-1) {
//					  System.out.print(" ");
//				  }
//				  else if(i>=j) {
//					  System.out.print(" ");
//				  }
//				  else {
//					  System.out.print("*");
//				  }
//			  }
//			  System.out.println();
//			}
	}
	public static void rightPascal(int n) {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		for(int i=1;i<n;i++) {
			for(int j=n;j>i;j--) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	public static void sandGlassPattern(int n) {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(n-i<n-j) {
					System.out.print(" ");	
					}
				else {
					System.out.print("* ");
				}
				
			}
			System.out.println();
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(j<=n-i) {
				System.out.print(" ");	
				}
				else {
					System.out.print("* ");
				}
			}
			System.out.println();
		}
		
	}
	public static void trianglPattern(int n) {
		
		
		for(int i=1;i<=n;i++) {
		    for(int j=i;j<n;j++) {
		    	System.out.print(" ");
		    }
		    for(int k=1;k<=(2*i-1);k++) {
		    	if(k==1||i==n||k==(2*i-1)) {
		    		System.out.print("*");
		    	}
		    	else {
		    		System.out.print(" ");
		    	}
		    }
		    System.out.println();
		}
		
	}
	public static void diamondPattern(int n) {
		for(int i=1;i<=n;i++) {
			for(int j=i;j<n;j++) {
				System.out.print(" ");
			}
			for(int k=1;k<=(2*i-1);k++) {
				if(k==1||k==(2*i-1)) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		for(int i=n-1;i>0;i--) {
			for(int j=i;j<n;j++) {
				System.out.print(" ");
			}
			for(int k=1;k<=(2*i-1);k++) {
				if(k==1||k==(2*i-1)) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
	}
	public static void simpleNumber(int n) {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
	public static void pascalTriangl(int n) {

		for(int i=0;i<n;i++) {
			int Number=1;
			for(int j=i;j<n;j++) {
			System.out.print(" ");	
		}
			for(int k=0;k<=i;k++) {
				
					System.out.print(Number+" ");
				
				Number=Number*(i - k) / (k + 1);
			}
			
			System.out.println();
		}
	}
	public static void diamondNumber(int n) {
		for(int i=1;i<=n;i++) {
			int Number=1;
			for(int j=1;j<=n;j++) {
				
				if(i+j<=n) {
					System.out.print(" ");
				}
				else {
					System.out.print(n-j+1);
					
				}
			}
			for (int l = 2; l <= i; l++)   
			{  
			System.out.print(l);   
			}   
			System.out.println();
		}
		for(int i=n-1;i>0;i--) {
			int Number=1;
			for(int j=1;j<=n;j++) {
				
				if(i+j<=n) {
					System.out.print(" ");
				}
				else {
					System.out.print(n-j+1);
					
				}
			}
			for (int l = 2; l <= i; l++)   
			{  
			System.out.print(l);   
			}   
			System.out.println();
		}
		
	}
	public static void alternatingRectangle(int m,int n) {
		char[][] arr=new char[m][n];
		int k=0;
		int l=0;
		int r=m;
		int c=n;
		char x='X';
		while(k<m&&l<n) {
			for(int i=l;i<n;i++) {
				arr[k][i]=x;
			}
			k++;
			for(int i=k;i<m;i++) {
				arr[i][n-1]=x;
			}
			n--;
			
			for(int i=n;i>=l;i--) {
				arr[m-1][i]=x;
			}
			m--;
			
			
			for(int i=m;i>=k;i--) {
				arr[i][l]=x;
			}
			l++;
			
			if(x=='X') {
				x='0';
			}
			else {
				x='X';
			}
		}
		for (int i = 0; i < r; i++)
	    {
	        for (int j = 0; j < c; j++) {
	            System.out.print(arr[i][j] + " ");
	        }
	        System.out.println();
	    }
	}
	public static void spiralPattern(int n) {
		int rows=2*n-1;
		for(int i=1;i<=rows;i++) {
			for(int j=1;j<=rows;j++) {
				System.out.print(Math.max(Math.abs(n-i), Math.abs(n-j))+1);
			}
			System.out.println();
		}
	}
	public static void lookAndSequence(int n) {
		String resul="1";
        System.out.print(resul);
	    
        for(int i=1;i<n;i++){
            String next1="";
            int k=0;
            System.out.print(",");
        while(k<resul.length()){
            int no=1;
            while(k<resul.length()-1&&resul.charAt(k)==resul.charAt(k+1)){
                no++;
                k++;
                  }
                
                next1=next1+Integer.toString(no)+resul.charAt(k);
                k++;
                
            }
        System.out.print(next1);
            resul=next1;
        }
        
		
	}
	public static void zPattern(int n) {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(i==1||i==n||j==n+1-i) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	public static void spiralNumber(int n) {
		int[][] a=new int[n][n];
		int r=n;
		int c=n;
		int k=0;
		int l=0;
		int ans=1;
		int m=n;
		while(k<n) {
			for(int i=l;i<n;i++) {
				a[k][i]=ans;
				ans++;
			}
			k++;
			for(int i=k;i<m;i++) {
				a[i][n-1]=ans;
				ans++;
			}
			n--;
			for(int i=n-1;i>=l;i--) {
				a[m-1][i]=ans;
				ans++;
			}
			m--;
			for(int i=m-1;i>=k;i--) {
				a[i][l]=ans;
				ans++;
			}
			l++;
			
		}
		for (int i = 0; i < r; i++)
	    {
	        for (int j = 0; j < c; j++) {
	            System.out.print(a[i][j] + "  ");
	        }
	        System.out.println();
	    }
		
	}
	public static void arrayOfCharacter(String s) {
		int j=s.length()-1;
		int mid=s.length()/2;
		for(int i=0;i<=mid;i++) {
			System.out.print(s.charAt(i));
			if(j>mid) {
			System.out.print(s.charAt(j));
			}
			j--;
			System.out.println();
		}
		j++;
		for(int i=mid;i>0;i--) {
			System.out.print(s.charAt(i-1));
			System.out.print(s.charAt(j+1));
			j++;
			System.out.println();
		}
	}
public static void main(String[] args) {
	//pyramid(5);
	//rightTriangle(5);
	//leftTriangle(5);
	//diamondShape(5);
	//rightPascal(5);
	//sandGlassPattern(5);
	//trianglPattern(5);
	//diamondPattern(5);
	//simpleNumber(5);
	//pascalTriangl(5);
	//diamondNumber(4);
	//alternatingRectangle(3,4);
	//spiralPattern(4);
	//lookAndSequence(4);
	//zPattern(5);
	//spiralNumber(6);
	arrayOfCharacter("PROGRAM");
}
}

