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
		for(int i=1;i<n;i++) {
			  for(int j=1;j<=2*n-1;j++)	{
				  if(i+j>2*n-1) {
					  System.out.print(" ");
				  }
				  else if(i>=j) {
					  System.out.print(" ");
				  }
				  else {
					  System.out.print("*");
				  }
			  }
			  System.out.println();
			}
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
		
		int j=1;
		int h=(n/2)+1;
		int l=0;
		for(int i=1;i<=n;i++) {
		while(j<n) {
			if(j==h||j==l) {
				System.out.print("*");
				h=n+i;
				l=n-i;
				}
			else {
				System.out.print(" ");
			}
			j++;
		}
		}
	}
public static void main(String[] args) {
	//pyramid(5);
	//rightTriangle(5);
	//leftTriangle(5);
	//diamondShape(5);
	//rightPascal(5);
	//sandGlassPattern(5);
	trianglPattern(5);
}
}
