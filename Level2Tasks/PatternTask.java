package Level2Tasks;

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
	diamondNumber(4);
}
}
