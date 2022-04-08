package Level2Tasks;

public class MiddlePattern {
	public static void middlePattern(String s){
		int mid=s.length()/2;
		String temp="";
		for(int i=mid;i<s.length();i++) {
			temp=temp+s.charAt(i);
			System.out.print(temp+"$ ");
		}
		for(int i=0;i<mid;i++) {
			temp=temp+s.charAt(i);
			System.out.print(temp+"$ ");
		}
	}
	public static void main(String[] args) {
		String s="PROGRAM";
		middlePattern(s);
		
	}

}
